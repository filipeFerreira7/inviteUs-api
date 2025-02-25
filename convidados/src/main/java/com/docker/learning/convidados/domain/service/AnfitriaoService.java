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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@EnableScheduling
public class AnfitriaoService {

    @Autowired
    private AnfitriaoRepository repository;
    @Autowired
    private ConviteRepository conviteRepository;
    @Autowired
    private ConvidadoRepository convidadoRepository;
    @Autowired
    private AnfitriaoRepository anfitriaoRepository;


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

       var dataLimite = LocalDateTime.now().minusDays(7);
       int convitesUsados = conviteRepository.countInvitePerWeek(anfitriaoId, dataLimite);
       return 15 - convitesUsados;
    }


    @Transactional
    public ConviteDTOResponse postConvite(ConviteDTORequest convite){
        Anfitriao anfitriao = repository.findById(convite.idAnfitriao())
                .orElseThrow(() -> new RuntimeException("Anfitrião não encontrado"));

        Convite c = new Convite();
        c.setAtivo(true); // assim que o convite é postado, é encarado como true
        c.setAnfitriao(anfitriao);
        c.setDataCriacao(LocalDateTime.now());
        c.setValidade(LocalDateTime.now().plusMinutes(2)); // coloquei 2 apenas para testes

        if(anfitriao.getConvites()==null){
            anfitriao.setConvites(new ArrayList<>());
        }
        anfitriao.getConvites().add(c);
        anfitriao.setTotalConvites(totalConvites(anfitriao.getId()));


        conviteRepository.save(c);
        repository.save(anfitriao);

        return ConviteDTOResponse.valueOf(c);
    }


    @Scheduled(fixedRate = 10000)
    @Transactional
    public void inativarConvitesExpirados() {
        conviteRepository.desativarConvitesExpirados(LocalDateTime.now());
    }

    @Scheduled(fixedRate = 10000)
    @Transactional
    public void resetarConvitesDomingo(){
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime localTime = now.toLocalTime();

        System.out.println("Método executado em: " + now);

        // coloquei na thursday para fazer o teste hoje
        if(dayOfWeek == DayOfWeek.TUESDAY
                && localTime.isAfter(LocalTime.of(17, 00))
                && localTime.isBefore(LocalTime.of(17, 01))){
                    anfitriaoRepository.resetarConvites();
                    anfitriaoRepository.atualizarTotalConvites(15);
                    System.out.println("Convites resetados em: " + now);
        }
    }



    @Transactional
    public void deleteConvite(Long idConvite){
        var convite = conviteRepository.findById(idConvite).orElseThrow(() -> new
                IllegalArgumentException("Id inexistente! Impossível excluir"));

        Anfitriao anfitriao = convite.getAnfitriao();
        if (anfitriao != null) {
            anfitriao.getConvites().remove(convite);
            repository.save(anfitriao);
        }

        conviteRepository.delete(convite);
    }
}
