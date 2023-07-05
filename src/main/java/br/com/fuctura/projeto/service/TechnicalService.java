package br.com.fuctura.projeto.service;

import br.com.fuctura.projeto.dto.TechnicalDTO;
import br.com.fuctura.projeto.exceptions.DataIntegretyViolationException;
import br.com.fuctura.projeto.exceptions.ObjectNotFoundException;
import br.com.fuctura.projeto.model.Technical;
import br.com.fuctura.projeto.repository.CustomerRepository;
import br.com.fuctura.projeto.repository.TechnicalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TechnicalService {
    @Autowired
    private TechnicalRepository technicalRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;

    public List<Technical> findAll() {
        return technicalRepository.findAll();
    }
    public Technical findById(Long id) {

        var technical = technicalRepository.findById(id);

        return technical.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
    public Technical save(TechnicalDTO technicalDTO) {
        findByCpf(technicalDTO);

        var response = modelMapper.map(technicalDTO, Technical.class);

        return technicalRepository.save(response);
    }

    public Technical update(TechnicalDTO technicalDTO) {
        findById(technicalDTO.getId());
        findByCpf(technicalDTO);
        var response = modelMapper.map(technicalDTO, Technical.class);

        return technicalRepository.save(response);
    }
    public void findByCpf(TechnicalDTO technicalDTO) {

        var technical = technicalRepository.findByCpf(technicalDTO.getCpf());

        if(technical.isPresent() && !technical.get().getId().equals(technicalDTO.getId())){
            throw new DataIntegretyViolationException("cpf already registered in the database!");
        }
    }
    public void delete(Long id) {
        findById(id);
        technicalRepository.deleteById(id);
    }
}