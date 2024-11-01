package br.com.sistemadecorrida.repository;
import br.com.sistemadecorrida.data.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}


