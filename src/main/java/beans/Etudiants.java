package beans;

import GestionBDD.ConnectionBDD;
import GestionBDD.getTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Etudiants {
    int numEtud;
    String nomEtud;
    String prenomEtud;
    int numFiliere;
    ConnectionBDD connectionBDD = new ConnectionBDD();
    getTable getTable = new getTable();

    public Etudiants(int numEtud, String nomEtud, String prenomEtud, int numFiliere) throws SQLException {
        this.numEtud = numEtud;
        this.nomEtud = nomEtud;
        this.prenomEtud = prenomEtud;
        this.numFiliere = numFiliere;
    }

    public Etudiants() throws SQLException {
    }

    ArrayList<Etudiants> listEtudiants = getTable.Etudiants(connectionBDD) ;

    public void afficherEtudiantsByFiliere(int choix){
        for (Etudiants e : listEtudiants){
            if (e.numFiliere == choix){
                System.out.println("N° Etudiant: "+e.nomEtud+", Nom: "+e.nomEtud+", Prénom: "+e.prenomEtud);
            }
        }
    }
    Statement stmt = null;
    public void affichertousEtudiants(Connection c) throws SQLException {
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery("");
            while (res.next()) {
                int noRoom = res.getInt("noroom");
                String description = res.getString("description");
                int prix = res.getInt("prix");

                System.out.print("N° Chambre: " + noRoom);
                System.out.print(", " + description);
                System.out.println(", Prix: " + prix + "€");
            }
    }
}
