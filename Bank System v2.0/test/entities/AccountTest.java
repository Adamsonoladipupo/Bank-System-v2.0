package entities;

import exceptions.InsufficientFundsException;
import exceptions.InvalidEmailAddressException;
import exceptions.NegativeAmountException;
import exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;
    Account account1;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void CreateNewAccountInstancesTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        assertEquals(1, account.getCount());
    }

    @Test
    public void CreateAnAccountWithAnInvalidEmailTest(){
        assertThrows(InvalidEmailAddressException.class, ()-> account = new Account("Adamson Oladipupo", "adamson", "password"));
    }

    @Test
    public void CheckAccountBalanceOfAnAccountToBeZeroTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        assertEquals(0, account.getAccountBalance());
    }

    @Test
    public void Deposit500IntoANewAccountTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        account.deposit(500);
        assertEquals(500, account.getAccountBalance());
    }

    @Test
    public void DepositANegativeAmountIntoAnAccountTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        assertThrows(NegativeAmountException.class, ()-> account.deposit(-500));
        assertEquals(0, account.getAccountBalance());
    }

    @Test
    public void withdraw500FromAnAccountWithZeroAccountBalanceTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(500, "password"));
        assertEquals(0, account.getAccountBalance());
    }

    @Test
    public void withdrawNegativeAmountFromAnAccountTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        account.deposit(500);
        assertEquals(500, account.getAccountBalance());
        assertThrows(NegativeAmountException.class, ()-> account.withdraw(-500, "password"));
    }

    @Test
    public void withdraw500WithAWrongPasswordTest(){
        account = new Account("Adamson Oladipupo", "Adamson@gmail.com", "password");
        account.deposit(500);
        assertThrows(WrongPasswordException.class, ()-> account.withdraw(-500, "passd"));
    }

}