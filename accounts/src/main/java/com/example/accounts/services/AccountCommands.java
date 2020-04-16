package com.example.accounts.services;

import java.util.concurrent.CompletableFuture;

import com.example.accounts.services.dto.CreateAccountDTO;
import com.example.accounts.services.dto.CreditMoneyDTO;
import com.example.accounts.services.dto.DebitMoneyDTO;

public interface AccountCommands {
    public CompletableFuture<String> create(CreateAccountDTO account);
    public CompletableFuture<String> credit(String account, CreditMoneyDTO money);
    public CompletableFuture<String> debit(String account, DebitMoneyDTO money);
}
