package erronka2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import erronka2.HornitzaileDatabase;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class HornitzaileKud extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable hornitzaileak;
    private JTextField txtHornitzaileIzena;
    private JTextField txtHornitzaileKokapena;
    private JTextField txtBanatzaileKop;
    private JTextField txtTelefonoa;
    private JTextField txtEmaila;
    private JComboBox<String> txtEgoera;
    private JButton eguneratuBotoia;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HornitzaileAdm frame = new HornitzaileAdm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HornitzaileKud() {
//        Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
    	Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");

        try (Connection konexioadb = konexioa.getConnection()) {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 950, 550);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            initializeUIComponents(konexioadb);
            loadHornitzaileakData(konexioadb);
            setupEventListeners(konexioadb);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeUIComponents(Connection konexioadb) {
        JLabel orriIzenburua = new JLabel("Hornitzaileak");
        orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
        orriIzenburua.setBounds(40, 5, 120, 30);
        contentPane.add(orriIzenburua);

        hornitzaileak = new JTable();
        JScrollPane scrollPane = new JScrollPane(hornitzaileak);
        scrollPane.setBounds(115, 150, 650, 350);
        contentPane.add(scrollPane);

        setupLabels();
        setupTextFields();
        setupComboBox(konexioadb);
        setupButtons();
    }

    private void setupLabels() {
        String[] labels = {"Izena", "Kokapena", "Banaitzaile Kopurua", "Telefonoa", "Emaila", "Egoera"};
        int[] xPos = {40, 40, 40, 300, 300, 300};
        int[] yPos = {40, 75, 110, 40, 75, 110};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Agency FB", Font.BOLD, 15));
            label.setBounds(xPos[i], yPos[i], 150, 20);
            contentPane.add(label);
        }
    }

    private void setupTextFields() {
        txtHornitzaileIzena = new JTextField();
        txtHornitzaileKokapena = new JTextField();
        txtBanatzaileKop = new JTextField();
        txtTelefonoa = new JTextField();
        txtEmaila = new JTextField();

        JTextField[] fields = {txtHornitzaileIzena, txtHornitzaileKokapena, txtBanatzaileKop, txtTelefonoa, txtEmaila};
        int[] xPos = {155, 155, 155, 390, 390};
        int[] yPos = {40, 75, 110, 40, 75};

        for (int i = 0; i < fields.length; i++) {
            fields[i].setBounds(xPos[i], yPos[i], 120, 20);
            fields[i].setColumns(10);
            contentPane.add(fields[i]);
        }
    }

    private void setupComboBox(Connection konexioadb) {
        txtEgoera = new JComboBox<>();
        txtEgoera.setBounds(390, 110, 120, 20);
        contentPane.add(txtEgoera);
        txtEgoera.addItem("Aukeratu");

        String motaGuztiak = "SELECT DISTINCT egoera from hornitzailea";

        try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(motaGuztiak)) {
            while (rs.next()) {
                String taulaIzena = rs.getString(1);
                txtEgoera.addItem(taulaIzena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupButtons() {
        eguneratuBotoia = new JButton("Eguneratu");
        eguneratuBotoia.setBackground(new Color(255, 255, 128));
        eguneratuBotoia.setFont(new Font("Agency FB", Font.BOLD, 15));
        eguneratuBotoia.setBounds(620, 60, 100, 20);
        contentPane.add(eguneratuBotoia);

    }

    private void loadHornitzaileakData(Connection konexioadb) {
        String hornitzaileGuztiak = "SELECT idHornitzailea, enpresaIzena, kokapena, banatzaileKop, telefonoa, emaila, egoera FROM erronka2.hornitzailea;";

        try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(hornitzaileGuztiak)) {

            Vector<String> columns = new Vector<>();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columns.add(metaData.getColumnLabel(i));
            }

            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }

            hornitzaileak.setModel(new DefaultTableModel(data, columns));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupEventListeners(Connection konexioadb) {
        hornitzaileak.getSelectionModel().addListSelectionListener(e -> fillFieldsFromSelectedRow());

        eguneratuBotoia.addActionListener(e -> {
            int row = hornitzaileak.getSelectedRow();
            if (row != -1) {
                int idHornitzailea = (int) hornitzaileak.getValueAt(row, 0);
                try {
					HornitzaileDatabase.updateHornitzailea(
					    konexioadb,
					    idHornitzailea,
					    txtHornitzaileIzena.getText(),
					    txtHornitzaileKokapena.getText(),
					    Integer.parseInt(txtBanatzaileKop.getText()),
					    txtTelefonoa.getText(),
					    txtEmaila.getText(),
					    txtEgoera.getSelectedItem().toString()
					);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                loadHornitzaileakData(konexioadb);
            }
        });
    }

    private void fillFieldsFromSelectedRow() {
        int row = hornitzaileak.getSelectedRow();
        if (row != -1) {
            txtHornitzaileIzena.setText(hornitzaileak.getValueAt(row, 1).toString());
            txtHornitzaileKokapena.setText(hornitzaileak.getValueAt(row, 2).toString());
            txtBanatzaileKop.setText(hornitzaileak.getValueAt(row, 3).toString());
            txtTelefonoa.setText(hornitzaileak.getValueAt(row, 4).toString());
            txtEmaila.setText(hornitzaileak.getValueAt(row, 5).toString());

            String egoera = hornitzaileak.getValueAt(row, 6).toString().trim().toLowerCase();
            for (int i = 0; i < txtEgoera.getItemCount(); i++) {
                if (txtEgoera.getItemAt(i).toString().trim().toLowerCase().equals(egoera)) {
                    txtEgoera.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
}
