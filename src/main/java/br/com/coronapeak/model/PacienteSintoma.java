package br.com.coronapeak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "id_pacientesintoma", nullable = false)
	private Long id;
	
	@Column(name="cd_intensidade", nullable = false)
	private Long codigoIntensidade;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente",foreignKey = @ForeignKey(name = "fk_pacisint_paciente"))
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_sintoma",foreignKey = @ForeignKey(name = "fk_pacisint_sintoma"))
	private Sintoma sintomas;
}
