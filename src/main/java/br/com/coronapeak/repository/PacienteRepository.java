package br.com.coronapeak.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.coronapeak.dto.DadosRelatorioDoisDTO;
import br.com.coronapeak.dto.DadosRelatorioQuatroDTO;
import br.com.coronapeak.dto.DadosRelatorioTresDTO;
import br.com.coronapeak.dto.DadosRelatorioUmDTO;
import br.com.coronapeak.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	public abstract Optional<Paciente> findFirstByCodigoUsuario(Long codigoUsuario);
	
	@Query("select new br.com.coronapeak.dto.DadosRelatorioUmDTO(P.id, P.nome) from Paciente as P where cast(extract(year from age(CURRENT_DATE, P.dataNascimento)) as integer) % 2 = 1 and exists (select PS from PacienteSintoma as PS join Sintoma as S on S.id = PS.codigoSintoma where PS.codigoPaciente = P.id and S.nome = 'Febre')")
	public abstract List<DadosRelatorioUmDTO> adquirirRelatorioUm();
	
	@Query("select new br.com.coronapeak.dto.DadosRelatorioDoisDTO(P.nome , C.nome) from Paciente as P join Cidade C on C.id = P.cidade join Questionario Q on Q.id = P.questionario where Q.flagPositivado = true and (select count(*) from PacienteSintoma PS where PS.codigoPaciente = P.id) > 0 and C.nome in ('Maravilha', 'Descanso', 'Pinhalzinho', 'Chapecó', 'Itapiranga') order by C.nome asc, P.nome desc")
	public abstract List<DadosRelatorioDoisDTO> adquirirRelatorioDois();
	
	@Query("select new br.com.coronapeak.dto.DadosRelatorioTresDTO(C.id, C.nome, count(*) as qt_susp) from Paciente P join Questionario Q on Q.id = P.questionario join Cidade C on C.id = P.cidade where Q.flagSuspeito = true and C.id = P.cidade group by C.id having count(*) > 0 order by qt_susp desc")
	public abstract List<DadosRelatorioTresDTO> adquirirRelatorioTres();
	
	@Query("select new br.com.coronapeak.dto.DadosRelatorioQuatroDTO(extract(year from age(CURRENT_DATE, P.dataNascimento)), count(*) as qt_casos) from Paciente P inner join Questionario Q on Q.id = P.questionario  where Q.flagPositivado = true group by extract(year from age(CURRENT_DATE, P.dataNascimento)) having count(*) > 0 order by qt_casos desc")
	public abstract List<DadosRelatorioQuatroDTO> adquirirRelatorioQuatro();
}
