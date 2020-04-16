package com.example.accounts.aggregates;

import java.math.BigDecimal;

import com.example.accounts.commands.CreateAccountCommand;
import com.example.accounts.commands.CreditMoneyCommand;
import com.example.accounts.commands.DebitMoneyCommand;
import com.example.accounts.events.AccountActivatedEvent;
import com.example.accounts.events.AccountCreatedEvent;
import com.example.accounts.events.AccountHeldEvent;
import com.example.accounts.events.MoneyCreditedEvent;
import com.example.accounts.events.MoneyDebitedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Account {

    @AggregateIdentifier
    private String id;

    private BigDecimal balance;

    private String currency;

    private String status;

    public Account() {}

    @CommandHandler
    public Account(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.balance, createAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent event) {
        this.id = event.id;
        this.balance = event.balance;
        this.currency = event.currency;
        this.status = "CREATED";
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent event) {
        this.status = String.valueOf(event.status);
    }

    @CommandHandler
    protected void on(CreditMoneyCommand command) {
        AggregateLifecycle.apply(new MoneyCreditedEvent(command.id, command.amount, command.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent event) {
        
        if (this.balance.doubleValue() < 0 & (this.balance.doubleValue() + event.amount.doubleValue()) >=0) {
            AggregateLifecycle.apply(new AccountActivatedEvent(this.id, "ACTIVATED"));
        }

        this.balance = BigDecimal.valueOf(this.balance.doubleValue() + event.amount.doubleValue());
    }

    @CommandHandler
    protected void on(DebitMoneyCommand command) {
        AggregateLifecycle.apply(new MoneyDebitedEvent(command.id, command.amount, command.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent event) {

        if (this.balance.doubleValue() >= 0 & (this.balance.doubleValue() - event.amount.doubleValue()) < 0) {
            AggregateLifecycle.apply(new AccountHeldEvent(this.id, "HOLD"));
        }

        this.balance = BigDecimal.valueOf(this.balance.doubleValue() - event.amount.doubleValue());
    }

    @EventSourcingHandler
    protected void on(AccountHeldEvent event) {
        this.status = String.valueOf(event.status);
    }

}
