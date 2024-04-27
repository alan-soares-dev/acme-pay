package br.com.acmepay.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Card {
    private Long id;
    private String flag;
    private BigDecimal card_limit;
    private Account card_account;
}
