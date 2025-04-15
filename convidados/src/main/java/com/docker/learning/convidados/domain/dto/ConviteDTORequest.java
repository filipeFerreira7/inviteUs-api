package com.docker.learning.convidados.domain.dto;

import com.docker.learning.convidados.domain.model.Anfitriao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ConviteDTORequest(

        @NotNull(message = "O campo idConvite deve é obrigatório")
        @Size(min = 1, max = 1, message = "O campo id convite pode ter apenas um número")
        Long idAnfitriao
) {
}
