package com.docker.learning.convidados.domain.repository;

import com.docker.learning.convidados.domain.model.Convite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ConviteRepository extends JpaRepository<Convite, Long> {

    @Query("SELECT COUNT(c) FROM Convite c WHERE c.anfitriao.id = :anfitriaoId AND c.validade = :validade")
    int countInvitePerWeek(@Param("anfitriaoId") Long anfitriaoId, @Param("validade") LocalDateTime validade);


}
