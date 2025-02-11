package com.docker.learning.convidados.service;

import com.docker.learning.convidados.domain.dto.AnfitriaoDTORequest;
import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTORequest;
import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.model.Convite;
import com.docker.learning.convidados.repository.AnfitriaoRepository;
import com.docker.learning.convidados.repository.ConvidadoRepository;
import com.docker.learning.convidados.repository.ConviteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnfitriaoService {
    @Autowired
    private AnfitriaoRepository repository;

    @Transactional
    public Anfitriao post(AnfitriaoDTORequest dto){
        Anfitriao anfitriao = new Anfitriao();
        anfitriao.setNome(dto.nome());
        anfitriao.setEmail(dto.email());
        anfitriao.setCpf(dto.cpf());

        anfitriao.setDataCriacao(LocalDateTime.now());
        anfitriao.setTotalConvites(15);


        repository.save(anfitriao);

        return anfitriao;
    }

    // pensar nessa funcao
//    public int totalConvites(){
//        var dataValidade = LocalDateTime.now().plusDays(7);
//
//        if(!dataValidade.)
//    }

}
