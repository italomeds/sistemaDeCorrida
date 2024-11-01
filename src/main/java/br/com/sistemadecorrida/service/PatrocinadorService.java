package br.com.sistemadecorrida.service;

import br.com.sistemadecorrida.data.dto.patrocinador.PatrocinadorDTO;
import br.com.sistemadecorrida.data.dto.patrocinador.PatrocinadorLowDTO;
import br.com.sistemadecorrida.data.model.Patrocinador;
import br.com.sistemadecorrida.dozer.DozerConverter;
import br.com.sistemadecorrida.exception.CommonsException;
import br.com.sistemadecorrida.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorService {

    @Autowired
    private PatrocinadorRepository repository;

    public PatrocinadorDTO save(PatrocinadorDTO patrocinador){
        if(patrocinador.getNome() == null || patrocinador.getNome().length() > 150){
            System.out.println("Limite de caracteres de nome atingido ou nome é nulo");
            return null;
        }

        if (patrocinador.getCpf() == null || !patrocinador.getCpf().matches("\\d{11}")) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "sistemadecorrida.service.coach.invalidcpf",
                    "CPF é obrigatório e deve conter 11 dígitos numéricos");
        }
        //Converte UserDTO em User
        var entity = DozerConverter.parseObject(patrocinador, Patrocinador.class);

        //Recebe retorno do save (User)
        var entityDTO = repository.save(entity);

        //Converte e retorna o User em UserDTO
        return DozerConverter.parseObject(entityDTO, PatrocinadorDTO.class);
    }

    public List<PatrocinadorLowDTO> findAll(){
        var entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.patrocinador.empty",
                    "Nenhum patrocinador foi encontrado");
        }
        return DozerConverter.parseListObjects(
                repository.findAll(), PatrocinadorLowDTO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.coach.notfound",
                    "O patrocinador com o ID informado, não foi encontrado");
        }
        repository.deleteById(id);
    }

    public PatrocinadorDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.patrocinador.notfound",
                    "O patrocinador com o ID informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), PatrocinadorDTO.class);
    }

}
