import GestionBDD.ConnectionBDD;

public class Main {
    public static void main(String[] args) {
        ConnectionBDD connectionBDD = new ConnectionBDD();
        connectionBDD.connectBDD();
    }
}
