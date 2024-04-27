package br.com.acmepay.exception;

public class EmailInvalidException extends Exception {
    public EmailInvalidException(String message) {
        super(message);
    }
}
