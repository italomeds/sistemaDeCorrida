package br.com.sistemadecorrida.data.dto.coach;

import lombok.Data;


@Data
public class CoachDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String genero;
    private String email;
    private Long id_equipe;
    private String login;
    private String password;

}
