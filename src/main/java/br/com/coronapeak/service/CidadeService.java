package br.com.coronapeak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.CidadeDTO;
import br.com.coronapeak.model.Cidade;
import br.com.coronapeak.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void cadastrarCidade(CidadeDTO cidadeDTO) {
		
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeDTO.getNome());
		cidade.setEstado(cidadeDTO.getEstado());
		cidade.setSigla(cidadeDTO.getSigla());
		
		cidadeRepository.save(cidade);
	}

}
