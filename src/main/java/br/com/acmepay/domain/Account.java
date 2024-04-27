package br.com.acmepay.domain;

import br.com.acmepay.exception.BalanceToWithDrawException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private List<String> transactions = new ArrayList<>();

    public void create(Account account) {
        this.setId(account.id);
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(null);
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setNumber(account.number);
        this.setAgency(account.agency);
        this.setClosed(account.closed);
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

    public void transfer(Account account, BigDecimal amount) throws BalanceToWithDrawException {
        this.withdraw(amount);
        account.deposit(amount);
        this.addTransaction("New Transfer: " + amount + " to account: " + account.getNumber());
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
