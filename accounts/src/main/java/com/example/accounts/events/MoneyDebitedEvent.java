package com.example.accounts.events;

import java.math.BigDecimal;

public class MoneyDebitedEvent extends BaseEvent<String> {

    public final BigDecimal amount;
    public final String currency;

    public MoneyDebitedEvent(String id, BigDecimal amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
