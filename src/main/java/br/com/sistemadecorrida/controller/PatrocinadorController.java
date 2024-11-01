package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.data.dto.coach.CoachDTO;
import br.com.sistemadecorrida.data.dto.coach.CoachLowDTO;
import br.com.sistemadecorrida.data.dto.patrocinador.PatrocinadorDTO;
import br.com.sistemadecorrida.data.dto.patrocinador.PatrocinadorLowDTO;
import br.com.sistemadecorrida.service.CoachService;
import br.com.sistemadecorrida.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patrocinador")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService service;

    @Operation(summary = "Cadastra os dados de um patrocinador", tags = "Patrocinador")
    @PostMapping
    public PatrocinadorDTO create(@RequestBody PatrocinadorDTO patrocinador){
        return service.save(patrocinador);
    }

    @Operation(summary = "Edita os dados de um patrocinador", tags = "Patrocinador")
    @PutMapping
    public PatrocinadorDTO update(@RequestBody PatrocinadorDTO patrocinador){
        return service.save(patrocinador);
    }

    @Operation(summary = "Retorna os dados de todos os patrocinadores", tags = "Patrocinador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Patrocinadores retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum patrocinador encontrado")}
    )
    @GetMapping("/all")
    public List<PatrocinadorLowDTO> findAll(){
        return service.findAll();
    }


    @Operation(summary = "Deleta os dados de um patrocinador", tags = "Patrocinador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Patrocinador excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum patrocinador encontrado")}
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @Operation(summary = "Retorna os dados de um patrocinador", tags = "Patrocinador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Patrocinador retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum patrocinador encontrado")}
    )
    @GetMapping("/{id}")
    public PatrocinadorDTO findById(@PathVariable Long id){
        return service.findById(id);}


}
