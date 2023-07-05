package br.com.fuctura.projeto.controller;

import br.com.fuctura.projeto.dto.TechnicalDTO;
import br.com.fuctura.projeto.dto.TechnicalListDTO;
import br.com.fuctura.projeto.model.Technical;
import br.com.fuctura.projeto.repository.TechnicalRepository;
import br.com.fuctura.projeto.service.TechnicalService;
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
@RequestMapping("/technical")
public class TechnicalController {
    @Autowired
    private TechnicalService technicalService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TechnicalRepository technicalRepository;
    @GetMapping
    public ResponseEntity<List<TechnicalDTO>> getAll(){
        List<Technical> technicalList = technicalRepository.findAll();

        var response = technicalList.stream()
                .map(x -> modelMapper.map(x, TechnicalDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TechnicalListDTO> getById(@PathVariable Long id) {
        Technical technical = technicalService.findById(id);

        var response = modelMapper.map(technical, TechnicalListDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<TechnicalDTO> save(@Valid @RequestBody TechnicalDTO technicalDTO) {
        Technical technical = technicalService.save(technicalDTO);

        var response = modelMapper.map(technical, TechnicalDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TechnicalDTO> update (@PathVariable Long id, @Valid @RequestBody TechnicalDTO technicalDTO) {
        technicalDTO.setId(id);
        Technical technical = technicalService.update(technicalDTO);

        var response = modelMapper.map(technical, TechnicalDTO.class);

        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TechnicalDTO> delete(@PathVariable Long id) {
        technicalService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
