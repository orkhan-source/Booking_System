package org.App.Tests;

import org.App.Entities.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class BookingTest {

    @Test
    void bookingEqual(){
        Flight flight1 = new Flight(12, LocalDateTime.now(), Airline.AEROSVIT, Airport.BAKU, Airport.BUDAPEST, new ArrayList<Passenger>());
        Flight flight2 = new Flight(12, LocalDateTime.now(), Airline.AEROSVIT, Airport.BAKU, Airport.BUDAPEST, new ArrayList<Passenger>());
        User u1 = new User("orkhanb", "Orkhan", "B", "123o", new ArrayList<Booking>());
        User u2 = new User("orkhanb", "Orkhan", "B", "123o", new ArrayList<Booking>());

        Booking b1 = new Booking(flight1, u1, new Passenger("A", "b"), LocalDateTime.now());
        Booking b2 = new Booking(flight2, u2, new Passenger("B", "c"), LocalDateTime.now());

        assertFalse(b1.equals(b2));
    }
}
