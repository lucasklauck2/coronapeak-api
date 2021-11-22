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
@Table(name =  "tb_cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cidade", nullable = false)
	private Long id;
	
	@Column(name = "tx_nome", nullable = false)
	private String nome;
	
	@Column(name = "tx_estado", nullable = false)
	private String estado;
	
	@Column(name = "tx_sigla", nullable = false)
	private String sigla;

}
