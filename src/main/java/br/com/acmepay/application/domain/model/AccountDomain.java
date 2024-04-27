package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.domain.exception.BalanceToWithDrawException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccountDomain {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private CustomerDomain customerDomain;
    private List<CardDomain> cardDomains;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Boolean closed;

    private List<String> transactions = new ArrayList<>();

    public void create(AccountDomain accountDomain) {
        this.setId(accountDomain.id);
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomerDomain(null);
        this.setCardDomains(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(accountDomain.number);
        this.setAgency(accountDomain.agency);
        this.setClosed(accountDomain.closed);
        this.addTransaction("Account created successfully.");
    }

    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
        this.addTransaction("New Deposit: " + amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithDrawException {
        if (!this.hasBalance(amount)) {
            throw new BalanceToWithDrawException("error-withdraw");
        }
        this.balance = this.balance.subtract(amount);
        this.addTransaction("New Withdraw: " + amount);
    }

    public void transfer(AccountDomain accountDomain, BigDecimal amount) throws BalanceToWithDrawException {
        this.withdraw(amount);
        accountDomain.deposit(amount);
        this.addTransaction("New Transfer: " + amount + " to account: " + accountDomain.getNumber());
    }

    private boolean hasBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    private void addTransaction(String message) {
        this.transactions.add(LocalDateTime.now() + "\t " + message);
    }

    public void printTransaction() {
        for (String m : this.getTransactions()) {
            System.out.println(m);
        }
    }

}
