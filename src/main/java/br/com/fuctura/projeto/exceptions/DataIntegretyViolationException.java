package br.com.fuctura.projeto.exceptions;

public class DataIntegretyViolationException extends RuntimeException{
    public DataIntegretyViolationException (String message) {
        super(message);
    }
}
