package br.com.coronapeak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.model.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long>{

}
