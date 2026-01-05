package data.models;

import exceptions.BVNDuplicateException;
import exceptions.NonExistingUserException;

import java.util.ArrayList;

public class NIBSS {
    private ArrayList<BVN> generateBVN = new ArrayList<>();
    private int counter;

    public NIBSS (){}

    public int getCounter(){
        return this.counter;
    }

    public void registerNewUserForBVN(User user){
        if (!isBVNExist(user.getBvn())){
            BVN bvn = new BVN(user);
            if (generateBVN.contains(bvn.getBvnString())) throw new BVNDuplicateException("BVN exist already, please reapply");
            generateBVN.add(bvn);
            counter++;
        }
        return;
    }

    public boolean isBVNExist(BVN bvn){
        return generateBVN.contains(bvn);
    }

    public User findUserWithBVNString(String bvn){
        for (BVN existingBVNs : generateBVN){
            if (existingBVNs.getBvnString().equals(bvn)) return existingBVNs.getUser();
        }
        throw new NonExistingUserException("Sorry, this bnv is not linked to any user");
    }

    private User findUserWithBVN(User user){
        return findUserWithBVNString(user.getBvn().getBvnString());
    }
}
