package com.docker.learning.convidados.domain.dto;

public record ConvidadoDTORequest(
        String nome,
        String email,
        String cpf,
        Long idConvite
) {
}
