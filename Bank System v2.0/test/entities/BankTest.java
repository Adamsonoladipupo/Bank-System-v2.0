package entities;

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
    public void CreateANewBankAccountTest(){
        bank.createAccount("Adams", "adams@gmail.com", "password");
        assertEquals(1, Account.getCount());
    }

    @Test
    public void deposite200IntoABankAccountTest(){
        bank.createAccount("Adams", "adams@gmail.com", "password");
        bank.
    }

    @Test
    public void Transfer500FromAccount1ToAccount2Test(){


    }

}