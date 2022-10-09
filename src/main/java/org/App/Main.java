package org.App;

import org.App.DataBase.Database;
import org.App.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.initDatabase();
        Menu menu = new Menu();
        menu.displayMainMenu();
        db.closeDatabase();
    }
}