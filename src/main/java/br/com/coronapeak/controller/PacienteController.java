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

import br.com.coronapeak.dto.InformacaoPacienteDTO;
import br.com.coronapeak.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping("/salvar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void cadastrarPaciente(@RequestBody InformacaoPacienteDTO informacaoPacienteDTO) {
		
		pacienteService.cadastrarPaciente(informacaoPacienteDTO);
	}
	
	@GetMapping("/adquirirTodos")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public List<InformacaoPacienteDTO> adquirir() {
		
		return pacienteService.adquirir();
	}
	
	@DeleteMapping("/deletar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void deletar(@RequestParam("codigoPaciente") String codigoPaciente) {
		
		pacienteService.deletar(Long.valueOf(codigoPaciente));
	}
	
	@GetMapping("/validarQuestionario")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Boolean validarQuestionario(@RequestParam("token") String token) {
		
		return pacienteService.validarQuestionario(token);
	}
}
