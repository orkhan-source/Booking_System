package org.App.Services;

import org.App.DAO.UserDao;
import org.App.Entities.User;


public class UserService {
    private UserDao userDao = new UserDao();


    public User getUser(String username, String password){
        return userDao.getAll().stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst().orElse(null);
    }
    public boolean isPasswordExist(String password){
        return userDao.getAll().stream().anyMatch(u -> u.getPassword().equals(password));
    }

    public boolean registerUser(User user){
        return userDao.create(user);
    }

    public boolean getUserLogin(String username, String password){
        return userDao.getAll().stream().anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }










}
