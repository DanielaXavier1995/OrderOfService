package br.com.fuctura.projeto.model;

import br.com.fuctura.projeto.enuns.PriorityOrder;
import br.com.fuctura.projeto.enuns.ServiceType;
import br.com.fuctura.projeto.enuns.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order_of_service")
public class OrderOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_of_service_id")
    private Long id;
    @Column(name = "order_of_service_date_time_opened")
    private LocalDateTime dateTime;
    @Column(name = "order_of_service_status")
    private Status status;
    @Column(name = "order_of_service_priority")
    private PriorityOrder priority;
    @Column(name = "order_of_service_observation")
    private String observation;
    @Column(name = "order_of_service_type")
    private ServiceType serviceType;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_customer_id")
    private Customer customer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_tecnical_id")
    private Technical technical;

//    public OrderOfService(Long code, Status status, PriorityOrder priority, String observation, ServiceType serviceType, Customer customer, Technical technical) {
//        this.code = code;
//        this.setDateTime(LocalDateTime.now());
//        this.status = status;
//        this.priority = priority;
//        this.observation = observation;
//        this.serviceType = serviceType;
//        this.customer = customer;
//        this.technical = technical;
//    }

}
