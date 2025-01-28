package com.docker.learning.convidados.service;

import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.dto.ConvidadoDTOResponse;
import com.docker.learning.convidados.repository.ConvidadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {
    @Autowired
    private ConvidadoRepository repository;

//    @Transactional
//    public ConvidadoDTOResponse post(ConvidadoDTORequest convidado){
//        Convidado c = new Convidado();
//
//        c.setNome(convidado.nome());
//        c.setEmail(convidado.email());
//        c.setCpf(convidado.cpf());
//        c.getConvite();
//
//        repository.save(c);
//
//        return ConvidadoDTOResponse.valueOf(c);
//    }

}
