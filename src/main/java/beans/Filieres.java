package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Filieres {
    int numFiliere;
    String nomFiliere;

    public Filieres(int numFiliere, String nomFiliere){
        this.numFiliere = numFiliere;
        this.nomFiliere = nomFiliere;
    }
    public Filieres() {
    }
Statement stmt =null;
    public void afficherFilieres(Connection c) throws SQLException {
        stmt = c.createStatement();
        ResultSet res = stmt.executeQuery("SELECT numetud , nometud , prenometud , nomfiliere FROM etudiants e, filieres f WHERE e.numfiliere = f.numfiliere ;");
        while (res.next()) {
            int numEtud = res.getInt("numEtud");
            String nometud = res.getString("nometud");
            int prenometud = res.getInt("prenometud");
            int nomFiliere = res.getInt("nomfiliere");

            System.out.print("N° Etudiant: " + numEtud);
            System.out.print(", " + nometud);
            System.out.println(" " + prenometud );
            System.out.println(", Filière: " + nomFiliere );
        }
    }
}
