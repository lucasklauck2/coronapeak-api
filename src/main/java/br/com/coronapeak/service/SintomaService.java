package br.com.coronapeak.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.SintomaDTO;
import br.com.coronapeak.model.Sintoma;
import br.com.coronapeak.repository.SintomaRepository;

@Service
public class SintomaService {
	
	@Autowired
	private SintomaRepository sintomaRepository;
	
	public void cadastrar(SintomaDTO sintomaDTO) {
		
		Sintoma sintoma = new Sintoma();
		sintoma.setNome(sintomaDTO.getNome());
		sintoma.setId(sintomaDTO.getId());
		
		sintomaRepository.save(sintoma);
	}
	
	public List<SintomaDTO> adquirir(){
		
		List<Sintoma> listaSintoma = sintomaRepository.findAll();
		
		return listaSintoma.stream().map(sintoma -> new SintomaDTO(sintoma.getId(), sintoma.getNome())).collect(Collectors.toList());
	}
	
	public void deletar(Long codigoSintoma){
		
		sintomaRepository.deleteById(codigoSintoma);
	}

}
