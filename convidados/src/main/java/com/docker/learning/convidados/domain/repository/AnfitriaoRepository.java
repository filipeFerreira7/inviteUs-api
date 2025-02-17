package com.docker.learning.convidados.domain.repository;

import com.docker.learning.convidados.domain.model.Anfitriao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnfitriaoRepository extends JpaRepository<Anfitriao, Long> {
}
