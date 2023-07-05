package br.com.fuctura.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerListDTO {
    private Long id;
    private String name;
    private String cpf;
    private String phoneNumber;
    private List<OrderOfServiceListForEachCustomerDTO> orderOfServiceListForEachCustomer = new ArrayList<>();
}
