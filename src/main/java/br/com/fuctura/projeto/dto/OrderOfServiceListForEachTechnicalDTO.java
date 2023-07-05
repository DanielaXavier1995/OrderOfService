package br.com.fuctura.projeto.dto;

import br.com.fuctura.projeto.enuns.PriorityOrder;
import br.com.fuctura.projeto.enuns.ServiceType;
import br.com.fuctura.projeto.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderOfServiceListForEachTechnicalDTO {
    private Long id;
    private LocalDateTime dateTime;
    private Status status;
    private PriorityOrder priority;
    private String observation;
    private ServiceType serviceType;
    private CustomerDTO custumer;
    public CustomerDTO getCustumer() {
        return custumer;
    }
}
