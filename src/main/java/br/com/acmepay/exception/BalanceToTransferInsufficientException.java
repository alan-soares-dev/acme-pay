package br.com.acmepay.exception;

public class BalanceToTransferInsufficientException extends Exception {
    public BalanceToTransferInsufficientException(String message) {
        super(message);
    }
}
