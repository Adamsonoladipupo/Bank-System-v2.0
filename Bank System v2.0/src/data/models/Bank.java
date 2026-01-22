package data.models;

import exceptions.NonExistingAccountError;

import java.util.ArrayList;

public class Bank{
    private String bankID;
    private int bankCode ;
    private static final int CENTRAL_BANK_CODE = 123;
    private String bankName;
    private int bankBranchNumber = 512;
    private ArrayList <Account> registeredAccounts = new ArrayList<>();
    private static int counter;
    private int count = 0;

    public Bank(String name){
        count++;
        counter++;
        this.bankName = name;
        this.bankCode = generateBankCode();
        this.bankID = generateBankID();
    }

    public static int getCounter(){
        return counter;
    }

    public int getCount() {
        return count;
    }

    public void registerAnAccount(Account account){
        account.setAccountNumber(generateAccountNumber(account));
        account.setNumbaNumber(generateNumbaNumber(account));
        registeredAccounts.add(account);
    }

    public boolean isAccountExist(String accountNumber){
        for (Account account : registeredAccounts){
            if (account.getAccountNumber().equals(accountNumber)) return true;
        }
        return  false;
    }

    public Account createAnAccount(String name,String email, String password) {
        Account newAccount = new Account(name, email,password);
        newAccount.setAccountNumber(generateAccountNumber(newAccount));
        newAccount.setNumbaNumber(generateNumbaNumber(newAccount));
        registeredAccounts.add(newAccount);
        return newAccount;
    }

    public String findAccountNumber(String accountNumber){
        for (Account account : registeredAccounts){
            if (account.getAccountNumber().equals(accountNumber)) return accountNumber;
        }
        throw new NonExistingAccountError("Sorry, this account does not exit");
    }

    public Account findAccountWithAccountNumber(String accountNumber){
        for (Account account : registeredAccounts){
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        throw new NonExistingAccountError("Sorry, this account does not exit");
    }

    public int getAccountsCount(){
        return registeredAccounts.size();
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, int amount, String senderPassword) {
        isAccountExist(senderAccountNumber);
        isAccountExist(receiverAccountNumber);
        findAccountWithAccountNumber(senderAccountNumber).withdraw(amount, senderPassword);
        findAccountWithAccountNumber(receiverAccountNumber).deposit(amount);
    }

    public String getBankID() {
        return bankID;
    }

    public int getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Account> getRegisteredAccounts() {
        return registeredAccounts;
    }

    public int getNumberOfRegisteredAccount(){
        return registeredAccounts.size();
    }

    private String generateBankID() {
        return "BNK" + counter;
    }

    private int generateBankCode(){
        return Bank.CENTRAL_BANK_CODE + counter;
    }

    private String generateAccountNumber(Account account){
        String newAccountNumber = String.valueOf(this.bankBranchNumber) + account.getAccountType() + account.getAccountID();
        return  newAccountNumber;
    }

    private String generateNumbaNumber(Account account){
        int accountSerialNumber = Integer.valueOf(account.getAccountID());
        NUMBA numba = new NUMBA(this.bankCode, accountSerialNumber);
        return  numba.getNumba();
    }

    public void deposit(String accountNumber, int amount) {
        if (!isAccountExist(accountNumber)) throw new NonExistingAccountError("Sorry, account does not exist");
        Account account = findAccountWithAccountNumber(accountNumber);
        account.deposit(amount);
    }

    public boolean isPasswordCorrect(String accountNumber, String password){
        isAccountExist(accountNumber);
        for (Account account : registeredAccounts){
            if (account.getPassword().equals(password)) return true;
        }
        return false;
    }

    public int getAccountBalance(String accountNumber, String password){
        isAccountExist(accountNumber);
        isPasswordCorrect(accountNumber,password);
        return findAccountWithAccountNumber(accountNumber).getAccountBalance();
    }

    public void withdraw(String accountNumber, int amount, String password) {
        isAccountExist(accountNumber);
        isPasswordCorrect(accountNumber,password);
        findAccountWithAccountNumber(accountNumber).withdraw(amount, password);
    }
}
