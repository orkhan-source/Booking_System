package org.App.DAO;

import org.App.DataBase.Database;
import org.App.Entities.Booking;

import java.util.List;
import java.util.Optional;


public class BookingDao implements Dao<Booking> {

    private Database db = Database.getInstance();

    @Override
    public List<Booking> getAll() {
        return db.getBookings();
    }

    @Override
    public Optional<Booking> get(int id) {
        return Optional.ofNullable(db.getBookings().get(id));
    }

    @Override
    public boolean delete(int id) {
        return db.getBookings().removeIf(booking -> booking.getId() == id);
    }

    @Override
    public boolean create(Booking booking) {
        if(booking == null) return false;
        if(db.getBookings().contains(booking)) return false;
        db.getBookings().add(booking);
        return true;
    }
}
