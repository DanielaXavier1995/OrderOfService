package br.com.fuctura.projeto.controller;

import br.com.fuctura.projeto.dto.CustomerDTO;
import br.com.fuctura.projeto.dto.CustomerListDTO;
import br.com.fuctura.projeto.dto.OrderOfServiceDTO;
import br.com.fuctura.projeto.dto.OrderOfServiceListDTO;
import br.com.fuctura.projeto.model.Customer;
import br.com.fuctura.projeto.model.OrderOfService;
import br.com.fuctura.projeto.service.OrderOfServiceService;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderofservice")
public class OrderOfServiceController {
    @Autowired
    private OrderOfServiceService orderOfServiceService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<OrderOfServiceDTO>> getAll() {

        List<OrderOfService> orderOfServiceList = orderOfServiceService.findAll();

        var response = orderOfServiceList.stream()
                .map(x -> modelMapper.map(x, OrderOfServiceDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderOfServiceListDTO> getById(@PathVariable Long id) {

        OrderOfService orderOfService = orderOfServiceService.findById(id);

        var response = modelMapper.map(orderOfService, OrderOfServiceListDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<OrderOfServiceListDTO> save(@Valid @RequestBody OrderOfServiceListDTO orderOfServiceListDTO){
        orderOfServiceListDTO.setDateTime(LocalDateTime.now());

        OrderOfService orderOfService = orderOfServiceService.save(orderOfServiceListDTO);

        var response = modelMapper.map(orderOfService, OrderOfServiceListDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderOfServiceListDTO> update(@PathVariable Long id, @Valid @RequestBody OrderOfServiceListDTO orderOfServiceListDTO) {

        orderOfServiceListDTO.setDateTime(LocalDateTime.now());
        orderOfServiceListDTO.setId(id);

        OrderOfService orderOfService = orderOfServiceService.update(orderOfServiceListDTO);

        var response = modelMapper.map(orderOfService, OrderOfServiceListDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderOfServiceDTO> delete(@PathVariable Long id) {

        orderOfServiceService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
