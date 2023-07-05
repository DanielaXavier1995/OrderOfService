package br.com.fuctura.projeto.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
//    private Long id;
    @OneToMany(mappedBy = "customer")
    private List<OrderOfService> orderOfServiceListForEachCustomer = new ArrayList<>();
    public Customer(Long id, String name, String cpf, String phoneNumber) {
        super(id, name, cpf, phoneNumber);
    }
}
