package erronka2;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GarraioAdm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable garraioak;
    private JTextField txtGarraioIzena, txtTelefonoa, txtEmaila;
    private GarraioaDatabase db;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GarraioAdm frame = new GarraioAdm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GarraioAdm() {
        try {
//            Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//					"1MG3EkoTekno@");
//            Connection conexion = konexioa.getConnection();
//            db = new GarraioaDatabase(conexion);
        	
        	Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
            Connection conexion = konexioa.getConnection();
            db = new GarraioaDatabase(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel orriIzenburua = new JLabel("Garraioak");
        orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
        orriIzenburua.setBounds(40, 5, 120, 30);
        contentPane.add(orriIzenburua);

        garraioak = new JTable();
        JScrollPane scrollPane = new JScrollPane(garraioak);
        scrollPane.setBounds(115, 219, 650, 281);
        contentPane.add(scrollPane);

        sortuFormularioa();
        kargatuGarraioak();
        sortuBotoiak();
    }

    private void sortuFormularioa() {
        JLabel izenLabel = new JLabel("Enpresa Izena");
        izenLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        izenLabel.setBounds(40, 40, 100, 20);
        contentPane.add(izenLabel);

        txtGarraioIzena = new JTextField();
        txtGarraioIzena.setBounds(155, 40, 120, 20);
        contentPane.add(txtGarraioIzena);

        JLabel telefonoaLabel = new JLabel("Telefonoa");
        telefonoaLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        telefonoaLabel.setBounds(40, 75, 80, 20);
        contentPane.add(telefonoaLabel);

        txtTelefonoa = new JTextField();
        txtTelefonoa.setBounds(155, 75, 120, 20);
        contentPane.add(txtTelefonoa);

        JLabel emailaLabel = new JLabel("Emaila");
        emailaLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        emailaLabel.setBounds(40, 110, 80, 20);
        contentPane.add(emailaLabel);

        txtEmaila = new JTextField();
        txtEmaila.setBounds(155, 110, 120, 20);
        contentPane.add(txtEmaila);
    }

    private void kargatuGarraioak() {
        try {
            List<Garraioa> garraioakList = db.garraioGuztiak();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[] {"ID", "Izena", "Telefonoa", "Emaila"});

            for (Garraioa garraioa : garraioakList) {
                model.addRow(new Object[] {
                    garraioa.getIdGarraioa(), garraioa.getEnpresaIzena(), garraioa.getTelefonoa(), garraioa.getEmaila()
                });
            }

            garraioak.setModel(model);
            garraioak.getColumnModel().getColumn(0).setMinWidth(0);
            garraioak.getColumnModel().getColumn(0).setMaxWidth(0);
            garraioak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            garraioak.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting() && garraioak.getSelectedRow() != -1) {
                    int selectedRow = garraioak.getSelectedRow();
                    txtGarraioIzena.setText(garraioak.getValueAt(selectedRow, 1).toString());
                    txtTelefonoa.setText(garraioak.getValueAt(selectedRow, 2).toString());
                    txtEmaila.setText(garraioak.getValueAt(selectedRow, 3).toString());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sortuBotoiak() {
        JButton gehituBotoia = new JButton("Gehitu");
        gehituBotoia.setBounds(620, 40, 100, 20);
        gehituBotoia.addActionListener(e -> gehituGarraioa());
        contentPane.add(gehituBotoia);

        JButton eguneratuBotoia = new JButton("Eguneratu");
        eguneratuBotoia.setBackground(new Color(255, 255, 128));
        eguneratuBotoia.setBounds(620, 70, 100, 20);
        eguneratuBotoia.addActionListener(e -> eguneratuGarraioa());
        contentPane.add(eguneratuBotoia);

        JButton ezabatuBotoia = new JButton("Ezabatu");
        ezabatuBotoia.setBackground(new Color(255, 128, 128));
        ezabatuBotoia.setBounds(620, 100, 100, 20);
        ezabatuBotoia.addActionListener(e -> ezabatuGarraioa());
        contentPane.add(ezabatuBotoia);
    }

    private void gehituGarraioa() {
        try {
            Garraioa garraioa = new Garraioa(0, txtGarraioIzena.getText(), txtTelefonoa.getText(), txtEmaila.getText());
            if (db.sortuGarraioa(garraioa)) {
                JOptionPane.showMessageDialog(this, "Garraioa ondo txertatu da.");
                kargatuGarraioak();
            } else {
                JOptionPane.showMessageDialog(this, "Errorea garraioa txertatzean.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eguneratuGarraioa() {
        int selectedRow = garraioak.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = (int) garraioak.getValueAt(selectedRow, 0);
                Garraioa garraioa = new Garraioa(id, txtGarraioIzena.getText(), txtTelefonoa.getText(), txtEmaila.getText());
                if (db.egunertuDB(garraioa)) {
                    JOptionPane.showMessageDialog(this, "Garraioa ondo eguneratu da.");
                    kargatuGarraioak();
                } else {
                    JOptionPane.showMessageDialog(this, "Errorea garraioa eguneratzean.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hautatu lerro bat eguneratzeko.");
        }
    }

    private void ezabatuGarraioa() {
        int selectedRow = garraioak.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = (int) garraioak.getValueAt(selectedRow, 0);
                if (db.ezabatuDB(id)) {
                    JOptionPane.showMessageDialog(this, "Garraioa ondo ezabatu da.");
                    kargatuGarraioak();
                } else {
                    JOptionPane.showMessageDialog(this, "Errorea garraioa ezabatzean.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hautatu lerro bat ezabatzeko.");
        }
    }

    @Override
    public void dispose() {
        try {
            if (db != null) {
                db.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.dispose();
    }
}
