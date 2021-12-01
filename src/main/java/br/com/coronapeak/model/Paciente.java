package br.com.coronapeak.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private Date dataNascimento;
	
	@Column(name = "qtd_peso", nullable = false)
	private Double peso;

	@Column(name = "qtd_altura", nullable = false)
	private Double altura;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_questionario")
	private Questionario questionario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente", orphanRemoval = true)
	private List<PacienteSintoma> listaPacienteSintoma;
	
	

}
