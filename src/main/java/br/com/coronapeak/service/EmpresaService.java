package br.com.coronapeak.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.EmpresaDTO;
import br.com.coronapeak.model.Empresa;
import br.com.coronapeak.repository.CidadeRepository;
import br.com.coronapeak.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	ModelMapper modelMapper = new ModelMapper();

	public void cadastrarEmpresa(EmpresaDTO empresaDTO) {

		Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
		empresa.setCodigoCidade(empresaDTO.getCodigoCidade());

		empresaRepository.save(empresa);
	}

	public List<EmpresaDTO> adquirir() {

		List<Empresa> listaEmpresa = empresaRepository.findAll();

		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<>();

		listaEmpresa.forEach(empresa -> {
			
			EmpresaDTO empresaDTO = new EmpresaDTO();
			empresaDTO.setId(empresa.getId());
			empresaDTO.setNome(empresa.getNome());
			empresaDTO.setCnpj(empresa.getCnpj());
			empresaDTO.setDataAbertura(empresa.getDataAbertura());
			empresaDTO.setNomeFundador(empresa.getNomeFundador());
			
			if(cidadeRepository.existsById(empresa.getCodigoCidade())) {
				empresaDTO.setCodigoCidade(empresa.getCodigoCidade());
			}
			
			listaEmpresaDTO.add(empresaDTO);
		});

		return listaEmpresaDTO;
	}

	public void deletar(Long codigoCidade) {

		empresaRepository.deleteById(codigoCidade);
	}

}
