package br.com.coronapeak.dto;


import lombok.Data;

@Data
public class CidadeDTO {

	private Long id;
	private String nome;
	private String estado;
	private String sigla;
}
