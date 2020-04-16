package com.example.accounts.commands;

import java.math.BigDecimal;

public class CreateAccountCommand extends BaseCommand<String> {

    public final BigDecimal balance;
    public final String currency;

    public CreateAccountCommand(String id, BigDecimal balance, String currency) {
        super(id);
        this.balance = balance;
        this.currency = currency;
    }
}
