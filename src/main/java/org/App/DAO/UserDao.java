package org.App.DAO;

import org.App.DataBase.Database;
import org.App.Entities.User;


import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private Database db = Database.getInstance();

    @Override
    public List<User> getAll() {
        return db.getUsers();
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.of(db.getUsers().get(id));
    }

    @Override
    public boolean delete(int id) {
        return db.getUsers().removeIf(x -> x.getId() == id);
    }

    @Override
    public boolean create(User user) {
        if(user == null) return false;
        if(db.getUsers().contains(user)) return false;
        db.getUsers().add(user);
        return true;
    }
}
