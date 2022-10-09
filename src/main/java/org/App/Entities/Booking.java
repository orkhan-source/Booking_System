package org.App.Entities;


import org.App.Utils.DateTimeUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private final int id ;
    private final Flight flight;
    private final User user;
    private final Passenger passenger;

    private final LocalDateTime bookedTime;

    public Booking(Flight flight, User user, Passenger passenger, LocalDateTime bookedTime) {
        this.id = idCounter++;
        this.flight = flight;
        this.user = user;
        this.passenger = passenger;
        this.bookedTime = bookedTime;
    }

    public Booking(int id, Flight flight, User user, Passenger passenger, LocalDateTime bookedTime) {
        idCounter = id;
        this.id = id;
        this.flight = flight;
        this.user = user;
        this.passenger = passenger;
        this.bookedTime = bookedTime;
    }

    public int getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public LocalDateTime getBookedTime() {
        return bookedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id &&
                flight.equals(booking.flight) &&
                passenger.equals(booking.passenger) &&
                bookedTime.equals(booking.bookedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight, passenger, bookedTime);
    }

    @Override
    public String toString() {
        return  String.format("ID : %d \n Flight: %s \n Passenger : %s \n Booked time : %s, %s", id, flight, passenger, DateTimeUtil.getDate(bookedTime), DateTimeUtil.getTime(bookedTime));
    }
}
