package org.App.Menu;

import org.App.Controllers.FlightController;
import org.App.Entities.Flight;
import org.App.Utils.PrintUtil;

import java.util.List;
import java.util.Scanner;

public class Menu {
    FlightController flightController = new FlightController();
    List<Flight> flightList = flightController.getFlights();


    public void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        Login login = new Login();
        Register register = new Register();

        do{
            PrintUtil.mainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> login.login();
                case 2 -> register.registerUser();
                case 3 -> flightList.forEach(System.out::println);
                case 4 -> {}
                default -> System.out.print("Please enter correct option!\n");
            }

        }while(choice != 4);

    }

}
