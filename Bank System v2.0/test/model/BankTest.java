package model;

import data.models.Account;
import data.models.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;

    @BeforeEach
    public void setUp(){
        bank = new Bank("WorldBank");
    }

    @Test
    public void CheckIfBankHasNoAccountTest(){
        assertEquals(0, Account.getCount());
    }

    @Test
    public void registerANewAccountTest(){
        Account account = new Account("Adamson", "adamson@gmail.com", "password");
        System.out.println(account.getAccountNumber());
        bank.registerAnAccount(account);
        System.out.println(account.getAccountNumber());
        System.out.println(account.getNumbaNumber());

    }


}