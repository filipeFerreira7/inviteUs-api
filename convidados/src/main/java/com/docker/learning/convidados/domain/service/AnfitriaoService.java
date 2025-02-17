package com.docker.learning.convidados.domain.service;

import com.docker.learning.convidados.domain.dto.AnfitriaoDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTORequest;
import com.docker.learning.convidados.domain.dto.ConviteDTOResponse;
import com.docker.learning.convidados.domain.model.Anfitriao;
import com.docker.learning.convidados.domain.model.Convidado;
import com.docker.learning.convidados.domain.model.Convite;
import com.docker.learning.convidados.domain.repository.AnfitriaoRepository;
import com.docker.learning.convidados.domain.repository.ConvidadoRepository;
import com.docker.learning.convidados.domain.repository.ConviteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AnfitriaoService {
    @Autowired
    private AnfitriaoRepository repository;
    @Autowired
    private ConviteRepository conviteRepository;
    @Autowired
    private ConvidadoRepository convidadoRepository;


    //depois vamos pensar em algo melhor, mas o anfitrião se postar não é certo
    @Transactional
    public Anfitriao post(AnfitriaoDTORequest dto){
        Anfitriao anfitriao = new Anfitriao();
        anfitriao.setNome(dto.nome());
        anfitriao.setEmail(dto.email());
        anfitriao.setCpf(dto.cpf());
        anfitriao.setDataCriacao(LocalDateTime.now());
        anfitriao.setTotalConvites(15);
        anfitriao.setConvites(new ArrayList<>());


        repository.save(anfitriao);

        return anfitriao;
    }


    public int totalConvites(Long anfitriaoId) {
       if(anfitriaoId == null){
           throw new IllegalArgumentException("Id do anfitrião não pode ser nulo");
       }
       var anfitriao = repository.findById(anfitriaoId);
       if(anfitriao.isEmpty()){
           throw new EntityNotFoundException("Anfitrião não encontrado.");
       }

       return 15 - conviteRepository.countInvitePerWeek(anfitriaoId, LocalDateTime.now().minusDays(7));
    }


    @Transactional
    public ConviteDTOResponse postConvite(ConviteDTORequest convite){
        Anfitriao anfitriao = repository.findById(convite.idAnfitriao())
                .orElseThrow(() -> new RuntimeException("Anfitrião não encontrado"));

        Convite c = new Convite();

        c.setAnfitriao(anfitriao);
        c.setDataCriacao(LocalDateTime.now());
        c.setValidade(LocalDateTime.now().plusHours(12));

        if(anfitriao.getConvites()==null){
            anfitriao.setConvites(new ArrayList<>());
        }
        anfitriao.getConvites().add(c);
        anfitriao.setTotalConvites(totalConvites(anfitriao.getId()));

        conviteRepository.save(c);
        repository.save(anfitriao);

        return ConviteDTOResponse.valueOf(c);
    }
}
