package Services;

import beans.Etudiants;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Case5 {
    Etudiants etudiants =new Etudiants();
    Scanner sc = new Scanner(System.in);

    public Case5(Connection c) throws SQLException {
        etudiants.affichertousEtudiants(c);
        System.out.println("Saisissez le numéro de l'étudiant que vous souhaitez supprimer:");
        int choix = sc.nextInt();
        Statement stmt = c.createStatement();
        stmt.executeUpdate("DELETE FROM etudiants WHERE numetud = "+choix+";");
    }
}
