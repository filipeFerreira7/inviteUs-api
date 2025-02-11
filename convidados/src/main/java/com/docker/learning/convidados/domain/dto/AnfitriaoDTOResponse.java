package com.docker.learning.convidados.domain.dto;

import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convite;

import java.time.LocalDateTime;

public record AnfitriaoDTOResponse(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public static AnfitriaoDTOResponse valueOf(Anfitriao anfitriao) {

        return new AnfitriaoDTOResponse(
                anfitriao.getId(),
                anfitriao.getNome(),
                anfitriao.getEmail(),
                anfitriao.getCpf()
        );
    }
}
