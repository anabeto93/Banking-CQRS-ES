package com.example.accounts.commands;

import java.math.BigDecimal;

public class DebitMoneyCommand extends BaseCommand<String>{

    public final BigDecimal amount;
    public final String currency;

    public DebitMoneyCommand(String id, BigDecimal amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
