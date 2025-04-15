package com.docker.learning.convidados.domain.service;

import com.docker.learning.convidados.domain.dto.ConvidadoDTOResponse;
import com.docker.learning.convidados.domain.dto.ConviteDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTOResponse;
import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.model.Convite;
import com.docker.learning.convidados.domain.repository.AnfitriaoRepository;
import com.docker.learning.convidados.domain.repository.ConvidadoRepository;
import com.docker.learning.convidados.domain.repository.ConviteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConvidadoService {
    @Autowired
    private ConvidadoRepository repository;
    @Autowired
    private ConviteRepository conviteRepository;

    @Autowired
    private AnfitriaoService anfitriaoService;

    @Autowired
    private AnfitriaoRepository anfitriaoRepository;

    @Transactional
    public ConvidadoDTOResponse post(ConvidadoDTORequest convidado){
        Convidado c = new Convidado();
        c.setNome(convidado.nome());
        c.setEmail(convidado.email());
        c.setCpf(convidado.cpf());
        var convite = conviteRepository.findById(convidado.idConvite())
                .orElseThrow(() -> new EntityNotFoundException("Convite não encontrado"));

        c.setConvite(convite);

        repository.save(c);

        return ConvidadoDTOResponse.valueOf(c);
    }



}
