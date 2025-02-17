package com.docker.learning.convidados.domain.dto;

import com.docker.learning.convidados.domain.model.Anfitriao;

import java.time.LocalDateTime;

public record ConviteDTORequest(
        Long idAnfitriao
) {
}
