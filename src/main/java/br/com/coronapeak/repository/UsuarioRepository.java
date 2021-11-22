package br.com.coronapeak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public abstract Optional<Usuario> findFirstByEmailAndSenha(String email, String senha);
	
	public abstract Optional<Usuario> findFirstByEmail(String email);

}
