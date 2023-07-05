package br.com.fuctura.projeto.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timesTemp;
    private Integer status;
    private String error;
}
