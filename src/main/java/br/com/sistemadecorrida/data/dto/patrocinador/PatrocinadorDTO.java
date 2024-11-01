package br.com.sistemadecorrida.data.dto.patrocinador;

import lombok.Data;


@Data
public class PatrocinadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Long id_equipe;
    private String login;
    private String password;
}
