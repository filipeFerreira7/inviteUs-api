package com.docker.learning.convidados.service;

import com.docker.learning.convidados.domain.dto.ConviteDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTOResponse;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.dto.ConvidadoDTOResponse;
import com.docker.learning.convidados.domain.model.Convite;
import com.docker.learning.convidados.repository.AnfitriaoRepository;
import com.docker.learning.convidados.repository.ConvidadoRepository;
import com.docker.learning.convidados.repository.ConviteRepository;
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
    private AnfitriaoRepository anfitriaoRepository;

    @Transactional
    public Convidado post(ConvidadoDTORequest convidado){
        Convidado c = new Convidado();
        c .setNome(convidado.nome());
        c.setEmail(convidado.email());
        c.setCpf(convidado.cpf());

        ConviteDTORequest dto = new ConviteDTORequest(LocalDateTime.now(),26L);
        var convite = postConvite(dto);

        c.setConvite(convite);


        repository.save(c);

        return c;
    }

// estou gerando um convite na classe convidado apenas para teste
    @Transactional
    public Convite postConvite(ConviteDTORequest convite){
        Convite c = new Convite();
        c.setData(convite.data());
        c.setIdAnfitriao(convite.anfitriao());

        conviteRepository.save(c);

        return c;
    }

}
