package org.App.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintUtil {

    public static void mainMenu(){
        System.out.print("""
                \n1. Login
                2. Register
                3. View flights
                4. Exit
                """);
    }

    public static void userMenu(){
        System.out.print("""
                \n1. View flights
                2. Search and make a booking
                3. View my booking list
                4. Cancel booking
                5. Log out
                """);
    }

    public static String getText(String text){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s: ", text);
        return sc.nextLine();
    }


    public static int getNum(String text) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s: ", text);
        return sc.nextInt();
    }
}
