package com.docker.learning.convidados.controller;

import java.util.List;

import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.repository.ConvidadoRepository;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convidados")
@CrossOrigin("*")
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repository;

    @Autowired
    private ConvidadoService service;

    @GetMapping
    public List<Convidado> getConvidados(){
        return repository.findAll();
    }

}