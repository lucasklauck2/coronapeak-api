package br.com.coronapeak.dto;


import java.util.Date;

import lombok.Data;

@Data
public class PacienteDTO {

	private Long id;
	private String nome;
	private Date dataNascimento;
	private Double peso;
	private Double altura;
	private Long codigoCidade;
	private Long codigoEmpresa;
}
