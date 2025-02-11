package com.docker.learning.convidados.repository;

import com.docker.learning.convidados.domain.model.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConviteRepository extends JpaRepository<Convite, Long> {
}
