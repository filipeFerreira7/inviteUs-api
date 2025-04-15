package com.docker.learning.convidados.domain.dto;


import jakarta.validation.constraints.*;

public record ConvidadoDTORequest(

        @NotNull(message = "O campo nome é obrigatório")
        @NotBlank(message = "O campo nome não pode ser nulo")
        String nome,

        @NotNull(message = "O campo email é obrigatório")
        @NotBlank(message = "O campo nome não pode ser nulo")
        @Email(message = "O campo deve conter um email válido")
        String email,

        @NotNull(message = "O campo cpf é obrigatório")
        @NotBlank(message = "O campo cpf não pode estar em branco")
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
        String cpf,

        @NotNull(message = "O campo idConvite deve é obrigatório")
        Long idConvite
) {
}
