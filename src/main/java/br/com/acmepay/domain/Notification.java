package br.com.acmepay.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Notification {
    private Long id;
    private LocalDateTime data_transaction;
    private Integer source_account;
    private Integer destination_account;
    private BigDecimal amount;
}
