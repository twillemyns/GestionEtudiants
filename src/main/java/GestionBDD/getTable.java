package GestionBDD;

import beans.Etudiants;
import beans.Filieres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getTable {
    Statement stmt = null;

    public ArrayList<Etudiants> Etudiants(ConnectionBDD conn) throws SQLException {
        stmt = conn.c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM etudiants ORDER BY numetud;");
        ArrayList<Etudiants> etudiants = null;
        while (res.next()) {
            int numEtud = res.getInt("numetud");
            String nomEtud = res.getString("nomEtud");
            String prenomEtud = res.getString("prenometud");
            int numfiliere = res.getInt("numfiliere");

            etudiants = new ArrayList<>();
            etudiants.add(new Etudiants(numEtud, nomEtud, prenomEtud, numfiliere));
        }
        return etudiants;
    }

    public ArrayList<Filieres> Filieres(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM filieres ORDER BY numfiliere;");
        ArrayList<Filieres> filieres = null;
        while (res.next()) {
            int numfiliere = res.getInt("numfiliere");
            String nomFiliere = res.getString("nomFiliere");

            filieres = new ArrayList<>();
            filieres.add(new Filieres(numfiliere, nomFiliere));
        }
        return filieres;
    }


}
