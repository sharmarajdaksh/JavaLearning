package com.sharmarajdaksh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @org.junit.jupiter.api.BeforeAll
    static void beforeAll() {
        System.out.println("Performing this before test suite start");
    }

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        System.out.println("Performing setup");
        bankAccount = new BankAccount("Dakshraj", "Sharma", 1000.00, BankAccount.CHECKING);
    }

    // Best practice: One assert per test
    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = bankAccount.deposit(200.0, true);
        assertEquals(1200.00, balance, 0); // third param is to allow some leeway in comparison
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        double balance = bankAccount.deposit(200.0, true);
        assertEquals(1200.00, bankAccount.getBalance(), 0);
    }


    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        double balance = bankAccount.withdraw(200.0, true);
        assertEquals(800.00, bankAccount.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        assertTrue(bankAccount.isChecking(), "The account is not a checking account");
    }

    @org.junit.jupiter.api.AfterAll
    static void afterAll() {
        System.out.println("I run after all tests are done");
    }


    @org.junit.jupiter.api.AfterEach
    void afterEach() {
        System.out.println("I run after every test");
    }
}
