package org.App.Tests;

import org.App.Controllers.FlightController;
import org.App.Entities.Airline;
import org.App.Entities.Airport;
import org.App.Entities.Flight;
import org.App.Entities.Passenger;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FlightTest {

    @Test
    void flightEqual(){
        Flight flight1 = new Flight(12, LocalDateTime.now(), Airline.AEROSVIT, Airport.BAKU, Airport.BUDAPEST, new ArrayList<Passenger>());
        Flight flight2 = new Flight(12, LocalDateTime.now(), Airline.AEROSVIT, Airport.BAKU, Airport.BUDAPEST, new ArrayList<Passenger>());
        assertFalse(flight1.equals(flight2));
    }
}
