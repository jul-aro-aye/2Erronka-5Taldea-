package erronka2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import erronka2.Bezeroa;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BezeroDatabase {
    
    private Connection konexioadb;

    public BezeroDatabase(Connection connection) {
        this.konexioadb = connection;
    }


	public void datuakTaulanImprimitu(JTable bezeroak) {
        List<Bezeroa> bezeroakList = bezeroakImprimatu();
        
        Vector<String> zutabeIzenak = new Vector<>();
        zutabeIzenak.add("ID");
        zutabeIzenak.add("Izena");
        zutabeIzenak.add("Erabiltzailea");
        zutabeIzenak.add("Pasahitza");
        zutabeIzenak.add("Telefonoa");
        zutabeIzenak.add("Emaila");
        zutabeIzenak.add("Jaio Urtea");

        Vector<Vector<Object>> data = new Vector<>();
        for (Bezeroa bezeroa : bezeroakList) {
            Vector<Object> row = new Vector<>();
            row.add(bezeroa.getIdBezeroa());
            row.add(bezeroa.getIzenAbizenak());
            row.add(bezeroa.getErabiltzailea());
            row.add(bezeroa.getPasahitza());
            row.add(bezeroa.getTelefonoa());
            row.add(bezeroa.getEmaila());
            row.add(bezeroa.getJaioUrtea());
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, zutabeIzenak);
        bezeroak.setModel(model);
    }

    private List<Bezeroa> bezeroakImprimatu() {
        List<Bezeroa> bezeroakList = new ArrayList<>();
        String query = "SELECT idBezeroa, izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila, jaio_urtea FROM erronka2.bezeroa";
        
        try (Statement stmt = konexioadb.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int idBezeroa = rs.getInt("idBezeroa");
                String izenAbizenak = rs.getString("izenAbizenak");
                String erabiltzailea = rs.getString("erabiltzailea");
                String pasahitza = rs.getString("pasahitza");
                String telefonoa = rs.getString("telefonoa");
                String emaila = rs.getString("emaila");
                String jaioUrtea = rs.getString("jaio_urtea");
                
                Bezeroa bezeroa = new Bezeroa(idBezeroa, izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila, jaioUrtea);
                bezeroakList.add(bezeroa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bezeroakList;
    }

    public void bezeroaEzabatu(int idBezeroa) {
        String query = "DELETE FROM bezeroa WHERE idBezeroa = ?";
        
        try (PreparedStatement pst = konexioadb.prepareStatement(query)) {
            pst.setInt(1, idBezeroa);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void bezeroaEguneratu(int idBezeroa, String izenAbizenak, String erabiltzailea, String pasahitza,
			String telefonoa, String emaila, String jaiotzeData) {
		String query = "UPDATE bezeroa SET izenAbizenak = ?, erabiltzailea = ?, pasahitza = ?, telefonoa = ?, emaila = ?, jaio_urtea = ? WHERE idBezeroa = ?";
		
		try (PreparedStatement pst = konexioadb.prepareStatement(query)) {
            pst.setString(1, izenAbizenak);
            pst.setString(2, erabiltzailea);
            pst.setString(3, pasahitza);
            pst.setString(4, telefonoa);
            pst.setString(5, emaila);
            pst.setString(6, jaiotzeData);
            pst.setInt(7, idBezeroa);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
