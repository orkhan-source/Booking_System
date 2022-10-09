package org.App.Tests;


import org.App.Controllers.UserController;
import org.App.Entities.Booking;
import org.App.Entities.User;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    UserController userController = new UserController();

    @Test
    void isUserEqual(){
        User u1 = new User("orkhanb", "Orkhan", "B", "123o", new ArrayList<Booking>());
        User u2 = new User("orkhanb", "Orkhan", "B", "123o", new ArrayList<Booking>());
        assertEquals(u1, u2);
    }

    @Test
    void passwordCheck(){
        assertFalse(userController.isPasswordExist("111")); // return always true, because 111 should not be a password
    }

}

