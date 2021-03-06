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

import br.com.coronapeak.dto.EmpresaDTO;
import br.com.coronapeak.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/salvar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void cadastrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
		
		empresaService.cadastrarEmpresa(empresaDTO);
	}
	
	@GetMapping("/adquirirTodas")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public List<EmpresaDTO> adquirir() {
		
		return empresaService.adquirir();
	}
	
	@DeleteMapping("/deletar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void deletar(@RequestParam("codigoEmpresa") String codigoEmpresa) {
		
		empresaService.deletar(Long.valueOf(codigoEmpresa));
	}
}
