package br.com.acmepay.application.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDomain {
    private Long id;
    private String flag;
    private BigDecimal card_limit;
    private AccountDomain card_accountDomain;
}
