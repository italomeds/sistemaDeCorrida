package br.com.sistemadecorrida.data.dto.espectador;


import lombok.Data;

@Data
public class EspectadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String genero;
    private String login;
    private String password;
}
