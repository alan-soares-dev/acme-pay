package br.com.acmepay.domain;

import br.com.acmepay.exception.BalanceToWithDrawException;
import lombok.Data;

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
        if (!this.hasBalance(amount)) {
            throw new BalanceToWithDrawException("error-withdraw");
        }
        this.balance.subtract(amount);
    }

    public void transfer(Account account, BigDecimal amount) throws BalanceToWithDrawException {
        this.withdraw(amount);
        account.deposit(amount);
    }

    private boolean hasBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }
}
