package com.docker.learning.convidados.domain.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Convidado {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;

    @Column
    private String nome;

//    @Column
//    private String email;

    @Id
    @Column
    private String cpf;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "convite_id")
//    private Convite convite;



    
}
