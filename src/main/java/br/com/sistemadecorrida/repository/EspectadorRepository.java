package br.com.sistemadecorrida.repository;
import br.com.sistemadecorrida.data.model.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspectadorRepository extends JpaRepository<Espectador, Long> {
}
