package org.App.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private final int id;
    private final String username;
    private final String name;
    private final String surname;
    private final String password;
    private final List<Booking> bookings;

    public User(String username, String name, String surname, String password, ArrayList<Booking> bookings) {
        this.id = idCounter++;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.bookings = bookings;
    }

    public User(int id, String username, String name, String surname, String password, ArrayList<Booking> bookings) {
        idCounter = id;
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username)
                && name.equals(user.name)
                && surname.equals(user.surname)
                && password.equals(user.password)
                && bookings.equals(user.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, surname, password, bookings);
    }
}
