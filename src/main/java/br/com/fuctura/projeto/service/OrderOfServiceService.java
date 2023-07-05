package br.com.fuctura.projeto.service;

import br.com.fuctura.projeto.dto.CustomerDTO;
import br.com.fuctura.projeto.dto.OrderOfServiceDTO;
import br.com.fuctura.projeto.dto.OrderOfServiceListDTO;
import br.com.fuctura.projeto.exceptions.ObjectNotFoundException;
import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.model.OrderOfService;
import br.com.fuctura.projeto.repository.OrderOfServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderOfServiceService {
    @Autowired
    private OrderOfServiceRepository orderOfServiceRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<OrderOfService> findAll() {
        return orderOfServiceRepository.findAll();
    }

    public OrderOfService findById(Long id) {
        var orderOfService = orderOfServiceRepository.findById(id);

        return orderOfService.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
    public OrderOfService save(OrderOfServiceListDTO orderOfServiceListDTO) {

        var response = modelMapper.map(orderOfServiceListDTO, OrderOfService.class);

        return orderOfServiceRepository.save(response);
    }
    public OrderOfService update(OrderOfServiceListDTO orderOfServiceListDTO) {
        findById(orderOfServiceListDTO.getId());

        var response = modelMapper.map(orderOfServiceListDTO, OrderOfService.class);

        return orderOfServiceRepository.save(response);
    }
    public void delete(Long id) {
        findById(id);
        orderOfServiceRepository.deleteById(id);
    }
}
