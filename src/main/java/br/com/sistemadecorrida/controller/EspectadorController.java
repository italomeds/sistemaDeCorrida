package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.data.dto.espectador.EspectadorDTO;
import br.com.sistemadecorrida.data.dto.espectador.EspectadorLowDTO;
import br.com.sistemadecorrida.service.EspectadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/espectador")
public class EspectadorController {

    @Autowired
    private EspectadorService service;

    @Operation(summary = "Cadastra os dados de um espectador", tags = "Espectador")
    @PostMapping
    public EspectadorDTO create(@RequestBody EspectadorDTO espectador){
        return service.save(espectador);
    }


    @Operation(summary = "Edita os dados de um espectador", tags = "Espectador")
    @PutMapping
    public EspectadorDTO update(@RequestBody EspectadorDTO espectador){
        return service.save(espectador);
    }


    @Operation(summary = "Retorna os dados de todos os espectadores", tags = "Espectador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Espectadores retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum espectadores encontrado")}
    )
    @GetMapping("/all")
    public List<EspectadorLowDTO> findAll(){
        return service.findAll();
    }


    @Operation(summary = "Deleta os dados de um espectador", tags = "Espectador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Espectador excluido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum espectador encontrado")}
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @Operation(summary = "Retorna os dados de um espectador", tags = "Espectador")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Espectador retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum espectador encontrada")}
    )
    @GetMapping("/{id}")
    public EspectadorDTO findById(@PathVariable Long id){
        return service.findById(id);}


}
