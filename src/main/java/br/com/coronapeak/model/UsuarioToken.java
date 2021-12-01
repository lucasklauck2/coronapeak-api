package br.com.coronapeak.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "tb_usuariotoken")
public class UsuarioToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_token", nullable = false)
	private Long id;
	
	@Column(name = "tx_email", nullable = false)
	private String email;
	
	@Column(name = "tx_token", nullable = false)
	private String token;
	
	@Column(name = "dt_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
	private Date dataCadastro;

}
