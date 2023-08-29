package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select medico from Medico medico
            where
            medico.ativo = true
            and
            medico.especialidade = :especialidade
            and
            medico.id not  in(
                select consulta.medico.id from Consulta consulta
                where
                consulta.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select medico.ativo
            from Medico medico
            where
            medico.id = :id
            """)
    boolean findAtivoById(Long idMedico);
}
