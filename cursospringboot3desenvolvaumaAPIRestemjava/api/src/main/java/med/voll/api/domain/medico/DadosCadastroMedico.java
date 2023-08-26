package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank(message = "{nome.obrigatorio}") //verifica se o campo não é nulo e nem vazio para Strings
        String nome,

        //@NotBlank(message = "Email é obrigatório")
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotBlank(message = "{telefone.obrigatorio}")
        String telefone,

        @NotBlank(message = "{crm.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}") //expressão regular de dígitos com extensão de 4 a 6
        String crm,

        @NotNull(message = "{especialidade.obrigatoria}")
        Especialidade especialidade,

        @NotNull(message = "{endereco.obrigatorio}")
        @Valid // para validar os dados do DTO DadosEndereco
        DadosEndereco endereco
) {
}
