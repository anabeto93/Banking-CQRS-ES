package com.example.accounts.services;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.example.accounts.commands.CreateAccountCommand;
import com.example.accounts.commands.CreditMoneyCommand;
import com.example.accounts.commands.DebitMoneyCommand;
import com.example.accounts.services.dto.CreateAccountDTO;
import com.example.accounts.services.dto.CreditMoneyDTO;
import com.example.accounts.services.dto.DebitMoneyDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandsService implements AccountCommands {

    private final CommandGateway command;

    public AccountCommandsService(CommandGateway gateway) {
        this.command = gateway;
    }

    @Override
    public CompletableFuture<String> create(CreateAccountDTO account) {
        return command.send(new CreateAccountCommand(UUID.randomUUID().toString(), account.getBalance(), account.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debit(String account, DebitMoneyDTO money) {
        return command.send(new DebitMoneyCommand(account, money.getAmount(), money.getCurrency()));
    }

    @Override
    public CompletableFuture<String> credit(String account, CreditMoneyDTO money) {
        return command.send(new CreditMoneyCommand(account, money.getAmount(), money.getCurrency()));
    }
}
