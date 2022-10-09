package org.App.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();
    Optional<T> get(int id);
    boolean delete(int id);
    boolean create(T t);

}
