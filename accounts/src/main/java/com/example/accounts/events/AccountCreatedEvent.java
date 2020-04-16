package com.example.accounts.events;

import java.math.BigDecimal;

public class AccountCreatedEvent extends BaseEvent<String> {

    public final BigDecimal balance;
    public final String currency;

    public AccountCreatedEvent(String id, BigDecimal balance, String currency) {
        super(id);
        this.balance = balance;
        this.currency = currency;
    }
}
