package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Etudiants {
    int numEtud;
    String nomEtud;
    String prenomEtud;
    int numFiliere;

    public Etudiants(int numEtud, String nomEtud, String prenomEtud, int numFiliere) {
        this.numEtud = numEtud;
        this.nomEtud = nomEtud;
        this.prenomEtud = prenomEtud;
        this.numFiliere = numFiliere;
    }

    public Etudiants() throws SQLException {
    }

    public void afficherEtudiantsByFiliere(int choix, Connection c) throws SQLException {
        stmt = c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT numetud , nometud , prenometud FROM etudiants e WHERE numfiliere = '" + choix + "' ORDER BY numetud;");
        while (res.next()) {
            int numEtud = res.getInt("numEtud");
            String nometud = res.getString("nometud");
            String prenometud = res.getString("prenometud");

            System.out.print("N° Etudiant: " + numEtud);
            System.out.print(", " + nometud);
            System.out.println(" " + prenometud);
        }
    }
    public int getNumEtudmax(Connection c) throws SQLException {
        stmt = c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT MAX(numetud) FROM etudiants e ;");
        int max = 0;
        while (res.next()) {
            max = res.getInt("max");
        }
        return max;
    }
    Statement stmt = null;

    public void affichertousEtudiants(Connection c) throws SQLException {
        stmt = c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT numetud , nometud , prenometud , nomfiliere FROM etudiants e, filieres f WHERE e.numfiliere = f.numfiliere ORDER BY numetud;");
        while (res.next()) {
            int numEtud = res.getInt("numEtud");
            String nometud = res.getString("nometud");
            String prenometud = res.getString("prenometud");
            String nomFiliere = res.getString("nomfiliere");

            System.out.print("N° Etudiant: " + numEtud);
            System.out.print(", " + nometud);
            System.out.print(" " + prenometud);
            System.out.println(", Filière: " + nomFiliere);
        }
    }
}
