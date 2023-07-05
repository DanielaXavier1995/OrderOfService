package br.com.fuctura.projeto.repository;

import br.com.fuctura.projeto.dto.CustomerDTO;
import br.com.fuctura.projeto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCpf (String cpf);
}
