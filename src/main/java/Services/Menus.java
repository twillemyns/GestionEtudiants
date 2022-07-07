package Services;

import GestionBDD.ConnectionBDD;
import beans.Etudiants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menus {
    public static Scanner sc = new Scanner(System.in);
    Etudiants etudiants;

    {
        try {
            etudiants = new Etudiants();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void menuPrincipal(Connection c) throws SQLException {
        int choix;
        do {
            System.out.println("                           Menu principal");
            System.out.println("======================================================================");
            System.out.println("=  Tapez 1 pour afficher les étudiants d'une filière                 =");
            System.out.println("");
            System.out.println("=  Tapez 2 pour afficher l'ensemble des étudiants                    =");
            System.out.println("");
            System.out.println("=  Tapez 3 pour modifier le nom et/ou le prénom d'un étudiant        =");
            System.out.println("");
            System.out.println("=  Tapez 4 pour ajouter un nouvel étudiant                           =");
            System.out.println("");
            System.out.println("=  Tapez 5 pour supprimer un étudiant                                =");
            System.out.println("======================================================================");
            System.out.println("                 Tapez 6 pour quitter le programme");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    new Case1(c);
                case 2:
                    etudiants.affichertousEtudiants(c);
                case 3:

                case 4:

                case 5:

            }
        }while(choix != 6);
    }
}
