package com.docker.learning.convidados.domain.dto;

import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.model.Convite;

import java.time.LocalDateTime;

public record ConviteDTOResponse(
        Long id,
        Long idAnfitriao,
        LocalDateTime data
) {
    public static ConviteDTOResponse valueOf(Convite convite) {

        return new ConviteDTOResponse(
                convite.getId(),
                convite.getIdAnfitriao(),
                convite.getData()
        );
    }
}
