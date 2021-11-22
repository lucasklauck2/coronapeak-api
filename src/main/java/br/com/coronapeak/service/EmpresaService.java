package br.com.coronapeak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.EmpresaDTO;
import br.com.coronapeak.model.Empresa;
import br.com.coronapeak.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void cadastrarEmpresa(EmpresaDTO empresaDTO) {
		
		Empresa empresa = new Empresa();
		empresa.setNome(empresaDTO.getNome());
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setDataAbertura(empresaDTO.getDataAbertura());
		empresa.setNomeFundador(empresaDTO.getNomeFundador());
		
		empresaRepository.save(empresa);
	}

}
