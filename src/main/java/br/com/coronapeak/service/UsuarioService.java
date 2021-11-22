package br.com.coronapeak.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coronapeak.dto.UsuarioInformacaoDTO;
import br.com.coronapeak.model.Usuario;
import br.com.coronapeak.model.UsuarioToken;
import br.com.coronapeak.repository.UsuarioRepository;
import br.com.coronapeak.repository.UsuarioTokenRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioTokenRepository usuarioTokenRepository;

	public UsuarioInformacaoDTO adquirirDados(String token) {
		
		Optional<UsuarioToken> optUsuarioToken = usuarioTokenRepository.findFirstByToken(token);
		
		if (!optUsuarioToken.isPresent()) {

			this.retornarErro("Token inválido!");
		}
		
		String email = optUsuarioToken.get().getEmail();
		
		Optional<Usuario> optUsuario = usuarioRepository.findFirstByEmail(email);
		
		if (!optUsuario.isPresent()) {

			this.retornarErro("Conta não encontrada!");
		}
		
		Usuario usuario = optUsuario.get();
		
		UsuarioInformacaoDTO usuarioInformacaoDTO = new UsuarioInformacaoDTO();
		usuarioInformacaoDTO.setEmail(usuario.getEmail());
		usuarioInformacaoDTO.setNome(usuario.getNome());
		usuarioInformacaoDTO.setDataCadastro(this.converterDataString(usuario.getDataCadastro()));
		usuarioInformacaoDTO.setDataNascimento(this.converterDataString(usuario.getDataNascimento()));
		
		return usuarioInformacaoDTO;
	}
	
	public void salvarDados(UsuarioInformacaoDTO usuarioInformacaoDTO) throws ParseException {
		
		Optional<UsuarioToken> optUsuarioToken = usuarioTokenRepository.findFirstByToken(usuarioInformacaoDTO.getToken());
		
		if(!optUsuarioToken.isPresent()) {
			
			this.retornarErro("Token inválido!");
		}
		
		Optional<Usuario> optUsuario = usuarioRepository.findFirstByEmail(optUsuarioToken.get().getEmail());
		
		if(!optUsuario.isPresent()) {
			
			this.retornarErro("Usuário não encontrado para o token fornecido!");
		}
		
		Usuario usuario = optUsuario.get();

		if(usuario.getEmail() != usuarioInformacaoDTO.getEmail()) {
			
			if(usuarioRepository.findFirstByEmail(optUsuarioToken.get().getEmail()).isPresent()) {
				this.retornarErro("Este e-mail já está sendo usado por outra conta!");
			}
		}
		
		usuario.setNome(usuarioInformacaoDTO.getNome());
		usuario.setEmail(usuarioInformacaoDTO.getEmail());
		usuario.setSenha(usuarioInformacaoDTO.getNovaSenha());
		usuario.setDataNascimento(this.converterStringData(usuarioInformacaoDTO.getDataNascimento()));
		
		usuarioRepository.save(usuario);
	}
	
	private void retornarErro(String mensagem) {
		
		throw new RuntimeException(mensagem);
	}
	
	private Date converterStringData(String dataNascimento) throws ParseException {
		
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		return formatador.parse(dataNascimento);
	}


	private String converterDataString(Date data) {
		
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  

		return formatador.format(data); 
	}
}
