package data.models;

import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String email;
    private ArrayList <Account> accounts = new ArrayList<>();
    private BVN bvn;
    private static int idNumbers = 0;

    public User (){}

    public User (String name, String email){
        this.name = name;
        this.email = email;
        this.userID = generateUserID();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String generateUserID(){
        idNumbers++;
        return String.valueOf(idNumbers);
    }

    public static int getIdNumbers(){
        return idNumbers;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public BVN getBvn() {
        return bvn;
    }

    public void setBvn(BVN bvn) {
        this.bvn = bvn;
    }
}
