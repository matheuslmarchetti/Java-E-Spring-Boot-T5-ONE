package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank //verifica se o campo não é nulo e nem vazio para Strings
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //expressão regular de dígitos com extensão de 4 a 6
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid // para validar os dados do DTO DadosEndereco
        DadosEndereco endereco
) {
}
