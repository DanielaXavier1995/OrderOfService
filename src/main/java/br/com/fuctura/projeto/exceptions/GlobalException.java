package br.com.fuctura.projeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException (ObjectNotFoundException objectNotFoundException) {

        StandardError standardError = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
    @ExceptionHandler(DataIntegretyViolationException.class)
    public ResponseEntity<StandardError> dataIntegretyViolationException (DataIntegretyViolationException dataIntegretyViolationException) {
        StandardError standardError = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), dataIntegretyViolationException.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

        ValidationError validationError = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");

        for(FieldError x: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationError.addErrors(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
