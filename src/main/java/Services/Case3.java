package Services;

import beans.Etudiants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Case3 {
    Etudiants etudiants = new Etudiants();
    Scanner sc = new Scanner(System.in);
    Statement stmt;

    public Case3(Connection c) throws SQLException {
        etudiants.affichertousEtudiants(c);
        System.out.println("Saisissez le numéro de l'étudiant dont vous souhaitez modifier son nom ou prénom:");
        int choixNumEtud = sc.nextInt();
        System.out.println("Tapez 1 pour modifier le nom ou 2 pour modifier le prénom");
        int choixModif = sc.nextInt();
        sc.nextLine();
        System.out.println("Saisissez le nouveau nom/prénom:");
        String modif = sc.nextLine();
        stmt = c.createStatement();
        stmt.executeUpdate("UPDATE etudiants SET " + (choixModif == 1 ? "nometud" : "prenometud") + " = '" + modif + "' WHERE numetud = " + choixNumEtud + " ;");
    }
}
