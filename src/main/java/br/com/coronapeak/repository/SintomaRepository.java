package br.com.coronapeak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.model.Sintoma;

@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, Long>{

}
