package br.com.acmepay.domain;

import br.com.acmepay.exception.BalanceToTransferInsufficientException;
import br.com.acmepay.exception.BalanceToWithDrawException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Account {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Customer customer;
    private List<Card> cards;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Boolean closed;

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithDrawException {
        if (this.balance.compareTo(amount) >= 0) {
            this.balance.subtract(amount);
        } else {
            throw new BalanceToWithDrawException("error-withdraw");
        }
    }

    public void transfer(Account account, BigDecimal amount) throws BalanceToTransferInsufficientException {
        try {
            this.withdraw(amount);
            account.deposit(amount);
        } catch (BalanceToWithDrawException e) {
            throw new BalanceToTransferInsufficientException("error-transfer");
        }

    }
}
