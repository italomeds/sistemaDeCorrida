package br.com.sistemadecorrida.service;

import br.com.sistemadecorrida.data.dto.coach.CoachDTO;
import br.com.sistemadecorrida.data.dto.coach.CoachLowDTO;
import br.com.sistemadecorrida.data.model.Coach;
import br.com.sistemadecorrida.dozer.DozerConverter;
import br.com.sistemadecorrida.exception.CommonsException;
import br.com.sistemadecorrida.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository repository;

    public CoachDTO save(CoachDTO coach){
        if(coach.getNome() == null || coach.getNome().length() > 150){
            System.out.println("Limite de caracteres de nome atingido ou nome é nulo");
            return null;
        }

        if (coach.getCpf() == null || !coach.getCpf().matches("\\d{11}")) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "sistemadecorrida.service.coach.invalidcpf",
                    "CPF é obrigatório e deve conter 11 dígitos numéricos");
        }

        //Converte UserDTO em User
        var entity = DozerConverter.parseObject(coach, Coach.class);

        //Recebe retorno do save (User)
        var entityDTO = repository.save(entity);

        //Converte e retorna o User em UserDTO
        return DozerConverter.parseObject(entityDTO, CoachDTO.class);
    }

    public List<CoachLowDTO> findAll(){
        var entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.coach.empty",
                    "Nenhum coach foi encontrado");
        }
        return DozerConverter.parseListObjects(
                repository.findAll(), CoachLowDTO.class);
    }

    public void delete(Long id){
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.coach.notfound",
                    "O coach com o ID informado, não foi encontrado para exclusão");
        }
        repository.deleteById(id);
    }

    public CoachDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.coach.notfound",
                    "O coach com o ID informado, não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), CoachDTO.class);
    }

}
