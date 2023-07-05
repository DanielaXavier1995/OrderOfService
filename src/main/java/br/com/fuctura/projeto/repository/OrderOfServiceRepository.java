package br.com.fuctura.projeto.repository;

import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.model.OrderOfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderOfServiceRepository extends JpaRepository<OrderOfService, Long> {
    //Optional<OrderOfService> findByCpf (String cpf);
}
