package br.com.coronapeak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.model.UsuarioToken;

@Repository
public interface UsuarioTokenRepository extends JpaRepository<UsuarioToken, Long>{
	
	public abstract Optional<UsuarioToken> findFirstByToken(String token);
	
}
