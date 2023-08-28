package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data
) {
}
