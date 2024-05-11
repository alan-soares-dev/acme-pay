package br.com.acmepay.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDomain {
    private Long id;
    private String flag;
    private BigDecimal card_limit;
}
