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
@Table(name =  "tb_paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_paciente", nullable = false)
	private Long id;
	
	@Column(name = "tx_nome", nullable = false)
	private String nome;
	
	@Column(name = "dt_nascimento", nullable = false)
	private String dataNascimento;
	
	@Column(name = "qtd_peso", nullable = false)
	private Double peso;

	@Column(name = "qtd_altura", nullable = false)
	private Double altura;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade",foreignKey = @ForeignKey(name = "fk_paciente_cidade"))
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa",foreignKey = @ForeignKey(name = "fk_paciente_empresa"))
	private Empresa empresa;

}
