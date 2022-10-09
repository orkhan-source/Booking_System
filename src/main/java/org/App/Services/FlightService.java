package org.App.Services;

import org.App.DAO.FlightDao;
import org.App.Entities.Flight;
import org.App.Utils.DateTimeUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDao flightDao = new FlightDao();

    public List<Flight> getFlights(){
        return flightDao.getAll();
    }

    public Flight getFlight(String code){
        return flightDao.getAll().stream().filter(f -> f.getCode().equals(code)).findFirst().get();
    }

    public List<Flight> searchFlights(String origin, String destination, String date, int passNum){
        return flightDao.getAll().stream().filter(f -> f.getFrom().toString().equals(origin)
                && f.getTo().toString().equals(destination)
                && DateTimeUtil.getDate(f.getTakeOffTime()).equals(date)
                && f.getCapacity() >= passNum).toList();
    }

}
