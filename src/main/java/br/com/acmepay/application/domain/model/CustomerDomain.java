package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.domain.exception.DocumentInvalidException;
import br.com.acmepay.application.domain.exception.EmailInvalidException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<AccountDomain> accountDomains;

    private List<CustomerDomain> customerDomains = new ArrayList<>();

    public void createCustomer(CustomerDomain customerDomain) throws DocumentInvalidException, EmailInvalidException {
        validateDocument(customerDomain.getDocument());
        validateEmail(customerDomain.getEmail());
        customerDomains.add(customerDomain);
    }

    public void list() {
        for (CustomerDomain customerDomain : customerDomains) {
            System.out.println(customerDomain.getName() + "\t " + customerDomain.getDocument() + "\t " + customerDomain.getEmail());
        }
    }

    public void delete(CustomerDomain customerDomain) {
        customerDomains.remove(customerDomain);
    }

    public void update(CustomerDomain customerDomain) {
        customerDomains.set(customerDomains.indexOf(customerDomain), customerDomain);
    }

    public CustomerDomain getByCustomerDocument(String document) throws DocumentInvalidException {
        return customerDomains.stream().filter(d -> d.getDocument().equals(document)).findFirst().orElseThrow(() -> new DocumentInvalidException("Document not found"));
    }

    private void validateDocument(String document) throws DocumentInvalidException {
        if (customerDomains.stream().anyMatch(d -> d.getDocument().equals(document))) {
            throw new DocumentInvalidException("Document already exists.");
        }
    }

    private void validateEmail(String email) throws EmailInvalidException {
        if (customerDomains.stream().anyMatch(d -> d.getEmail().equals(email))) {
            throw new EmailInvalidException("Email already exists.");
        }
    }
}
