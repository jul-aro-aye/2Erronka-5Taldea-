package erronka2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class LangileAdm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable langileak;
    private JTextField txtLangileIzenAbizenak;
    private JTextField txtLangileErabiltzailea;
    private JTextField txtLangilePasahitza;
    private JTextField txtLangileTelefonoa;
    private JTextField txtLangileEmaila;
    private JComboBox<String> txtLangileMota;
    private Konexioa konexioa;
    private LangileDatabase langileDB;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LangileAdm frame = new LangileAdm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LangileAdm() {
//    	konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
    	Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
    	
        langileDB = new LangileDatabase(konexioa);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        langileak = new JTable();
        JScrollPane scrollPane = new JScrollPane(langileak);
        scrollPane.setBounds(115, 219, 650, 281);
        contentPane.add(scrollPane);
        
        List<Langilea> langileakList = langileDB.getAllLangileak();
        TaulaKargatu(langileakList);
        
        JLabel orriIzenburua = new JLabel("Langileak");
        orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
        orriIzenburua.setBounds(40, 5, 120, 30);
        contentPane.add(orriIzenburua);

        JLabel lblLangileIzenAbizenak = new JLabel("Izena:");
        lblLangileIzenAbizenak.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangileIzenAbizenak.setBounds(40, 40, 80, 20);
        contentPane.add(lblLangileIzenAbizenak);
        
        JLabel lblLangileErabiltzailea = new JLabel("Erabiltzailea:");
        lblLangileErabiltzailea.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangileErabiltzailea.setBounds(40, 75, 80, 20);
        contentPane.add(lblLangileErabiltzailea);

        JLabel lblLangilePasahitza = new JLabel("Pasahitza:");
        lblLangilePasahitza.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangilePasahitza.setBounds(40, 110, 80, 20);
        contentPane.add(lblLangilePasahitza);

        JLabel lblLangileTelefonoa = new JLabel("Telefonoa:");
        lblLangileTelefonoa.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangileTelefonoa.setBounds(300, 40, 80, 20);
        contentPane.add(lblLangileTelefonoa);

        JLabel lblLangileEmaila = new JLabel("Emaila:");
        lblLangileEmaila.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangileEmaila.setBounds(300, 75, 80, 20);
        contentPane.add(lblLangileEmaila);

        JLabel lblLangileMota = new JLabel("Mota:");
        lblLangileMota.setFont(new Font("Agency FB", Font.BOLD, 15));
        lblLangileMota.setBounds(300, 110, 80, 20);
        contentPane.add(lblLangileMota);
        
        txtLangileIzenAbizenak = new JTextField();
        txtLangileIzenAbizenak.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangileIzenAbizenak.setBounds(155, 40, 120, 20);
        contentPane.add(txtLangileIzenAbizenak);

        txtLangileErabiltzailea = new JTextField();
        txtLangileErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangileErabiltzailea.setBounds(155, 75, 120, 20);
        contentPane.add(txtLangileErabiltzailea);

        txtLangilePasahitza = new JTextField();
        txtLangilePasahitza.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangilePasahitza.setColumns(10);
        txtLangilePasahitza.setBounds(155, 110, 120, 20);
        contentPane.add(txtLangilePasahitza);

        txtLangileTelefonoa = new JTextField();
        txtLangileTelefonoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangileTelefonoa.setColumns(10);
        txtLangileTelefonoa.setBounds(390, 40, 120, 20);
        contentPane.add(txtLangileTelefonoa);

        txtLangileEmaila = new JTextField();
        txtLangileEmaila.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangileEmaila.setColumns(10);
        txtLangileEmaila.setBounds(390, 75, 120, 20);
        contentPane.add(txtLangileEmaila);

        List<String> motaAukerak = langileDB.MotaAukeraGuztiak();
        
        txtLangileMota = new JComboBox<>();
        txtLangileMota.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLangileMota.setBounds(390, 110, 120, 20);
        contentPane.add(txtLangileMota);
        
        txtLangileMota.addItem("Aukeratu");
        
        for (String mota : motaAukerak) {
            txtLangileMota.addItem(mota);
        }
        
        JButton gehituBotoia = new JButton("Gehitu");
        gehituBotoia.setBounds(700, 60, 100, 20);
        contentPane.add(gehituBotoia);
        
        JButton eguneratuProduktua = new JButton("Eguneratu");
        eguneratuProduktua.setBackground(new Color(255, 255, 128));
        eguneratuProduktua.setBounds(700, 90, 100, 20);
        contentPane.add(eguneratuProduktua);
        
        JButton ezabatuProduktua = new JButton("Ezabatu");
        ezabatuProduktua.setBackground(new Color(255, 128, 128));
        ezabatuProduktua.setBounds(700, 30, 100, 20);
        contentPane.add(ezabatuProduktua);
        
        langileak.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    AukeratutakoErregistroaErakutsi();
                }
            }
        });
        
        ezabatuProduktua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = langileak.getSelectedRow();
                
                if (selectedRow != -1) {

                    int idLangilea = (int) langileak.getValueAt(selectedRow, 0);
                    
                    boolean success = langileDB.deleteLangile(idLangilea);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Langilea ongi ezabatuta.");
                        
                        TaulaKargatu(langileDB.getAllLangileak());
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore bat gertatu da langilea ezabatzean.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aukeratu langile bat ezabatzeko.");
                }
            }
        });
        
        eguneratuProduktua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = langileak.getSelectedRow();

                if (selectedRow != -1) {

                    int idLangilea = (int) langileak.getValueAt(selectedRow, 0);

                    String izenAbizenak = txtLangileIzenAbizenak.getText().trim();
                    String erabiltzailea = txtLangileErabiltzailea.getText().trim();
                    String pasahitza = txtLangilePasahitza.getText().trim();
                    String telefonoa = txtLangileTelefonoa.getText().trim();
                    String emaila = txtLangileEmaila.getText().trim();
                    String mota = txtLangileMota.getSelectedItem().toString();

                    if (izenAbizenak.isEmpty() || erabiltzailea.isEmpty() || pasahitza.isEmpty() || telefonoa.isEmpty()
                            || mota.equals("Aukeratu")) {
                        JOptionPane.showMessageDialog(null, "Ezin dituzu erregistroak hutsik bidali.");
                        return;
                    }

                    Langilea updatedLangilea = new Langilea(idLangilea, izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila, mota);

                    boolean success = langileDB.updateLangile(updatedLangilea);
                    
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Langilea ongi eguneratuta.");

                        TaulaKargatu(langileDB.getAllLangileak());
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore bat gertatu da langilea eguneratzean.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aukeratu langile bat eguneratzeko.");
                }
            }
        });

        gehituBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String izenAbizenak = txtLangileIzenAbizenak.getText().trim();
                String erabiltzailea = txtLangileErabiltzailea.getText().trim();
                String pasahitza = txtLangilePasahitza.getText().trim();
                String telefonoa = txtLangileTelefonoa.getText().trim();
                String emaila = txtLangileEmaila.getText().trim();
                String mota = txtLangileMota.getSelectedItem().toString();

                if (izenAbizenak.isEmpty() || mota.isEmpty() || pasahitza.isEmpty() || telefonoa.isEmpty()
                        || erabiltzailea.equals("Aukeratu")) {
                    JOptionPane.showMessageDialog(null, "Ezin dituzu erregistroak hutsik bidali.");
                    return;
                }

                Langilea lang = new Langilea(0, izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila, mota);
                boolean success = langileDB.addLangile(lang);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Langilea ongi sortuta.");
                    TaulaKargatu(langileDB.getAllLangileak());
                } else {
                    JOptionPane.showMessageDialog(null, "Errore bat gertatu da langilea sortzean.");
                }
            }
        });

    }

    private void TaulaKargatu(List<Langilea> langileakList) {
        String[] Zutabeak = {"ID", "Izen Abizenak", "Erabiltzailea", "Pasahitza", "Telefonoa", "Emaila", "Mota"};
        DefaultTableModel model = new DefaultTableModel(Zutabeak, 0);
        for (Langilea lang : langileakList) {
            Object[] row = {lang.getIdLangilea(), lang.getIzenAbizenak(), lang.getErabiltzailea(),
                    lang.getPasahitza(), lang.getTelefonoa(), lang.getEmaila(), lang.getMota()};
            model.addRow(row);
        }
        langileak.setModel(model);
    }

    @Override
    public void dispose() {
        langileDB.close();
        super.dispose();
    }

    private void AukeratutakoErregistroaErakutsi() {
        int row = langileak.getSelectedRow();
        if (row != -1) {
        	txtLangileIzenAbizenak.setText(langileak.getValueAt(row, 1).toString());
        	txtLangileErabiltzailea.setText(langileak.getValueAt(row, 2).toString());
        	txtLangilePasahitza.setText(langileak.getValueAt(row, 3).toString());
        	txtLangileTelefonoa.setText(langileak.getValueAt(row, 4).toString());
        	txtLangileEmaila.setText(langileak.getValueAt(row, 5).toString());

            String egoera = langileak.getValueAt(row, 6).toString().trim().toLowerCase();
            for (int i = 0; i < txtLangileMota.getItemCount(); i++) {
                if (txtLangileMota.getItemAt(i).toString().trim().toLowerCase().equals(egoera)) {
                	txtLangileMota.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
}
