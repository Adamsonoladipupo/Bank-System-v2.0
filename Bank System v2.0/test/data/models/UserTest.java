package data.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void createANewUserInstanceTest(){
        User user = new User("Adamson", "adamson@gmail.com");
        assertEquals(1, User.getIdNumbers());
    }

}