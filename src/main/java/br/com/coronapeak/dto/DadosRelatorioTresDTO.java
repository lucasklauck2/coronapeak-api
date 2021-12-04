package br.com.coronapeak.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DadosRelatorioTresDTO {

	private Long codigoCidade;
	private String nomeCidade;
	private Long quantidadeSuspeito;
}
