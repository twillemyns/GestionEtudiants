package Services;

import beans.Etudiants;
import beans.Filieres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Case1 {
    Filieres filieres = new Filieres();
    Etudiants etudiants = new Etudiants();
    int choix;
    Scanner sc = new Scanner(System.in);

    public Case1(Connection c) throws SQLException {
        filieres.afficherFilieres(c);
        System.out.println("Saisissez le numéro de la filière dont vous souhaitez afficher ses étudiants:");
        choix = sc.nextInt();
        etudiants.afficherEtudiantsByFiliere(choix, c);
    }
}