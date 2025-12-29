package entities;

import java.util.ArrayList;

public class Bank {
    private String bankID;
    private int bankCode ;
    private static final int CENTRAL_BANK_CODE = 12345;
    private String bankName;
    private ArrayList <Account> registeredAccounts = new ArrayList<>();
    private static int counter;

    public Bank(String name){
        counter++;
        this.bankName = name;
        this.bankCode = generateBankCode();
        this.bankID = generateBankID();
    }

    private String generateBankID() {
        return "BNK" + counter;
    }

    private int generateBankCode(){
        return Bank.CENTRAL_BANK_CODE + counter;
    }

    private String generateAccountNumber(Account account, int bankCode){
        return  "0" + account.getAccountID() + bankCode;
    }

    public static int getCounter(){
        return counter;
    }

    public void createAccount(String name, String email , String password) {
        Account account = new Account(name, email, password);
        account.setAccountNumber(generateAccountNumber(account, this.bankCode));
        registeredAccounts.add(account);
    }

    public int getAccountsCount(){
        return registeredAccounts.size();
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

}
