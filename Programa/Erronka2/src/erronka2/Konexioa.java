package erronka2;

import java.sql.Connection;
import erronka2.GarraioaDatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Arazoak datu basearekin konexioa egitean.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException("Error en la conexión con la base de datos", e);
		}
	}
}
