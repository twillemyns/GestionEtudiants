package beans;

import GestionBDD.ConnectionBDD;
import GestionBDD.getTable;

import java.sql.SQLException;
import java.util.ArrayList;

public class Filieres {
    int numFiliere;
    String nomFiliere;

    ConnectionBDD connectionBDD = new ConnectionBDD();
    GestionBDD.getTable getTable = new getTable();
    public Filieres(int numFiliere, String nomFiliere) throws SQLException {
        this.numFiliere = numFiliere;
        this.nomFiliere = nomFiliere;
    }

    public Filieres() throws SQLException {
    }

    private ArrayList<Filieres> listFiliere = getTable.Filieres(connectionBDD.c);

    public ArrayList<Filieres> getListFiliere() {
        return listFiliere;
    }

    public void afficherFilieres(){
        for (Filieres e : listFiliere){
            System.out.println("N° Filière: "+ e.numFiliere + ", Nom Filière: " + e.nomFiliere);
        }
    }
}
