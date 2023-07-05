package br.com.fuctura.projeto.dto;

import br.com.fuctura.projeto.model.Technical;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class TechnicalDTO {
    private Long id;
    @NotBlank(message = "name is required!")
    private String name;
    @NotBlank(message = "cpf is required!")
    private String cpf;
    @NotBlank(message = "phoneNumber is required!")
    private String phoneNumber;
    public TechnicalDTO(Technical technical) {
        this.id = technical.getId();
        this.name = technical.getName();
        this.cpf = technical.getCpf();
        this.phoneNumber = technical.getPhoneNumber();
    }
}
