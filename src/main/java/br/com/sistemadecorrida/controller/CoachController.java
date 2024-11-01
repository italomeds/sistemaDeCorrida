package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.data.dto.coach.CoachDTO;
import br.com.sistemadecorrida.data.dto.coach.CoachLowDTO;
import br.com.sistemadecorrida.service.CoachService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coach")
public class CoachController {

    @Autowired
    private CoachService service;

    @Operation(summary = "Cadastra os dados de um coach", tags = "Coach")
    @PostMapping
    public CoachDTO create(@RequestBody CoachDTO coach){
        return service.save(coach);
    }


    @Operation(summary = "Edita os dados de um coach", tags = "Coach")
    @PutMapping
    public CoachDTO update(@RequestBody CoachDTO coach){
        return service.save(coach);
    }

    @Operation(summary = "Retorna os dados de todos os coach", tags = "Coach")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Coachs retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum coach encontrado")}
    )
    @GetMapping("/all")
    public List<CoachLowDTO> findAll(){
        return service.findAll();
    }


    @Operation(summary = "Deleta os dados de um coach", tags = "Coach")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Coach excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum coach encontrado")}
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Retorna os dados de um coach", tags = "Coach")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Coach retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum corredor encontrado")}
    )
    @GetMapping("/{id}")
    public CoachDTO findById(@PathVariable Long id){
        return service.findById(id);
    }



}
