package br.com.fuctura.projeto.dto;

import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.model.OrderOfService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    @NotBlank(message = "name is required!")
    private String name;
    @NotBlank(message = "cpf is required!")
    private String cpf;
    @NotBlank(message = "phoneNumber is required!")
    private String phoneNumber;
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.cpf = customer.getCpf();
        this.phoneNumber = customer.getPhoneNumber();
    }
}
