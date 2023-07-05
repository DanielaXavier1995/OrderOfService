package br.com.fuctura.projeto.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private List<FieldMessage> fieldMessageList = new ArrayList<>();

    public ValidationError(LocalDateTime timesTemp, Integer status, String error) {
        super(timesTemp, status, error);
        this.fieldMessageList = fieldMessageList;
    }
    public ValidationError() {
        this.fieldMessageList = fieldMessageList;
    }
    public List<FieldMessage> getFieldMessageList() {
        return fieldMessageList;
    }
    public void addErrors(String fieldName, String message){
        this.fieldMessageList.add(new FieldMessage(fieldName, message));
    }
}
