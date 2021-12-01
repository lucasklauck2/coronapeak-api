package br.com.coronapeak.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InformacaoPacienteDTO {

	private Long id;
	private String nome;
	private Date dataNascimento;
	private Double peso;
	private Double altura;
	private Long codigoCidade;
	private Long codigoEmpresa;
	private Boolean flagPositivado;
	private Boolean flagSuspeito;
	private Boolean flagDoencaRespiratoria;
	private List<PacienteSintomaDTO> listaPacienteSintomaDTO = new ArrayList<>();
	private List<Long> listaSintoma = new ArrayList<>();
}
