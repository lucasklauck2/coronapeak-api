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

import br.com.coronapeak.dto.SintomaDTO;
import br.com.coronapeak.service.SintomaService;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {
	
	@Autowired
	private SintomaService sintomaService;
	
	@PostMapping("/salvar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void cadastrar(@RequestBody SintomaDTO sintomaDTO) {
		
		sintomaService.cadastrar(sintomaDTO);
	}
	
	@GetMapping("/adquirirTodos")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public List<SintomaDTO> adquirir() {
		
		return sintomaService.adquirir();
	}
	
	@DeleteMapping("/deletar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void deletar(@RequestParam Long codigoSintoma) {
		
		sintomaService.deletar(codigoSintoma);
	}
	
}
