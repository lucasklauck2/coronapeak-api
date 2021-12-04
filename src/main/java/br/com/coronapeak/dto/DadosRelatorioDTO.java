package br.com.coronapeak.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosRelatorioDTO {

	private List<DadosRelatorioUmDTO> listaDadosRelatorioUm;
	private List<DadosRelatorioDoisDTO> listaDadosRelatorioDois;
	private List<DadosRelatorioTresDTO> listaDadosRelatorioTres;
	private List<DadosRelatorioQuatroDTO> listaDadosRelatorioQuatro;
}
