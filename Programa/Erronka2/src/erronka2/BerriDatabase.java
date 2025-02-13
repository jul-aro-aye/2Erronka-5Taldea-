package erronka2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BerriDatabase {

	private Connection connection;

	public BerriDatabase(Connection connection) {
		this.connection = connection;
	}

	public BerriDatabase(String url, String user, String password) throws SQLException {
		this.connection = DriverManager.getConnection(url, user, password);
	}

	public BerriDatabase() {
		try {
//            this.connection = DriverManager.getConnection("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//					"1MG3EkoTekno@");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> lortuLangileak() {
		List<String> langileak = new ArrayList<>();
		String sql = "SELECT izenAbizenak FROM langilea";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				langileak.add(rs.getString("izenAbizenak"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return langileak;
	}

	public List<Berria> lortuBerriak() {
		List<Berria> berriak = new ArrayList<>();
		String sql = "SELECT idBerria, izenburua, textua, data, l.izenAbizenak FROM berria INNER JOIN langilea l ON berria.Langilea_idLangilea = l.idLangilea;";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				berriak.add(new Berria(rs.getInt("idBerria"), rs.getString("izenburua"), rs.getString("textua"),
						rs.getString("data"), rs.getString("izenAbizenak")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return berriak;
	}

	public boolean gehituBerria(Berria berria) {
		String sql = "INSERT INTO berria (izenburua, textua, data, Langilea_idLangilea) VALUES (?, ?, ?, (SELECT idLangilea FROM langilea WHERE izenAbizenak = ?));";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, berria.getIzenburua());
			stmt.setString(2, berria.getTestua());
			stmt.setString(3, berria.getData());
			stmt.setString(4, berria.getLangilea());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean eguneratuBerria(Berria berria) {
		String sql = "UPDATE berria SET izenburua = ?, textua = ?, data = ?, Langilea_idLangilea = (SELECT idLangilea FROM langilea WHERE izenAbizenak = ?) WHERE idBerria = ?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, berria.getIzenburua());
			stmt.setString(2, berria.getTestua());
			stmt.setString(3, berria.getData());
			stmt.setString(4, berria.getLangilea());
			stmt.setInt(5, berria.getIdBerria());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean ezabatuBerria(int idBerria) {
		String sql = "DELETE FROM berria WHERE idBerria = ?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, idBerria);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void close() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
