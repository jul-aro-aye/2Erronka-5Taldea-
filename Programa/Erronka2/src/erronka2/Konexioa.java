package erronka2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

    private String url;
    private String erabiltzailea;
    private String pasahitza;

    public Konexioa(String url, String erabiltzailea, String pasahitza) {
        this.url = url;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
    }

    public Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, erabiltzailea, pasahitza);
            System.out.println("Konexioa ongi joan da .");
            return conn;
        } catch (SQLException e) {
            System.out.println("Arazoak datu basearekin konexioa egitean.");
            throw e;
        }
    }
}
