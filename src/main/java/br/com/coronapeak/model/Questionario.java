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
@Table(name =  "tb_questionario")
public class Questionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_questionario", nullable = false)
	private Long id;
	
	@Column(name="fl_positivado", nullable = false)
	private Boolean flagPositivado;
	
	@Column(name="fl_suspeito", nullable = false)
	private Boolean flagSuspeito;
	
	@Column(name="fl_doencarespiratoria", nullable = false)
	private Boolean flagDoencaRespiratoria;
}
