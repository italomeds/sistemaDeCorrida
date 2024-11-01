package br.com.sistemadecorrida.service;

import br.com.sistemadecorrida.data.dto.equipe.EquipeDTO;
import br.com.sistemadecorrida.data.dto.equipe.EquipeLowDTO;
import br.com.sistemadecorrida.data.model.Equipe;
import br.com.sistemadecorrida.dozer.DozerConverter;
import br.com.sistemadecorrida.exception.CommonsException;
import br.com.sistemadecorrida.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;

    public EquipeDTO save(EquipeDTO equipe){
        if(equipe.getNome().length() > 150){
            System.out.println("Limite de caracteres de nome atingido");
            return null;
        }
        //Converte UserDTO em User
        var entity = DozerConverter.parseObject(equipe, Equipe.class);

        //Recebe retorno do save (User)
        var entityDTO = repository.save(entity);

        //Converte e retorna o User em UserDTO
        return DozerConverter.parseObject(entityDTO, EquipeDTO.class);
    }

    public List<EquipeLowDTO> findAll(){
        var entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.equipe.empty",
                    "Nenhuma equipe foi encontrada");
        }
        return DozerConverter.parseListObjects(
                repository.findAll(), EquipeLowDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public EquipeDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.equipe.notfound",
                    "A equipe com o ID informado, não foi encontrada");
        }
        return DozerConverter.parseObject(entity.get(), EquipeDTO.class);
    }

}
