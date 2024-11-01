package br.com.sistemadecorrida.service;

import br.com.sistemadecorrida.data.dto.espectador.EspectadorDTO;
import br.com.sistemadecorrida.data.dto.espectador.EspectadorLowDTO;
import br.com.sistemadecorrida.data.model.Espectador;
import br.com.sistemadecorrida.dozer.DozerConverter;
import br.com.sistemadecorrida.exception.CommonsException;
import br.com.sistemadecorrida.repository.EspectadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspectadorService {

    @Autowired
    private EspectadorRepository repository;

    public EspectadorDTO save(EspectadorDTO espectador){
        if(espectador.getNome() == null || espectador.getNome().length() > 150){
            System.out.println("Limite de caracteres de nome atingido ou nome é nulo");
            return null;
        }

        if (espectador.getCpf() == null || !espectador.getCpf().matches("\\d{11}")) {
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "sistemadecorrida.service.coach.invalidcpf",
                    "CPF é obrigatório e deve conter 11 dígitos numéricos");
        }

        //Converte UserDTO em User
        var entity = DozerConverter.parseObject(espectador, Espectador.class);

        //Recebe retorno do save (User)
        var entityDTO = repository.save(entity);

        //Converte e retorna o User em UserDTO
        return DozerConverter.parseObject(entityDTO, EspectadorDTO.class);
    }

    public List<EspectadorLowDTO> findAll(){
        var entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.espectador.empty",
                    "Nenhum espectador foi encontrado");
        }
        return DozerConverter.parseListObjects(
                repository.findAll(), EspectadorLowDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public EspectadorDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "sistemadecorrida.service.espectador.notfound",
                    "O espectador com o ID informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), EspectadorDTO.class);
    }

}
