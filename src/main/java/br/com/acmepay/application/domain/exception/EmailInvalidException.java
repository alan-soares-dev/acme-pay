package br.com.acmepay.application.domain.exception;

public class EmailInvalidException extends Exception {
    public EmailInvalidException(String message) {
        super(message);
    }
}
