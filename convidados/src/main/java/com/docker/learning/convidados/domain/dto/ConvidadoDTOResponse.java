package com.docker.learning.convidados.domain.dto;

import com.docker.learning.convidados.domain.model.Convidado;

public record ConvidadoDTOResponse(
        Long id,
       String nome,
        String email,
        String cpf,
        Long idConvite) {
    public static ConvidadoDTOResponse valueOf(Convidado convidado) {

        return new ConvidadoDTOResponse(
                convidado.getId(),
                convidado.getNome(),
                convidado.getEmail(),
                convidado.getCpf(),
               convidado.getConvite().getId()
        );
    }
}
