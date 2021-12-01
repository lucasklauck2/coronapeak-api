package br.com.coronapeak.dto;

import lombok.Data;

@Data
public class UsuarioInformacaoDTO {

	private String nome;
	private String email;
	private Long codigoTipoUsuario;
	private String novaSenha;
	private String dataNascimento;
	private String dataCadastro;
	private String senhaAtual;
	private String token;
}
