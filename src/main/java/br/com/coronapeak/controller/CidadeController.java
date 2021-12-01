package br.com.coronapeak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.coronapeak.dto.CidadeDTO;
import br.com.coronapeak.model.Cidade;
import br.com.coronapeak.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping("/salvar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Cidade cadastrarEmpresas(@RequestBody CidadeDTO cidadeDTO) {
		
		return cidadeService.cadastrarCidade(cidadeDTO);
	}
	
	@GetMapping("/adquirirTodas")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public List<CidadeDTO> adquirir() {
		
		return cidadeService.adquirir();
	}
	
	@DeleteMapping("/deletar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void deletar(@RequestParam("codigoCidade") String codigoCidade) {
		
		cidadeService.deletar(Long.valueOf(codigoCidade));
	}
	
}
