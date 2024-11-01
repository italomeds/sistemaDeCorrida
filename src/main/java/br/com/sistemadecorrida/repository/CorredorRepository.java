package br.com.sistemadecorrida.repository;
import br.com.sistemadecorrida.data.model.Corredor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorredorRepository extends JpaRepository<Corredor, Long> {
}
