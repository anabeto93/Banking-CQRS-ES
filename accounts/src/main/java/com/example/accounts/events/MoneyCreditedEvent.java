package com.example.accounts.events;

import java.math.BigDecimal;

public class MoneyCreditedEvent extends BaseEvent<String> {

    public final BigDecimal amount;
    public final String currency;

    public MoneyCreditedEvent(String id, BigDecimal amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
