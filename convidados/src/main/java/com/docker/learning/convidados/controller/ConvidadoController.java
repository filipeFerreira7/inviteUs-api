package com.docker.learning.convidados.controller;

import java.util.List;

import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.repository.ConvidadoRepository;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.service.ConvidadoService;
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

    @PostMapping
    public ResponseEntity postConvidado(@RequestBody ConvidadoDTORequest convidadoDTORequest){
        var post = service.post(convidadoDTORequest);

        return ResponseEntity.ok(post);
    }

}