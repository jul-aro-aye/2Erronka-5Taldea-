package erronka2;
import java.sql.*;
import java.util.*;

public class GarraioaDatabase {

    private Connection connection;

    public GarraioaDatabase(Connection connection) {
        this.connection = connection;
    }
    
    public GarraioaDatabase(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public List<Garraioa> garraioGuztiak() throws SQLException {
        List<Garraioa> garraioak = new ArrayList<>();
        String query = "SELECT idGarraioa, enpresaIzena, telefonoa, emaila FROM garraioa";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("idGarraioa");
                String izena = rs.getString("enpresaIzena");
                String telefonoa = rs.getString("telefonoa");
                String emaila = rs.getString("emaila");
                garraioak.add(new Garraioa(id, izena, telefonoa, emaila));
            }
        }
        return garraioak;
    }

    public boolean sortuGarraioa(Garraioa garraioa) throws SQLException {
        String query = "INSERT INTO garraioa (enpresaIzena, telefonoa, emaila) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, garraioa.getEnpresaIzena());
            stmt.setString(2, garraioa.getTelefonoa());
            stmt.setString(3, garraioa.getEmaila());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean egunertuDB(Garraioa garraioa) throws SQLException {
        String query = "UPDATE garraioa SET enpresaIzena = ?, telefonoa = ?, emaila = ? WHERE idGarraioa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, garraioa.getEnpresaIzena());
            stmt.setString(2, garraioa.getTelefonoa());
            stmt.setString(3, garraioa.getEmaila());
            stmt.setInt(4, garraioa.getIdGarraioa());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean ezabatuDB(int idGarraioa) throws SQLException {
        String query = "DELETE FROM garraioa WHERE idGarraioa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idGarraioa);
            return stmt.executeUpdate() > 0;
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
