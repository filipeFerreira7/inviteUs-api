package com.docker.learning.convidados.domain.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "convites")
public class Convite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


   @Column
    private LocalDateTime validade;

   @Column
   private LocalDateTime dataCriacao;

   @OneToOne(mappedBy = "convite")
   private Convidado convidado;

   @ManyToOne
    @JoinColumn(name = "anfitriao_id",nullable = false)
   @JsonBackReference
    private Anfitriao anfitriao;

   private Boolean ativo;

   public void excluir() {
       this.ativo = false;
   }




}
