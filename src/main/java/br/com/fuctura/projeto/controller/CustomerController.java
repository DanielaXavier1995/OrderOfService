package br.com.fuctura.projeto.controller;

import br.com.fuctura.projeto.dto.CustomerDTO;
import br.com.fuctura.projeto.dto.CustomerListDTO;
import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        List<Customer> customerList = customerService.findAll();

        var response = customerList.stream()
                .map(x -> modelMapper.map(x, CustomerDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerListDTO> getById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);

        var response = modelMapper.map(customer, CustomerListDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.save(customerDTO);

        var response = modelMapper.map(customer, CustomerDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        Customer customer = customerService.update(customerDTO);

        var response = modelMapper.map(customer, CustomerDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
