package entities;

import exceptions.InsufficientFundsException;
import exceptions.InvalidEmailAddressException;
import exceptions.NegativeAmountException;
import exceptions.WrongPasswordException;

public class Account {
    private String accountID;
    private String bvnNumber;
    private String numbaNumber;
    private String accountNumber;
    private String accountName;
    private String email;
    private String password;
    private int accountBalance;
    private static final int GENRATE_ID = 1101;
    private static int count;


    public Account(String name, String email, String password){
        this.accountID = generateAccountID();
        this.accountName = name;
        validEmailAddress(email);
        this.email = email;
        this.password = password;
        this.accountBalance = 0;
    }

    private static String generateAccountID(){
        count++;
        return count + GENRATE_ID + "";
    }

    public String getAccountID(){
        return this.accountID;
    }

    public static int getCount() {
        return count;
    }

    public String getBvnNumber() {
        return bvnNumber;
    }

    public void setBvnNumber(String bvnNumber) {
        this.bvnNumber = bvnNumber;
    }

    public String getNumbaNumber() {
        return numbaNumber;
    }

    public void setNumbaNumber(String numbaNumber) {
        this.numbaNumber = numbaNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(int amount) {
        if(amount < 0) throw new NegativeAmountException("negative amount cannot be deposited");
        this.accountBalance += amount;
    }

    public void withdraw(int amount, String password) {
        validatePassword(password);
        validateWithdrawalOperations(amount);
        this.accountBalance -= amount;
    }

    public void validEmailAddress(String email){
        boolean checkAt = false; boolean checkDot = false;
        for (int check = 0; check < email.length(); check++){
            char character = email.charAt(check);
            if(character == '@') checkAt = true;
            if(character == '.') checkDot = true;
        }
        if (!checkAt == true || !checkDot == true){
            throw new InvalidEmailAddressException("invalid emial, please enter a valid email");
        }
    }

    public void validateWithdrawalOperations(int amount){
        if (amount < 0) throw new NegativeAmountException("negative amount cannot be withdrawn");
        if (this.accountBalance < amount) throw new InsufficientFundsException("Insufficient funds, please fund your account");
    }

    public void validatePassword(String password){
        if (!this.password.equals(password)) throw new WrongPasswordException("you entered a wrong password");
    }

}
