package GestionBDD;

import Services.Menus;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBDD {
    public Connection c = null;
    Menus menu = new Menus();

    public void connectBDD() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/etudiants",
                    "postgres", "Leblond59");
            menu.menuPrincipal(c);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
