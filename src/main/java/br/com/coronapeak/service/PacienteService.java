package br.com.coronapeak.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.InformacaoPacienteDTO;
import br.com.coronapeak.model.Paciente;
import br.com.coronapeak.model.PacienteSintoma;
import br.com.coronapeak.model.Questionario;
import br.com.coronapeak.repository.CidadeRepository;
import br.com.coronapeak.repository.EmpresaRepository;
import br.com.coronapeak.repository.PacienteRepository;
import br.com.coronapeak.repository.PacienteSintomaRepository;
import br.com.coronapeak.repository.QuestionarioRepository;
import br.com.coronapeak.repository.SintomaRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private QuestionarioRepository questionarioRepository;

	@Autowired
	private SintomaRepository sintomaRepository;

	@Autowired
	private PacienteSintomaRepository pacienteSintomaRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Transactional
	public void cadastrarPaciente(InformacaoPacienteDTO informacaoPacienteDTO) {

		Paciente paciente = new Paciente();
		paciente.setId(informacaoPacienteDTO.getId());
		paciente.setNome(informacaoPacienteDTO.getNome());
		paciente.setDataNascimento(informacaoPacienteDTO.getDataNascimento());
		paciente.setPeso(informacaoPacienteDTO.getPeso());
		paciente.setAltura(informacaoPacienteDTO.getAltura());
		paciente.setCidade(cidadeRepository.findById(informacaoPacienteDTO.getCodigoCidade()).orElse(null));
		paciente.setEmpresa(empresaRepository.findById(informacaoPacienteDTO.getCodigoEmpresa()).orElse(null));

		paciente = pacienteRepository.save(paciente);

		Questionario questionario = new Questionario();
		questionario.setFlagPositivado(informacaoPacienteDTO.getFlagPositivado());
		questionario.setFlagSuspeito(informacaoPacienteDTO.getFlagSuspeito());
		questionario.setFlagDoencaRespiratoria(informacaoPacienteDTO.getFlagDoencaRespiratoria());

		questionarioRepository.save(questionario);

		paciente.setQuestionario(questionario);

		pacienteRepository.save(paciente);
		
		pacienteSintomaRepository.deleteAllByCodigoPaciente(paciente.getId());

		List<PacienteSintoma> listaPacienteSintoma = new ArrayList<>();

		for (Long codigoSintoma : informacaoPacienteDTO.getListaSintoma()) {

			PacienteSintoma pacienteSintoma = new PacienteSintoma();
			pacienteSintoma.setCodigoPaciente(paciente.getId());
			pacienteSintoma.setCodigoSintoma(sintomaRepository.findById(codigoSintoma).orElse(null).getId());

			listaPacienteSintoma.add(pacienteSintoma);
		}

		pacienteSintomaRepository.saveAll(listaPacienteSintoma);
	}

	public List<InformacaoPacienteDTO> adquirir() {

		List<Paciente> listaPaciente = pacienteRepository.findAll();

		List<InformacaoPacienteDTO> listaInformacaoPaciente = new ArrayList<>();

		listaPaciente.forEach(paciente -> {

			InformacaoPacienteDTO informacaoPaciente = new InformacaoPacienteDTO();
			informacaoPaciente.setId(paciente.getId());
			informacaoPaciente.setNome(paciente.getNome());
			informacaoPaciente.setDataNascimento(paciente.getDataNascimento());
			informacaoPaciente.setPeso(paciente.getPeso());
			informacaoPaciente.setAltura(paciente.getAltura());
			informacaoPaciente.setFlagPositivado(paciente.getQuestionario().getFlagPositivado());
			informacaoPaciente.setFlagSuspeito(paciente.getQuestionario().getFlagSuspeito());
			informacaoPaciente.setFlagDoencaRespiratoria(paciente.getQuestionario().getFlagDoencaRespiratoria());
			informacaoPaciente.setListaSintoma(pacienteSintomaRepository.findAllByCodigoPaciente(paciente.getId())
					.stream().map(PacienteSintoma::getCodigoSintoma).collect(Collectors.toList()));
			
			if(cidadeRepository.existsById(paciente.getCidade().getId())) {
				
				informacaoPaciente.setCodigoCidade(paciente.getCidade().getId());
			}
			
			if(empresaRepository.existsById(paciente.getEmpresa().getId())) {
				
				informacaoPaciente.setCodigoEmpresa(paciente.getEmpresa().getId());
			}

			listaInformacaoPaciente.add(informacaoPaciente);
		});

		return listaInformacaoPaciente;
	}

	public void deletar(Long codigoCidade) {

		pacienteRepository.deleteById(codigoCidade);
	}
}
