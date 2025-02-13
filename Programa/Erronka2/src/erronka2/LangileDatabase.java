package erronka2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane; // Importación para las alertas

public class LangileDatabase {

    private Konexioa konexioa;

    public LangileDatabase(Konexioa konexioa) {
        this.konexioa = konexioa;
    }

    private boolean erabiltzaileaKonprobatu(String erabiltzailea) {
        String regex = "^[a-zA-Z]{3}_[a-zA-Z]{3}_[a-zA-Z]{3}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(erabiltzailea).matches();
    }

    public boolean addLangile(Langilea lang) {
        if (!erabiltzaileaKonprobatu(lang.getErabiltzailea())) {
            JOptionPane.showMessageDialog(null, "Error: El 'erabiltzailea' no cumple con el formato requerido.",
                    "Error de formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO langilea (izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila, mota) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = konexioa.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lang.getIzenAbizenak());
            stmt.setString(2, lang.getErabiltzailea());
            stmt.setString(3, lang.getPasahitza());
            stmt.setString(4, lang.getTelefonoa());
            stmt.setString(5, lang.getEmaila());
            stmt.setString(6, lang.getMota());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateLangile(Langilea lang) {
        if (!erabiltzaileaKonprobatu(lang.getErabiltzailea())) {
            JOptionPane.showMessageDialog(null, "Error: Erabiltzaileak ez du beharreko egitura errespetatzen.",
                    "Error de formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String sql = "UPDATE langilea SET izenAbizenak = ?, erabiltzailea = ?, pasahitza = ?, telefonoa = ?, emaila = ?, mota = ? WHERE idLangilea = ?";
        try (Connection conn = konexioa.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lang.getIzenAbizenak());
            stmt.setString(2, lang.getErabiltzailea());
            stmt.setString(3, lang.getPasahitza());
            stmt.setString(4, lang.getTelefonoa());
            stmt.setString(5, lang.getEmaila());
            stmt.setString(6, lang.getMota());
            stmt.setInt(7, lang.getIdLangilea());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteLangile(int idLangilea) {
        String sql = "DELETE FROM langilea WHERE idLangilea = ?";
        try (Connection conn = konexioa.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLangilea);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Langilea> getAllLangileak() {
        List<Langilea> langileak = new ArrayList<>();
        String sql = "SELECT * FROM langilea";
        try (Connection conn = konexioa.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Langilea lang = new Langilea(rs.getInt("idLangilea"), rs.getString("izenAbizenak"),
                        rs.getString("erabiltzailea"), rs.getString("pasahitza"), rs.getString("telefonoa"),
                        rs.getString("emaila"), rs.getString("mota"));
                langileak.add(lang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return langileak;
    }

    public List<String> MotaAukeraGuztiak() {
        List<String> options = new ArrayList<>();
        String query = "SELECT DISTINCT mota FROM langilea";

        try (Connection conn = konexioa.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                options.add(rs.getString("mota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return options;
    }

    public void close() {
        try {
            if (konexioa != null && konexioa.getConnection() != null && !konexioa.getConnection().isClosed()) {
                konexioa.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
