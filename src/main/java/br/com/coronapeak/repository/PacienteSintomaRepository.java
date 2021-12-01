package br.com.coronapeak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.model.PacienteSintoma;

@Repository
public interface PacienteSintomaRepository extends JpaRepository<PacienteSintoma, Long>{

	public abstract List<PacienteSintoma> findAllByCodigoPaciente(Long codigoPaciente);
	
	public abstract void deleteAllByCodigoPaciente(Long codigoPaciete);
	
}
