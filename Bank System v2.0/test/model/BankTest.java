package model;

import data.models.Account;
import data.models.Bank;
import exceptions.NonExistingAccountError;
import exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BankTest {

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void CheckIfBankHasNoAccountTest(){
        Bank bank = new Bank("WorldBank");
        assertEquals(0, bank.getNumberOfRegisteredAccount());
    }

    @Test
    public void registerANewAccountTest(){
        Bank bank = new Bank("WorldBank");
        bank.createAnAccount("Adamson", "adamson@gmail.com", "password");
        assertEquals(1, bank.getNumberOfRegisteredAccount());
    }

    @Test
    public void FindAnExistingAccountWithItAccountNumberTest(){
        Bank bank = new Bank("WorldBank");
        bank.createAnAccount("Adamson", "adamson@gmail.com", "password");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        assertEquals(2, bank.getNumberOfRegisteredAccount());
        //System.out.print(account1.getAccountNumber());
        assertEquals("5121110102", bank.findAccountNumber("5121110102"));
    }

    @Test
    public void deposit500NairaIntoAnAccountTest(){
        Bank bank = new Bank("WorldBank");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        //System.out.print(account1.getAccountNumber());
        bank.deposit("5121110101", 500);
        assertEquals(500, account1.getAccountBalance());
    }

    @Test
    public void deposit500NairaIntoANonExistingAccountTest(){
        Bank bank = new Bank("WorldBank");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        assertThrows(NonExistingAccountError.class, ()-> bank.deposit("5", 500));
    }

    @Test
    public void makeA500NairaWithdrawFromAnExistingBankAccountTest(){
        Bank bank = new Bank("WorldBank");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        bank.deposit("5121110101", 1000);
        assertEquals(1000, account1.getAccountBalance());
        bank.withdraw("5121110101", 500, "password");
        assertEquals(500, bank.getAccountBalance("5121110101", "password"));
    }

    @Test
    public void makeA500NairaWithdrawFromANonExistingBankAccountTest(){
        Bank bank = new Bank("WorldBank");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        bank.deposit("5121110101", 1000);
        assertEquals(1000, account1.getAccountBalance());
        assertThrows(NonExistingAccountError.class, ()-> bank.withdraw("5", 500, "password"));
        assertEquals(1000, bank.getAccountBalance("5121110101", "password"));
    }

    @Test
    public void makeA500NairaWithdrawalWithAWrongPasswordTest(){
        Bank bank = new Bank("WorldBank");
        Account account1 = new Account("Adamson", "adamson@gmail.com", "password");
        bank.registerAnAccount(account1);
        bank.deposit("5121110101", 1000);
        assertEquals(1000, account1.getAccountBalance());
        assertThrows(WrongPasswordException.class, ()-> bank.withdraw("5121110101", 500, "wordpass"));
        assertEquals(1000, bank.getAccountBalance("5121110101", "password"));
    }

    @Test
    public void transfer600NairaIntoAccountBFromAccountABydepositing1000ToAccountATest(){
        Bank bank = new Bank("WorldBank");
        Account accountA = new Account("Adamson", "adamson@gmail.com", "password");
        Account accountB = new Account("Bola", "bola@gmail.com", "password");
        bank.registerAnAccount(accountA);
        bank.registerAnAccount(accountB);
        assertEquals(2, bank.getNumberOfRegisteredAccount());
//        System.out.println(accountA.getAccountNumber()); 5121110101
//        System.out.print(accountB.getAccountNumber()); 5121110102
        bank.deposit("5121110101", 1000);
        assertEquals(1000, accountA.getAccountBalance());
        bank.transfer("5121110101", "5121110102", 600, "password");
        assertEquals(400, accountA.getAccountBalance());
        assertEquals(600, accountB.getAccountBalance());
    }


}