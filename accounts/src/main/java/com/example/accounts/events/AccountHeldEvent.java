package com.example.accounts.events;

public class AccountHeldEvent extends BaseEvent<String> {

    public final String status;

    public AccountHeldEvent(String id, String status) {
        super(id);
        this.status = status;
    }
}
