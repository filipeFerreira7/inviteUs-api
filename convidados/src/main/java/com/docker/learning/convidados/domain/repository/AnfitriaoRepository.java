package com.docker.learning.convidados.domain.repository;

import com.docker.learning.convidados.domain.model.Anfitriao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnfitriaoRepository extends JpaRepository<Anfitriao, Long> {


    @Modifying
    @Query("Update Anfitriao a SET a.totalConvites = 15")
    void resetarConvites();


    @Query("SELECT a.totalConvites FROM Anfitriao a")
    int totalConvites();

    @Modifying
    @Query("UPDATE Anfitriao a SET a.totalConvites = :novoTotal")
    void atualizarTotalConvites(@Param("novoTotal") int novoTotal);

}
