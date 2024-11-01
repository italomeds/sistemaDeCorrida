package br.com.sistemadecorrida.data.dto.corredor;

import lombok.Data;

@Data
public class CorredorLowDTO {

    private Long id_equipe;
    private String nome;
    private Integer idade;
    private String genero;

}
