package br.com.coronapeak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "tb_pacientesintoma")
public class PacienteSintoma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pacientesintoma")
	private Long id;
	
	@Column(name = "cd_paciente")
	private Long codigoPaciente;
	
	@Column(name = "cd_sintoma")
	private Long codigoSintoma;
}
