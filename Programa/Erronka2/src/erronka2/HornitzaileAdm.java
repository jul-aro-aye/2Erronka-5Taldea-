package erronka2;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class HornitzaileAdm extends JFrame {

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
    private JButton ezabatuBotoia;

    private Connection konexioadb;
    private HornitzaileDatabase hornitzaileDatabase;

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

    public HornitzaileAdm() {
    
//        Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");

    	Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
    	
        try {
            konexioadb = konexioa.getConnection();
            hornitzaileDatabase = new HornitzaileDatabase(konexioadb);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 950, 550);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            edukiaErakutsi();
            HornitzaileDatuakErakutsi();
            ListenerakKargatu();

            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    try {
                        if (konexioadb != null && !konexioadb.isClosed()) {
                            konexioadb.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void edukiaErakutsi() {
        JLabel orriIzenburua = new JLabel("Hornitzaileak");
        orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
        orriIzenburua.setBounds(40, 5, 120, 30);
        contentPane.add(orriIzenburua);

        hornitzaileak = new JTable();
        JScrollPane scrollPane = new JScrollPane(hornitzaileak);
        scrollPane.setBounds(115, 150, 650, 350);
        contentPane.add(scrollPane);
        
        eguneratuBotoia = new JButton("Eguneratu");
        eguneratuBotoia.setBackground(new Color(255, 255, 128));
        eguneratuBotoia.setBounds(550, 110, 120, 25);
        contentPane.add(eguneratuBotoia);
        
        ezabatuBotoia = new JButton("Ezabatu");
        ezabatuBotoia.setBackground(new Color(255, 128, 128));
        ezabatuBotoia.setBounds(700, 110, 110, 25);
        contentPane.add(ezabatuBotoia);
        
        txtHornitzaileIzena = new JTextField();
        txtHornitzaileIzena.setBounds(40, 50, 150, 25);
        contentPane.add(txtHornitzaileIzena);

        txtHornitzaileKokapena = new JTextField();
        txtHornitzaileKokapena.setBounds(220, 50, 150, 25);
        contentPane.add(txtHornitzaileKokapena);

        txtBanatzaileKop = new JTextField();
        txtBanatzaileKop.setBounds(400, 50, 50, 25);
        contentPane.add(txtBanatzaileKop);

        txtTelefonoa = new JTextField();
        txtTelefonoa.setBounds(470, 50, 120, 25);
        contentPane.add(txtTelefonoa);

        txtEmaila = new JTextField();
        txtEmaila.setBounds(610, 50, 150, 25);
        contentPane.add(txtEmaila);

        KomboBoxSortu();
    }

    private void KomboBoxSortu() {
        txtEgoera = new JComboBox<>();
        txtEgoera.setBounds(390, 110, 120, 20);
        contentPane.add(txtEgoera);
        
        txtEgoera.addItem("Aukeratu");

        String egoeraGuztiak = "SELECT DISTINCT egoera FROM hornitzailea";

        try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(egoeraGuztiak)) {
            while (rs.next()) {
                txtEgoera.addItem(rs.getString("egoera"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void HornitzaileDatuakErakutsi() {
        try {

            List<Hornitzailea> hornitzaileakList = hornitzaileDatabase.HornitzaileGuztiak();
            
            Vector<String> columns = new Vector<>();
            columns.add("ID");
            columns.add("Enpresa Izena");
            columns.add("Kokapena");
            columns.add("Banatzaile Kop");
            columns.add("Telefonoa");
            columns.add("Emaila");
            columns.add("Egoera");

            Vector<Vector<Object>> data = new Vector<>();
            for (Hornitzailea hornitzailea : hornitzaileakList) {
                Vector<Object> row = new Vector<>();
                row.add(hornitzailea.getIdHornitzailea());
                row.add(hornitzailea.getEnpresaIzena());
                row.add(hornitzailea.getKokapena());
                row.add(hornitzailea.getBanatzaileKop());
                row.add(hornitzailea.getTelefonoa());
                row.add(hornitzailea.getEmaila());
                row.add(hornitzailea.getEgoera());
                data.add(row);
            }

            hornitzaileak.setModel(new DefaultTableModel(data, columns));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ListenerakKargatu() {
        hornitzaileak.getSelectionModel().addListSelectionListener(e -> AukeratutakoErregistroaKargatu());

        eguneratuBotoia.addActionListener(e -> updateHornitzailea());
        
        ezabatuBotoia.addActionListener(e -> ezabatuHornitzailea());
        
    }
    
    private void ezabatuHornitzailea() {
    	int row = hornitzaileak.getSelectedRow();
        
        if (row != -1) {
            
            int idHornitzailea = (int) hornitzaileak.getValueAt(row, 0);

            Hornitzailea hornitzailea = new Hornitzailea();
            hornitzailea.setIdHornitzailea(idHornitzailea);

            try {
                boolean result = hornitzaileDatabase.deleteHornitzailea(hornitzailea);
                if (result) {

                    JOptionPane.showMessageDialog(this, "Hornitzailea ongi ezabatu da.", 
                                                  "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    HornitzaileDatuakErakutsi();
                } else {
                	
                    JOptionPane.showMessageDialog(this, "Ezin izan da ezabatu hornitzailea.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(this, "Arazoak hornitzailea ezabatzean: " + e.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(this, "Mesedez aukeratu ezazu hornitzaile bat ezabatzeko", 
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void updateHornitzailea() {
        int row = hornitzaileak.getSelectedRow();
        if (row != -1) {
            int idHornitzailea = (int) hornitzaileak.getValueAt(row, 0);
            String izena = txtHornitzaileIzena.getText();
            String kokapena = txtHornitzaileKokapena.getText();
            int banatzaileKop = Integer.parseInt(txtBanatzaileKop.getText());
            String telefonoa = txtTelefonoa.getText();
            String emaila = txtEmaila.getText();
            String egoera = txtEgoera.getSelectedItem().toString();

            try {

                hornitzaileDatabase.updateHornitzailea(konexioadb, idHornitzailea, izena, kokapena, banatzaileKop, telefonoa, emaila, egoera);
                HornitzaileDatuakErakutsi();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void AukeratutakoErregistroaKargatu() {
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