package erronka2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduktuaDatabase {
    private Connection konexioa;

    public ProduktuaDatabase(Connection konexioa) {
        this.konexioa = konexioa;
    }

    public List<Produktua> lortuProduktuenZerrenda() throws SQLException {
        List<Produktua> produktuak = new ArrayList<>();
        String query = "SELECT idProduktua, izena, mota, marka, modeloa, stock, prezioa, Hornitzailea_idHornitzailea FROM produktua";
        
        try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idProduktua = rs.getInt("idProduktua");
                String izena = rs.getString("izena");
                String mota = rs.getString("mota");
                String marka = rs.getString("marka");
                String modeloa = rs.getString("modeloa");
                int stock = rs.getInt("stock");
                double prezioa = rs.getDouble("prezioa");
                int idHornitzailea = rs.getInt("Hornitzailea_idHornitzailea");

                Produktua produktua = new Produktua(
                    idProduktua, izena, mota, marka, modeloa, stock, prezioa, idHornitzailea);
                produktuak.add(produktua);
            }
        }

        return produktuak;
    }



    public void gehituProduktua(Produktua produktua) throws SQLException {
    	String query = "INSERT INTO produktua (izena, mota, marka, modeloa, stock, prezioa, Hornitzailea_idHornitzailea) VALUES (?, ?, ?, ?, ?, ?, ?)";

    	try (PreparedStatement stmt = konexioa.prepareStatement(query)) {
    	    stmt.setString(1, produktua.getIzena());
    	    stmt.setString(2, produktua.getMota());
    	    stmt.setString(3, produktua.getMarka());
    	    stmt.setString(4, produktua.getModeloa());
    	    stmt.setInt(5, produktua.getStock());
    	    stmt.setDouble(6, produktua.getPrezioa());
    	    stmt.setInt(7, produktua.getHornitzaileaId());

    	    stmt.executeUpdate();
    	}
    }

    public void eguneratuProduktua(Produktua produktua) throws SQLException {
    	String query = "UPDATE produktua SET izena=?, mota=?, marka=?, modeloa=?, stock=?, prezioa=?, Hornitzailea_idHornitzailea=? WHERE idProduktua=?";

    	try (PreparedStatement stmt = konexioa.prepareStatement(query)) {
    	    stmt.setString(1, produktua.getIzena());
    	    stmt.setString(2, produktua.getMota());
    	    stmt.setString(3, produktua.getMarka());
    	    stmt.setString(4, produktua.getModeloa());
    	    stmt.setInt(5, produktua.getStock());
    	    stmt.setDouble(6, produktua.getPrezioa());
    	    stmt.setInt(7, produktua.getHornitzaileaId());
    	    stmt.setInt(8, produktua.getIdProduktua());

    	    stmt.executeUpdate();
    	}
    }

    public void ezabatuProduktua(int idProduktua) throws SQLException {
        String query = "DELETE FROM produktua WHERE idProduktua = ?";

        try (PreparedStatement stmt = konexioa.prepareStatement(query)) {
            stmt.setInt(1, idProduktua);
            stmt.executeUpdate();
        }
    }
    
    public void close() throws SQLException {
        if (konexioa != null && !konexioa.isClosed()) {
            konexioa.close();
        }
    }
}
