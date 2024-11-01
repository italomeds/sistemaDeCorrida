package br.com.sistemadecorrida.data.dto.equipe;



import lombok.Data;

@Data
public class EquipeDTO {

    private Long id;
    private String nome;
    private Integer id_coach;
    private String email;
    private String telefone;

}
