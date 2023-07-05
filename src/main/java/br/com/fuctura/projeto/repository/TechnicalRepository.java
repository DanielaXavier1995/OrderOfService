package br.com.fuctura.projeto.repository;

import br.com.fuctura.projeto.model.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
    Optional<Technical> findByCpf(String cpf);
}
