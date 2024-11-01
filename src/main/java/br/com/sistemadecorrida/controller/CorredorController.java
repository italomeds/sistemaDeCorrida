package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.data.dto.corredor.CorredorDTO;
import br.com.sistemadecorrida.data.dto.corredor.CorredorLowDTO;
import br.com.sistemadecorrida.service.CorredorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/corredor")
public class CorredorController {

    @Autowired
    private CorredorService service;


    @Operation(summary = "Cadastra os dados de um corredor", tags = "Corredor")
    @PostMapping
    public CorredorDTO create(@RequestBody CorredorDTO corredor){
        return service.save(corredor);
    }


    @Operation(summary = "Edita os dados de um corredor", tags = "Corredor")
    @PutMapping
    public CorredorDTO update(@RequestBody CorredorDTO corredor){
        return service.save(corredor);
    }

    @Operation(summary = "Retorna os dados de todos os corredores", tags = "Corredor")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Corredores retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum corredor encontrado")}
    )
    @GetMapping("/all")
    public List<CorredorLowDTO> findAll(){
        return service.findAll();
    }


    @Operation(summary = "Deleta os dados de um corredor", tags = "Corredor")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Corredor excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum corredor encontrado")}
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @Operation(summary = "Retorna os dados de um corredor", tags = "Corredor")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Corredor retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum corredor encontrado")}
    )
    @GetMapping("/{id}")
    public CorredorDTO findById(@PathVariable Long id){
       return service.findById(id);
    }



}
