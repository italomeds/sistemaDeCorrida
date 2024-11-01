package br.com.sistemadecorrida.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.sistemadecorrida.data.dto.corredor.CorredorDTO;
import br.com.sistemadecorrida.data.dto.corredor.CorredorLowDTO;
import br.com.sistemadecorrida.data.model.Corredor;
import br.com.sistemadecorrida.dozer.DozerConverter;
import br.com.sistemadecorrida.exception.CommonsException;
import br.com.sistemadecorrida.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CorredorService {

    @Autowired
    private CorredorRepository repository;

    public CorredorDTO save(CorredorDTO corredor){
        if(corredor.getNome() == null || corredor.getNome().length() > 150){
            System.out.println("Limite de caracteres de nome atingido ou nome é nulo");
            return null;
        }

        if (corredor.getCpf() == null || !corredor.getCpf().matches("\\d{11}")) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "sistemadecorrida.service.corredor.invalidcpf",
                    "CPF é obrigatório e deve conter 11 dígitos numéricos");
        }

        //Converte UserDTO em User
        var entity = DozerConverter.parseObject(corredor, Corredor.class);

        //Recebe retorno do save (User)
        var entityDTO = repository.save(entity);

        //Converte e retorna o User em UserDTO
        return DozerConverter.parseObject(entityDTO, CorredorDTO.class);
    }

    public List<CorredorLowDTO> findAll(){
        var entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.corredor.empty",
                    "Nenhum corredor foi encontrado");
        }
        return DozerConverter.parseListObjects(
                repository.findAll(), CorredorLowDTO.class);
    }

    public void delete(Long id){

        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.corredor.notfound",
                    "O corredor com o ID informado, não foi encontrado para exclusão");
        }
        repository.deleteById(id);
    }

    public CorredorDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.corredor.notfound",
                    "O corredor com o ID informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), CorredorDTO.class);
    }

}
