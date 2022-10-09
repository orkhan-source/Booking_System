package org.App.Controllers;

import org.App.Entities.Flight;
import org.App.Services.FlightService;

import java.util.List;

public class FlightController {
    private FlightService flightService = new FlightService();

    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    public Flight getFlight(String code){
        return flightService.getFlight(code);
    }

    public List<Flight> searchFlights(String origin, String destination, String date, int passNum){
        return flightService.searchFlights(origin, destination, date, passNum);
    }

}
