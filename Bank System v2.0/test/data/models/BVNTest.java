package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BVNTest {

    @Test
    public void checkIfNoBVNIsCreateTest(){
        User user = new User();
        BVN newBVN = new BVN(user);
        System.out.println(user.getBvn());
    }

}