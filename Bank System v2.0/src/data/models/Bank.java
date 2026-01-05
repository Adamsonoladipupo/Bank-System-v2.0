package data.models;

import java.util.ArrayList;

public class Bank {
    private String bankID;
    private int bankCode ;
    private static final int CENTRAL_BANK_CODE = 123;
    private String bankName;
    private int bankBranchNumber = 512;
    private ArrayList <Account> registeredAccounts = new ArrayList<>();
    private static int counter;

    public Bank(String name){
        counter++;
        this.bankName = name;
        this.bankCode = generateBankCode();
        this.bankID = generateBankID();
    }

    public static int getCounter(){
        return counter;
    }

    public void registerAnAccount(Account account) {
        account.setAccountNumber(generateAccountNumber(account));
        account.setNumbaNumber(generateNumbaNumber(account));
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

}
