package com.example.accounts.services.dto;

import java.math.BigDecimal;

public class CreateAccountDTO {

    private BigDecimal balance;
    private String currency;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
