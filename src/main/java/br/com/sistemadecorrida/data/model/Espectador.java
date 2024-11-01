package br.com.sistemadecorrida.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_espectador")
@Data
public class Espectador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150)
    private String cpf;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 150)
    private String genero;

    @Column(unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

}
