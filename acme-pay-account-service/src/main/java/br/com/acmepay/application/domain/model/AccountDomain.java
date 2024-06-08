package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.domain.exception.BalanceToWithDrawException;
import br.com.acmepay.application.ports.out.ICreateAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDomain {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean closed;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateAccount createAccount) {
        createAccount.execute(this);
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithDrawException {
        if (!this.hasBalance(amount)) {
            throw new BalanceToWithDrawException("error-withdraw");
        }
        this.balance = this.balance.subtract(amount);
    }

    private boolean hasBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }
}
