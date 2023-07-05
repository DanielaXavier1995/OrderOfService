package br.com.fuctura.projeto.service;

import br.com.fuctura.projeto.dto.CustomerDTO;
import br.com.fuctura.projeto.exceptions.DataIntegretyViolationException;
import br.com.fuctura.projeto.exceptions.ObjectNotFoundException;
import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Customer findById(Long id) {

        var custumer = customerRepository.findById(id);

        return custumer.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
    public Customer save(CustomerDTO customerDTO) {
        findByCpf(customerDTO);

        var response = modelMapper.map(customerDTO, Customer.class);

        return customerRepository.save(response);
    }
    public Customer update(CustomerDTO customerDTO) {
        findById(customerDTO.getId());
        findByCpf(customerDTO);

        var response = modelMapper.map(customerDTO, Customer.class);

        return customerRepository.save(response);
    }

    public void delete(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }

    public void findByCpf(CustomerDTO customerDTO) {

        var customer = customerRepository.findByCpf(customerDTO.getCpf());

        if(customer.isPresent() && !customer.get().getId().equals(customerDTO.getId())) {
            throw new DataIntegretyViolationException("cpf already registered in the database!");
        }
    }
}
