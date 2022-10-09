package org.App.Menu;

import org.App.Controllers.FlightController;
import org.App.Controllers.UserController;
import org.App.Entities.Flight;
import org.App.Entities.User;
import org.App.Utils.PrintUtil;

import java.util.List;
import java.util.Scanner;

public class Login {
    UserController userController = new UserController();
    FlightController flightController = new FlightController();
    List<Flight> flightList = flightController.getFlights();
    public void login(){

        String username = PrintUtil.getText("Enter username");
        String password = PrintUtil.getText("Enter password");
        User user = userController.getUser(username, password);

        if(user == null){
            System.out.print("Login failed!\n");
        }
        else{
            System.out.print("Login successful\n");
            displayUserMenu(user);
        }
    }


    public void displayUserMenu(User user){
        Book book = new Book();
        int choice = 0;

        do {
            Scanner sc = new Scanner(System.in);
            PrintUtil.userMenu();
            choice = sc.nextInt();

            switch (choice){
                case 1 -> flightList.forEach(System.out::println);
                case 2 -> book.makeBooking(user);
                case 3 -> book.showBooking(user);
                case 4 -> book.cancelBooking(user);
                case 5 -> {}
                default -> System.out.println("Please enter correct option!");
            }
        }while(choice != 5);
    }
}
