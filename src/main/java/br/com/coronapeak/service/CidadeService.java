package br.com.coronapeak.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.CidadeDTO;
import br.com.coronapeak.model.Cidade;
import br.com.coronapeak.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public Cidade cadastrarCidade(CidadeDTO cidadeDTO) {
			
		return cidadeRepository.save(modelMapper.map(cidadeDTO, Cidade.class));
	}
	
	public List<CidadeDTO> adquirir(){
		
		List<Cidade> listaCidade = cidadeRepository.findAll();
		
		List<CidadeDTO> listaCidadeDTO = new ArrayList<>();
		
		listaCidade.forEach(cidade -> {
			
			CidadeDTO cidadeDTO = new CidadeDTO();
			cidadeDTO.setId(cidade.getId());
			cidadeDTO.setNome(cidade.getNome());
			cidadeDTO.setEstado(cidade.getEstado());
			cidadeDTO.setSigla(cidade.getSigla());
			
			listaCidadeDTO.add(cidadeDTO);
		});
		
		return listaCidadeDTO;
	}

	public void deletar(Long codigoCidade) {
		
		cidadeRepository.deleteById(codigoCidade);
	}
}
