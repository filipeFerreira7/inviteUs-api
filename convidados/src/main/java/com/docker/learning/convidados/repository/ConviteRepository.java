package com.docker.learning.convidados.repository;

import com.docker.learning.convidados.domain.model.Convite;
import org.springframework.data.repository.CrudRepository;

public interface ConviteRepository extends CrudRepository<Convite, Long> {
}
