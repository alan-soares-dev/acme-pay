package br.com.acmepay.domain;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;
}
