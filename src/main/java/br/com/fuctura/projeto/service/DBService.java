package br.com.fuctura.projeto.service;

import br.com.fuctura.projeto.enuns.PriorityOrder;
import br.com.fuctura.projeto.enuns.ServiceType;
import br.com.fuctura.projeto.enuns.Status;
import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.model.OrderOfService;
import br.com.fuctura.projeto.model.Technical;
import br.com.fuctura.projeto.repository.CustomerRepository;
import br.com.fuctura.projeto.repository.OrderOfServiceRepository;
import br.com.fuctura.projeto.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TechnicalRepository technicalRepository;
    @Autowired
    private OrderOfServiceRepository orderOfServiceRepository;

    public void instanceDB() {
        Customer customer1 = new Customer(null, "daniela", "123.456.789.-12", "(00) 00000-0000");
        Customer customer2 = new Customer(null, "bruno", "123.456.789.-23", "(00) 00000-0001");

        Technical technical1 = new Technical(null, "jose", "111.222.333-44", "(00) 00000-0002");
        Technical technical2 = new Technical(null, "antonio", "222.333.444-55", "(00) 00000-0003");

        customerRepository.saveAll(Arrays.asList(customer1, customer2));
        technicalRepository.saveAll(Arrays.asList(technical1, technical2));

        OrderOfService orderOfService1 = new OrderOfService(null, LocalDateTime.now(), Status.OPENED, PriorityOrder.HIGH,
                "compra de material", ServiceType.REPAIR, customer1, technical1);
        OrderOfService orderOfService2 = new OrderOfService(null, LocalDateTime.now(), Status.INPROGRESS, PriorityOrder.MEDIUM,
                "", ServiceType.MAINTENANCE, customer2, technical2);

        orderOfServiceRepository.saveAll(Arrays.asList(orderOfService1, orderOfService2));

        customer1.getOrderOfServiceListForEachCustomer().add(orderOfService1);
        customer2.getOrderOfServiceListForEachCustomer().add(orderOfService2);

        technical1.getOrderOfServiceListForEachTechnical().add(orderOfService1);
        technical2.getOrderOfServiceListForEachTechnical().add(orderOfService2);

        customerRepository.saveAll(Arrays.asList(customer1, customer2));
        technicalRepository.saveAll(Arrays.asList(technical1, technical2));
    }
}
