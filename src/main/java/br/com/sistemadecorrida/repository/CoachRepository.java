package br.com.sistemadecorrida.repository;
import br.com.sistemadecorrida.data.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}

