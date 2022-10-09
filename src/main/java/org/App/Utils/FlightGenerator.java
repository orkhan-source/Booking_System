package org.App.Utils;

import org.App.Entities.Airline;
import org.App.Entities.Airport;
import org.App.Entities.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightGenerator {

    private static Random rand = new Random();

    public static int genCapacity(){
        return rand.nextInt(50, 100);
    }

    public static LocalDateTime genTakeOffTime(){

        long minDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        LocalTime randomTime = LocalTime.of(rand.nextInt(24), (rand.nextInt(60)/30)*30);

        return LocalDateTime.of(randomDate, randomTime);
    }

    public static Airline genAirline(){return Airline.values()[rand.nextInt(Airline.values().length)];}

    public static Airport genAirport(){return Airport.values()[rand.nextInt(Airport.values().length)];}


    public static List<Flight> genFlights(int times){

        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < times ; i++) {
            int capacity = genCapacity();
            LocalDateTime localDateTime = genTakeOffTime();
            Airline airline = genAirline();
            Airport from = genAirport();
            Airport to = genAirport();
            while(from.equals(to)){
                from = genAirport();
                to = genAirport();
            }
            flights.add(new Flight(capacity, localDateTime, airline, from, to, new ArrayList<>()));
        }


        return flights;
    }


    public static void main(String[] args) {
        FlightGenerator flightGenerator = new FlightGenerator();
        flightGenerator.genFlights(50).forEach(f -> System.out.println(f));

    }


}
