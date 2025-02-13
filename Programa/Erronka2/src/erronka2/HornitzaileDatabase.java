package erronka2;

import java.sql.*;
import java.util.*;

public class HornitzaileDatabase {

    private Connection connection;

    public HornitzaileDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<Hornitzailea> HornitzaileGuztiak() throws SQLException {
        List<Hornitzailea> hornitzaileak = new ArrayList<>();
        String query = "SELECT idHornitzailea, enpresaIzena, kokapena, banatzaileKop, telefonoa, emaila, egoera FROM hornitzailea";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("idHornitzailea");
                String izena = rs.getString("enpresaIzena");
                String kokapena = rs.getString("kokapena");
                int banatzaileKop = rs.getInt("banatzaileKop");
                String telefonoa = rs.getString("telefonoa");
                String emaila = rs.getString("emaila");
                String egoera = rs.getString("egoera");
                
                hornitzaileak.add(new Hornitzailea(id, izena, kokapena, banatzaileKop, telefonoa, emaila, egoera));
            }
        }
        return hornitzaileak;
    }

    public boolean insertHornitzailea(Hornitzailea hornitzailea) throws SQLException {
        String query = "INSERT INTO hornitzailea (enpresaIzena, kokapena, banatzaileKop, telefonoa, emaila, egoera) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, hornitzailea.getEnpresaIzena());
            stmt.setString(2, hornitzailea.getKokapena());
            stmt.setInt(3, hornitzailea.getBanatzaileKop());
            stmt.setString(4, hornitzailea.getTelefonoa());
            stmt.setString(5, hornitzailea.getEmaila());
            stmt.setString(6, hornitzailea.getEgoera());
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteHornitzailea(Hornitzailea hornitzailea) throws SQLException {
        String query = "DELETE FROM hornitzailea WHERE idHornitzailea = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, hornitzailea.getIdHornitzailea());
            return stmt.executeUpdate() > 0;
        }
    }

    public static void updateHornitzailea(Connection konexioadb, int idHornitzailea, String izena, String kokapena, int banatzaileKop, String telefonoa, String emaila, String egoera) throws SQLException {
        String query = "UPDATE hornitzailea SET enpresaIzena = ?, kokapena = ?, banatzaileKop = ?, telefonoa = ?, emaila = ?, egoera = ? WHERE idHornitzailea = ?";

        try (PreparedStatement stmt = konexioadb.prepareStatement(query)) {
            stmt.setString(1, izena);
            stmt.setString(2, kokapena);
            stmt.setInt(3, banatzaileKop);
            stmt.setString(4, telefonoa);
            stmt.setString(5, emaila);
            stmt.setString(6, egoera);
            stmt.setInt(7, idHornitzailea);

            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
