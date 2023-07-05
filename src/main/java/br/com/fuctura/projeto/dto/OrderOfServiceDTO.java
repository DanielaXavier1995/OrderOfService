package br.com.fuctura.projeto.dto;

import br.com.fuctura.projeto.enuns.PriorityOrder;
import br.com.fuctura.projeto.enuns.ServiceType;
import br.com.fuctura.projeto.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderOfServiceDTO {
    private Long id;
    private LocalDateTime dateTime;
    @NotBlank(message = "status is required!")
    private Status status;
    @NotBlank(message = "priority is required!")
    private PriorityOrder priority;
    private String observation;
    @NotBlank(message = "serviceType is required!")
    private ServiceType serviceType;
}
