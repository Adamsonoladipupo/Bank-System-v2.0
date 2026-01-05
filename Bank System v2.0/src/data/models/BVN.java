package data.models;

import java.util.Random;

public class BVN {
    private User user;
    private String bvn;

    public BVN (User user){
        user.setBvn(generateBVN());
    }

    public String getBvnString(){
        return this.bvn;
    }

    public User getUser(){
        return this.user;
    }

    @Override
    public String toString() {
        return this.bvn;
    }

    private BVN generateBVN(){
        BVN bvn1 = new BVN();
        Random random = new Random();
        String newBVN = "";
        for (int generate = 0; generate < 11; generate++){
            int number = random.nextInt(10);
            newBVN += number;
        }
        //this.bvn = newBVN;
        bvn1.bvn = newBVN;
        return bvn1;
    }

    private BVN(){}
}
