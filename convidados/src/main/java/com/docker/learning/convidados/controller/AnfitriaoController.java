package com.docker.learning.convidados.controller;

import com.docker.learning.convidados.domain.dto.AnfitriaoDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTOResponse;
import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convite;
import com.docker.learning.convidados.domain.repository.AnfitriaoRepository;
import com.docker.learning.convidados.domain.repository.ConviteRepository;
import com.docker.learning.convidados.domain.service.AnfitriaoService;
import com.docker.learning.convidados.domain.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Anfitriao>> getAnfitriao(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity postAnfitriao(@RequestBody AnfitriaoDTORequest dto){
        var post = service.post(dto);

        return ResponseEntity.ok(post);
    }

    @GetMapping("/{anfitriaoId}")
    public ResponseEntity getConvites(@PathVariable Long anfitriaoId){return ResponseEntity.ok(service.totalConvites(anfitriaoId));}

    @PostMapping("/postConvite")
    public ResponseEntity postConvite(@RequestBody ConviteDTORequest dto) {
         var convite = service.postConvite(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convite);
    }

    @DeleteMapping("/deleteConvite/{id}")
    public ResponseEntity deleteConvite(@PathVariable Long id) {
       service.deleteConvite(id);
        return ResponseEntity.noContent().build();
    }

}