package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Filieres {
    int numFiliere;
    String nomFiliere;

    public Filieres(int numFiliere, String nomFiliere) {
        this.numFiliere = numFiliere;
        this.nomFiliere = nomFiliere;
    }

    public Filieres() {
    }

    Statement stmt = null;

    public void afficherFilieres(Connection c) throws SQLException {
        stmt = c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM filieres ;");
        while (res.next()) {
            int numFiliere = res.getInt("numfiliere");
            String nomFiliere = res.getString("nomfiliere");

            System.out.print("N° Filière: " + numFiliere);
            System.out.println(", Filière: " + nomFiliere);
        }
    }
}
