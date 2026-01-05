package data.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NIBSSTest {

    @Test
    public void checkIfGeneratedBVNListIsEmptyTest(){
        NIBSS nibss = new NIBSS();
        assertEquals(0, nibss.getCounter());
    }

    @Test
    public void createANewUserInstanceAndRegisterABVNForItTest(){
        NIBSS nibss = new NIBSS();
        User user = new User();
        nibss.registerNewUserForBVN(user);
        assertEquals(1, nibss.getCounter());
        System.out.print(user.getBvn().getBvnString());
    }

}