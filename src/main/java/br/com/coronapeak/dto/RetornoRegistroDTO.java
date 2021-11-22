package br.com.coronapeak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoRegistroDTO {
	
	private String mensagem;
	private String token;
}
