package org.App.DAO;

import org.App.DataBase.Database;
import org.App.Entities.Flight;

import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight> {

    private Database db = Database.getInstance();
    @Override
    public List<Flight> getAll() {
        return db.getFlights();
    }

    @Override
    public Optional<Flight> get(int id) {
        return Optional.ofNullable(db.getFlights().get(id));
    }

    @Override
    public boolean delete(int id) {
        return db.getFlights().removeIf(flight -> flight.getId() == id);
    }

    @Override
    public boolean create(Flight flight) {
        if(flight == null) return false;
        if(db.getFlights().contains(flight)) return false;
        db.getFlights().add(flight);
        return true;
    }
}
