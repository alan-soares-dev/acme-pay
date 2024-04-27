package br.com.acmepay.application.domain.exception;

public class DocumentInvalidException extends Exception {
    public DocumentInvalidException(String message) {
        super(message);
    }
}
