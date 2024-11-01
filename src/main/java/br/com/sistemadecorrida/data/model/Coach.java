package br.com.sistemadecorrida.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_coach")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150)
    private String cpf;

    @Column(nullable = false, length = 150)
    private Integer idade;

    @Column(nullable = false, length = 150)
    private String genero;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 150)
    private Long id_equipe;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

}
