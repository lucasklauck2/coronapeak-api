package br.com.coronapeak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coronapeak.dto.EmpresaDTO;
import br.com.coronapeak.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/cadastrar")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public void cadastrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
		
		empresaService.cadastrarEmpresa(empresaDTO);
	}
}
