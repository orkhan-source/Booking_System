package org.App.Menu;


import org.App.Controllers.BookingController;
import org.App.Controllers.FlightController;
import org.App.Entities.Booking;
import org.App.Entities.Flight;
import org.App.Entities.Passenger;
import org.App.Entities.User;
import org.App.Exceptions.FlightNotFoundException;
import org.App.Utils.PrintUtil;


import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;


public class Book {

    BookingController bookingController = new BookingController();
    FlightController flightController = new FlightController();

    private int passengerCount;


    public List<Flight> searchFlight() throws FlightNotFoundException {
        List<Flight> foundedFlights;

        String origin = PrintUtil.getText("Enter origin").toUpperCase();
        String destination = PrintUtil.getText("Enter destination").toUpperCase();
        String date = PrintUtil.getText("Enter date (dd.MM.yyyy)");


        try{
            this.passengerCount = PrintUtil.getNum("Enter number of passenger");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!!");
        }

        foundedFlights = flightController.searchFlights(origin, destination, date, passengerCount);
        if(foundedFlights.isEmpty()){
            throw new FlightNotFoundException("Not any flight founded\n");
        }
        return foundedFlights;
    }

    public void makeBooking(User user) {
        List<Flight> foundedFlights;

        try{
            foundedFlights = searchFlight();
        }catch (FlightNotFoundException e){
            System.out.println("Not any flight founded\n");
            return;
        }


        foundedFlights.forEach(System.out::println);
        String choice = PrintUtil.getText("Do you want to make a booking ? (Y/N)").toUpperCase();
        if(choice.equals("N")){
            return;
        }

        String code = PrintUtil.getText("Enter flight code").toUpperCase();
        Flight flight = flightController.getFlight(code);

        for (int i = 0; i < passengerCount; i++) {
            int numPass = i + 1;
            String name = PrintUtil.getText("Enter passenger name " + numPass);
            String surname = PrintUtil.getText("Enter passenger surname " + numPass);
            Booking booking = new Booking(flight, user, new Passenger(name, surname), LocalDateTime.now());

            if(bookingController.makeBooking(booking)){
                user.getBookings().add(booking);
                System.out.print("Successfully booked\n");
            }
            else{
                System.out.println("Can not make a booking\n");
            }

        }

    }


    public void cancelBooking(User user){
        showBooking(user);
        int choice;
        try{
            choice = PrintUtil.getNum("Enter booking id");
        }catch (Exception e){
            System.out.println("Invalid input!!!");
            return;
        }

        if(bookingController.cancelBooking(choice)){
            user.getBookings().removeIf(b -> b.getId() == choice);
            System.out.print("Booking cancelled\n");
        }else {
            System.out.print("Can not cancel booking\n");
        }
    }

    public void showBooking(User user){
        bookingController.getBookingsByUser(user).forEach(System.out::println);
    }

}
