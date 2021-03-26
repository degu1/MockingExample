package com.example;

public class TestDoubleBankService implements BankService {

    boolean payCalled = false;

    @Override
    public void pay(String id, double amount) {
        payCalled = true;
    }

}
