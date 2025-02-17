package com.docker.learning.convidados.domain.repository;

import com.docker.learning.convidados.domain.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
}
