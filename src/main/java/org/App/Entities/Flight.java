package org.App.Entities;

import org.App.Utils.DateTimeUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;


public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private final int id ;
    private final int capacity;
    private final String code;
    private final LocalDateTime takeOffTime;
    private final Airline airline;
    private final Airport from;
    private final Airport to;
    private final List<Passenger> passengers;

    public Flight(int capacity,
                  LocalDateTime dateTime,
                  Airline airline,
                  Airport from,
                  Airport to,
                  List<Passenger> passengers) {
        this.id = idCounter++;
        this.capacity = capacity;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.code = genCode();
        this.takeOffTime = dateTime;
        this.passengers = passengers;
    }

    public Flight(int id,
                  int capacity,
                  String code,
                  LocalDateTime dateTime,
                  Airline airline,
                  Airport from,
                  Airport to,
                  List<Passenger> passengers) {
        idCounter = id;
        this.id = id;
        this.capacity = capacity;
        this.code = code;
        this.takeOffTime = dateTime;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getDate() {
        return takeOffTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public LocalDateTime getTakeOffTime() {
        return takeOffTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return capacity == flight.capacity &&
                code.equals(flight.code) &&
                takeOffTime.equals(flight.takeOffTime) &&
                airline == flight.airline &&
                from == flight.from &&
                to == flight.to &&
                passengers.equals(flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, code, takeOffTime, airline, from, to, passengers);
    }

    @Override
    public String toString() {
        return  String.format("| CODE | %s   -- %15s  %s -- %19s  -- %10s  --->  %-10s | ", code, DateTimeUtil.getDate(takeOffTime), DateTimeUtil.getTime(takeOffTime), airline, from, to);
    }

    private String genCode(){
        Random rand = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(rand.nextInt(10, 99));
        sb.append(this.airline.toString().substring(0, 2));
        sb.append(this.from.toString().charAt(0));
        sb.append(this.to.toString().charAt(0));
        return sb.toString();
    }
}
