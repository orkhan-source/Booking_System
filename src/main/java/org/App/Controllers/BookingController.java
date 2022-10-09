package org.App.Controllers;

import org.App.Entities.Booking;
import org.App.Entities.User;
import org.App.Services.BookingService;

import java.util.List;

public class BookingController {
    BookingService bookingService = new BookingService();
    public boolean makeBooking(Booking booking){
        return bookingService.makeBooking(booking);
    }

    public Booking getBooking(int id){
        return bookingService.getBooking(id);
    }

    public List<Booking> getBookings(){
        return bookingService.getBookings();
    }
    public boolean cancelBooking(int id){
        return bookingService.cancelBooking(id);
    }
    public List<Booking> getBookingsByUser(User user){
        return bookingService.getBookingsByUser(user);
    }

}
