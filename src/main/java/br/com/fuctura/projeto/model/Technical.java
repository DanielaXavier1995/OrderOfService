package br.com.fuctura.projeto.model;


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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Technical extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "technical_id")
//    private Long id;
    @OneToMany(mappedBy = "technical")
    private List<OrderOfService> orderOfServiceListForEachTechnical = new ArrayList<OrderOfService>();
    public Technical(Long id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);

    }
}
