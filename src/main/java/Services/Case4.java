package Services;

import beans.Etudiants;
import beans.Filieres;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Case4 {
    Scanner sc = new Scanner(System.in);
    Filieres filieres = new Filieres();
    Statement stmt;
    Etudiants etudiants = new Etudiants();

    public Case4(Connection c) throws SQLException {
        System.out.println("Saisissez le nom de famille du nouvel étudiant:");
        String nom = sc.nextLine();
        System.out.println("Saisissez le prénom du nouvel étudiant:");
        String prenom = sc.nextLine();
        filieres.afficherFilieres(c);
        System.out.println("Saisissez le numéro de la filière que va intégrer le nouvel étudiant:");
        int numFiliere = sc.nextInt();
        int numEtud = etudiants.getNumEtudmax(c)+1;
        System.out.println(numEtud);
        stmt = c.createStatement();
        stmt.executeUpdate("INSERT INTO etudiants VALUES ("+numEtud+", '"+nom+"', '"+prenom+"', "+numFiliere+");");
    }
}
