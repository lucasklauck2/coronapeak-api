package br.com.coronapeak.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmpresaDTO {

	private String nome;
	private String cnpj;
	private Date dataAbertura;
	private String nomeFundador;
	private Long codigoCidade;
}
