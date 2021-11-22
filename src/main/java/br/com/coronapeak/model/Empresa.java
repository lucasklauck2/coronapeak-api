package br.com.coronapeak.model;

import java.util.Date;

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
@Table(name =  "tb_empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_empresa", nullable = false)
	private Long id;
	
	@Column(name = "tx_nome", nullable = false)
	private String nome;
	
	@Column(name = "tx_cnpj", nullable = false)
	private String cnpj;

	@Column(name = "dt_abertura", nullable = false)
	private Date dataAbertura;
	
	@Column(name = "tx_fundador", nullable = false)
	private String nomeFundador;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade",foreignKey = @ForeignKey(name = "fk_empresa_cidade"))
	private Cidade cidade;
}
