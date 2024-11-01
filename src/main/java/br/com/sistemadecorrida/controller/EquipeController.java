package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.data.dto.corredor.CorredorDTO;
import br.com.sistemadecorrida.data.dto.corredor.CorredorLowDTO;
import br.com.sistemadecorrida.data.dto.equipe.EquipeDTO;
import br.com.sistemadecorrida.data.dto.equipe.EquipeLowDTO;
import br.com.sistemadecorrida.service.CorredorService;
import br.com.sistemadecorrida.service.EquipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipe")
public class EquipeController {

    @Autowired
    private EquipeService service;

    @Operation(summary = "Cadastra os dados de uma equipe", tags = "Equipe")
    @PostMapping
    public EquipeDTO create(@RequestBody EquipeDTO equipe){
        return service.save(equipe);
    }


    @Operation(summary = "Edita os dados de uma equipe", tags = "Equipe")
    @PutMapping
    public EquipeDTO update(@RequestBody EquipeDTO equipe){
        return service.save(equipe);
    }

    @Operation(summary = "Retorna os dados de todas equipes", tags = "Equipe")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Equipes retornadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma equipe encontrada")}
    )
    @GetMapping("/all")
    public List<EquipeLowDTO> findAll(){
        return service.findAll();
    }


    @Operation(summary = "Deleta os dados de uma equipe", tags = "Equipe")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Equipe excluida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma equipe encontrada")}
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Retorna os dados de uma equipe", tags = "Equipe")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Equipe retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum equipe encontrada")}
    )
    @GetMapping("/{id}")
    public EquipeDTO findById(@PathVariable Long id){
        return service.findById(id);
    }



}
