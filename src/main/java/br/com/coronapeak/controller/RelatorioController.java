package br.com.coronapeak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coronapeak.dto.DadosRelatorioDTO;
import br.com.coronapeak.service.RelatorioService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioService relatorioService;

	@GetMapping("/adquirirDados")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public DadosRelatorioDTO adquirirDados() {
		
		return relatorioService.adquirirDados();
	}
	
}
