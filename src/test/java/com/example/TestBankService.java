package com.example;

public class TestBankService implements BankService {

    boolean payCalled = false;

    @Override
    public void pay(String id, double amount) {
        payCalled = true;
    }

}
