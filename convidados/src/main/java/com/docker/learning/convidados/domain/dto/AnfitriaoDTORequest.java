package com.docker.learning.convidados.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AnfitriaoDTORequest(

        @NotNull(message = "O campo nome é obrigatório")
        @NotBlank(message = "O campo nome não pode estar em branco")
        String nome,
        @NotNull(message = "O campo email é obrigatório")
        @NotBlank(message = "O campo nome não pode estar em branco")
        @Email(message = "O campo deve conter um email válido")
        String email,
        @NotNull(message = "O campo cpf é obrigatório")
        @NotBlank(message = "O campo cpf não pode estar em branco")
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
        String cpf
) {
}
