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
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	private Long id;
	
	@Column(name = "tx_nome", nullable = false)
	private String nome;
	
	@Column(name = "tx_email", nullable = false)
	private String email;
	
	@Column(name = "tx_senha", nullable = false)
	private String senha;
	
	@Column(name = "cd_tipousuario", nullable = false)
	private Long codigoTipoUsuario;
	
	@Column(name = "dt_nascimento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(name = "dt_manutencao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
	private Date dataManutencao;
	
	@Column(name = "dt_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
	private Date dataCadastro;

}
