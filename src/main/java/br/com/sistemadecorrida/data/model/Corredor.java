package br.com.sistemadecorrida.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_corredor")
@Data
public class Corredor {

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

    @Column(nullable = true, length = 150)
    private Long id_equipe;

    @Column(unique = true)
    private String login;

    @Column(nullable = false, length = 150)
    private String password;

}
