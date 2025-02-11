package com.docker.learning.convidados.controller;

import com.docker.learning.convidados.domain.dto.AnfitriaoDTORequest;
import com.docker.learning.convidados.domain.dto.ConvidadoDTORequest;
import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.repository.AnfitriaoRepository;
import com.docker.learning.convidados.repository.ConvidadoRepository;
import com.docker.learning.convidados.service.AnfitriaoService;
import com.docker.learning.convidados.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anfitrioes")
@CrossOrigin("*")
public class AnfitriaoController {

    @Autowired
    private AnfitriaoRepository repository;

    @Autowired
    private AnfitriaoService service;

    @GetMapping
    public List<Anfitriao> getConvidados(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity postConvidado(@RequestBody AnfitriaoDTORequest dto){
        var post = service.post(dto);

        return ResponseEntity.ok(post);
    }

}