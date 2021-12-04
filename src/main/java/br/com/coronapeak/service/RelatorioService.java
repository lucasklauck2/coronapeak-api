package br.com.coronapeak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.DadosRelatorioDTO;
import br.com.coronapeak.repository.PacienteRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public DadosRelatorioDTO adquirirDados(){
		
		DadosRelatorioDTO dadosRelatorioDTO = new DadosRelatorioDTO();
		dadosRelatorioDTO.setListaDadosRelatorioUm(pacienteRepository.adquirirRelatorioUm());
		dadosRelatorioDTO.setListaDadosRelatorioDois(pacienteRepository.adquirirRelatorioDois());
		dadosRelatorioDTO.setListaDadosRelatorioTres(pacienteRepository.adquirirRelatorioTres());
		dadosRelatorioDTO.setListaDadosRelatorioQuatro(pacienteRepository.adquirirRelatorioQuatro());
		
		return dadosRelatorioDTO;
	}

}
