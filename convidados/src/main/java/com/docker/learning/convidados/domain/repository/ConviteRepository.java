package com.docker.learning.convidados.domain.repository;

import com.docker.learning.convidados.domain.model.Convite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ConviteRepository extends JpaRepository<Convite, Long> {

    @Query("SELECT COUNT(c) FROM Convite c WHERE c.anfitriao.id = :anfitriaoId AND c.validade >= :dataLimite")
    int countInvitePerWeek(@Param("anfitriaoId") Long anfitriaoId, @Param("dataLimite") LocalDateTime dataLimite);


    @Modifying
    @Query("UPDATE Convite c SET c.ativo = false WHERE c.validade < :data AND c.ativo = true")
    void desativarConvitesExpirados(@Param("data") LocalDateTime data);

    List<Convite> findByValidadeBeforeAndAtivoTrue(LocalDateTime validade);

}
