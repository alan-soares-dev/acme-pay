package br.com.acmepay.domain;

import br.com.acmepay.exception.BalanceToWithDrawException;
import br.com.acmepay.exception.DocumentInvalidException;
import br.com.acmepay.exception.EmailInvalidException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;

    private List<Customer> customers = new ArrayList<>();

    public void createCustomer(Customer customer) throws DocumentInvalidException, EmailInvalidException {
        validateDocument(customer.getDocument());
        validateEmail(customer.getEmail());
        customers.add(customer);
    }

    public void list() {
        for (Customer customer : customers) {
            System.out.println(customer.getName() + "\t " + customer.getDocument() + "\t " +customer.getEmail());
        }
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public void update(Customer customer) {
        customers.set(customers.indexOf(customer), customer);
    }

    public Customer getByCustomerDocument(String document) throws DocumentInvalidException {
        return customers.stream().filter(d -> d.getDocument().equals(document)).findFirst().orElseThrow(() -> new DocumentInvalidException("Document not found"));
    }

    private void validateDocument(String document) throws DocumentInvalidException {
        if (customers.stream().anyMatch(d -> d.getDocument().equals(document))) {
            throw new DocumentInvalidException("Document already exists.");
        }
    }

    private void validateEmail(String email) throws EmailInvalidException {
        if (customers.stream().anyMatch(d -> d.getEmail().equals(email))) {
            throw new EmailInvalidException("Email already exists.");
        }
    }
}
