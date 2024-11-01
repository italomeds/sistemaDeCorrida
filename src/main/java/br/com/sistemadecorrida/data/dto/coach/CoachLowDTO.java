package br.com.sistemadecorrida.data.dto.coach;

import lombok.Data;

@Data
public class CoachLowDTO {

    private Long id_equipe;
    private String nome;
    private Integer idade;
    private String genero;

}
