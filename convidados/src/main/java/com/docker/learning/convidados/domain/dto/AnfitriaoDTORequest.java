package com.docker.learning.convidados.domain.dto;

public record AnfitriaoDTORequest(
        String nome,
        String email,
        String cpf
) {
}
