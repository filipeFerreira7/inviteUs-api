package com.docker.learning.convidados.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "anfitrioes")
public class Anfitriao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private Integer totalConvites;
}
