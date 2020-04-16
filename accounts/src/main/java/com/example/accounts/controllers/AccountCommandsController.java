package com.example.accounts.controllers;

import java.util.concurrent.CompletableFuture;

import com.example.accounts.services.AccountCommands;
import com.example.accounts.services.dto.CreateAccountDTO;
import com.example.accounts.services.dto.CreditMoneyDTO;
import com.example.accounts.services.dto.DebitMoneyDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/accounts")
public class AccountCommandsController {

    private final AccountCommands accountCommands;

    public AccountCommandsController(AccountCommands commands) {
        this.accountCommands = commands;
    }

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountDTO account) {
        return this.accountCommands.create(account);
    }

    @PutMapping(value="/{account}/credit")
    public CompletableFuture<String> creditAccount(@PathVariable String account, @RequestBody CreditMoneyDTO money) {
        return this.accountCommands.credit(account, money);
    }

    @PutMapping(value="/{account}/debit")
    public CompletableFuture<String> debitAccount(@PathVariable String account, @RequestBody DebitMoneyDTO money) {
        return this.accountCommands.debit(account, money);
    }

    
}
