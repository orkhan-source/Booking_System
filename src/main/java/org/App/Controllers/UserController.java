package org.App.Controllers;

import org.App.Entities.User;
import org.App.Services.UserService;

import java.util.Optional;

public class UserController {
    private UserService userService = new UserService();

    public User getUser(String username, String password){
        return userService.getUser(username, password);
    }
    public boolean isPasswordExist(String password){
        return userService.isPasswordExist(password);
    }

    public boolean registerUser(User user){
        return userService.registerUser(user);
    }

    public boolean getUserLogin(String username, String password){
        return userService.getUserLogin(username, password);
    }
}
