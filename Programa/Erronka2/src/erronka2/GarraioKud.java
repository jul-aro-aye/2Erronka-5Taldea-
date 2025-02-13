package erronka2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import erronka2.Konexioa;
import java.awt.Color;

public class GarraioKud extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable garraioak;
    private JTextField txtGarraioIzena;
    private JTextField txtTelefonoa;
    private JTextField txtEmaila;
    private JButton btnInsert;
    private JButton btnUpdate;
    private GarraioaDatabase db;

    public GarraioKud() {
        try {
//            Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//			"1MG3EkoTekno@");
            Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
            
            Connection conexion = konexioa.getConnection();
            db = new GarraioaDatabase(conexion);
            erakutsi();
            kargatuGarraioakTaula();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void erakutsi() {
        setTitle("Garraio Kudeatzailea");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 560, 150);
        contentPane.add(scrollPane);

        garraioak = new JTable();
        scrollPane.setViewportView(garraioak);
        garraioak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        garraioak.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && garraioak.getSelectedRow() != -1) {
                int selectedRow = garraioak.getSelectedRow();
                txtGarraioIzena.setText(garraioak.getValueAt(selectedRow, 1).toString());
                txtTelefonoa.setText(garraioak.getValueAt(selectedRow, 2).toString());
                txtEmaila.setText(garraioak.getValueAt(selectedRow, 3).toString());
            }
        });

        JLabel lblIzena = new JLabel("Enpresa Izena:");
        lblIzena.setBounds(10, 180, 100, 25);
        contentPane.add(lblIzena);

        txtGarraioIzena = new JTextField();
        txtGarraioIzena.setBounds(120, 180, 200, 25);
        contentPane.add(txtGarraioIzena);

        JLabel lblTelefonoa = new JLabel("Telefonoa:");
        lblTelefonoa.setBounds(10, 220, 100, 25);
        contentPane.add(lblTelefonoa);

        txtTelefonoa = new JTextField();
        txtTelefonoa.setBounds(120, 220, 200, 25);
        contentPane.add(txtTelefonoa);

        JLabel lblEmaila = new JLabel("Emaila:");
        lblEmaila.setBounds(10, 260, 100, 25);
        contentPane.add(lblEmaila);

        txtEmaila = new JTextField();
        txtEmaila.setBounds(120, 260, 200, 25);
        contentPane.add(txtEmaila);

        btnInsert = new JButton("Txertatu");
        btnInsert.setBounds(350, 180, 100, 25);
        contentPane.add(btnInsert);
        btnInsert.addActionListener(e -> gehituGarraioa());

        btnUpdate = new JButton("Eguneratu");
        btnUpdate.setBackground(new Color(255, 255, 128));
        btnUpdate.setBounds(350, 220, 100, 25);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(e -> eguneratuGarraioa());
    }

	private void kargatuGarraioakTaula() {
        try {
            List<Garraioa> garraioakList = db.garraioGuztiak();
            Vector<Vector<Object>> data = new Vector<>();
            for (Garraioa garraioa : garraioakList) {
                Vector<Object> row = new Vector<>();
                row.add(garraioa.getIdGarraioa());
                row.add(garraioa.getEnpresaIzena());
                row.add(garraioa.getTelefonoa());
                row.add(garraioa.getEmaila());
                data.add(row);
            }
            DefaultTableModel model = new DefaultTableModel(data, new Vector<>(Arrays.asList("ID", "Izena", "Telefonoa", "Emaila")));
            garraioak.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void gehituGarraioa() {
        try {
            Garraioa garraioa = new Garraioa(0, txtGarraioIzena.getText(), txtTelefonoa.getText(), txtEmaila.getText());
            if (db.sortuGarraioa(garraioa)) {
                JOptionPane.showMessageDialog(this, "Garraioa ondo txertatu da.");
                kargatuGarraioakTaula();
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
                    kargatuGarraioakTaula();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GarraioKud().setVisible(true));
    }
}
