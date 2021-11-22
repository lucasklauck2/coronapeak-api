package br.com.coronapeak.dto;

import java.util.Date;

import lombok.Data;

@Data
public class RegistroDTO {
	
	private String nome;
	private String email;
	private String senha;
	private Date dataNascimento;
}
