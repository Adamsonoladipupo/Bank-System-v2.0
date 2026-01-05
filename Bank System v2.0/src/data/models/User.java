package data.models;

import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private ArrayList <Account> accounts = new ArrayList<>();
    private BVN bvn;

    public User (){}

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
