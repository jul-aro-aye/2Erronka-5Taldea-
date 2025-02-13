package erronka2;

import java.sql.*;
import java.util.*;

public class EskaeraDatabase {

	private Connection connection;

	public EskaeraDatabase(Connection connection) {
		this.connection = connection;
	}

	public EskaeraDatabase(String url, String user, String password) throws SQLException {
		this.connection = DriverManager.getConnection(url, user, password);
	}

	public List<Eskaera> EskaeraGuztiak() throws SQLException {
	    List<Eskaera> eskaerak = new ArrayList<>();
	    String query = "select e.id, b.izenAbizenak, e.kopurua, e.data, g.enpresaIzena AS \"Garaio enpresa\", e.egoera " +
	                   "from eskaera e " +
	                   "left join bezeroa b on b.idBezeroa = e.Bezeroa_idBezeroa " +
	                   "left join garraioa g on g.idGarraioa = e.Garraioa_idGarraioa;";

	    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
	        while (rs.next()) {
	            int idEskaera = rs.getInt("id");
	            int kopurua = rs.getInt("kopurua");
	            String data = rs.getString("data");
	            String langilea = rs.getString("izenAbizenak");
	            String egoera = rs.getString("egoera");
	            String garaioEnpresa = rs.getString("Garaio enpresa");

	            eskaerak.add(new Eskaera(idEskaera, kopurua, data, langilea, egoera, garaioEnpresa));
	        }
	    }
	    return eskaerak;
	}


	public static void updateEskaera(Connection konexioadb, Eskaera eskaera, String langilea) throws SQLException {
	    
	    String sql = "SELECT idLangilea FROM langilea WHERE izenAbizenak = ?";
	    String idLangilea = null;

	    try (PreparedStatement stmt = konexioadb.prepareStatement(sql)) {
	        stmt.setString(1, langilea);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                idLangilea = rs.getString("idLangilea");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("Error al obtener el id del Langilea.", e);
	    }

	    if (idLangilea != null) {

	    	String query = "UPDATE eskaera SET egoera = ?, Langilea_idLangilea = ? WHERE id = ?";

	        try (PreparedStatement stmt = konexioadb.prepareStatement(query)) {
	            stmt.setString(1, eskaera.getEgoera());
	            stmt.setString(2, idLangilea);
	            stmt.setInt(3, eskaera.getIdEskaera());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new SQLException("Araziak eguneraketa egitean.", e);
	        }
	    } else {
	        throw new SQLException("Ez da langilerik aurkitu.");
	    }
	}
	
	public boolean ezabatuDB(int idEskaera) throws SQLException {

	    String query1 = "DELETE FROM produktua_has_eskaera WHERE eskaera_id = ?";
	    try (PreparedStatement stmt1 = connection.prepareStatement(query1)) {
	        stmt1.setInt(1, idEskaera);

	        int rowsAffected1 = stmt1.executeUpdate();

	        String query2 = "DELETE FROM eskaera WHERE id = ?";
	        try (PreparedStatement stmt2 = connection.prepareStatement(query2)) {
	            stmt2.setInt(1, idEskaera);

	            int rowsAffected2 = stmt2.executeUpdate();

	            return rowsAffected1 > 0 && rowsAffected2 > 0;
	        }
	    }
	}

	public void close() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
