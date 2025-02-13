package erronka2;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;  // Importación necesaria

public class BerriaAdm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable berriak;
    private JTextField txtBerriIzenburua, txtTextua, txtData;
    private JComboBox<String> txtLangilea;
    private BerriDatabase berriaKonexioa;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BerriaAdm frame = new BerriaAdm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BerriaAdm() {
        berriaKonexioa = new BerriDatabase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel orriIzenburua = new JLabel("Berriak");
        orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
        orriIzenburua.setBounds(40, 5, 120, 30);
        contentPane.add(orriIzenburua);

        berriak = new JTable();
        JScrollPane scrollPane = new JScrollPane(berriak);
        scrollPane.setBounds(115, 219, 650, 281);
        contentPane.add(scrollPane);

        sortuFormularioa();
        kargatuLangileak();
        kargatuBerriak();
        sortuBotoiak();
        erregistroaErakutsi();
    }

    private void sortuFormularioa() {
        JLabel izenLabel = new JLabel("Izena");
        izenLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        izenLabel.setBounds(40, 40, 80, 20);
        contentPane.add(izenLabel);

        txtBerriIzenburua = new JTextField();
        txtBerriIzenburua.setBounds(155, 40, 120, 20);
        contentPane.add(txtBerriIzenburua);

        JLabel testuaLabel = new JLabel("Testua");
        testuaLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        testuaLabel.setBounds(40, 75, 80, 20);
        contentPane.add(testuaLabel);

        txtTextua = new JTextField();
        txtTextua.setBounds(155, 75, 120, 20);
        contentPane.add(txtTextua);

        JLabel dataLabel = new JLabel("Data");
        dataLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        dataLabel.setBounds(40, 110, 80, 20);
        contentPane.add(dataLabel);

        txtData = new JTextField();
        txtData.setBounds(155, 110, 120, 20);
        contentPane.add(txtData);

        JLabel langileaLabel = new JLabel("Sortzailea");
        langileaLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
        langileaLabel.setBounds(40, 145, 80, 20);
        contentPane.add(langileaLabel);

        txtLangilea = new JComboBox<>();
        txtLangilea.setBounds(155, 145, 120, 20);
        txtLangilea.addItem("Aukeratu");
        contentPane.add(txtLangilea);
    }

    private void kargatuLangileak() {
        List<String> langileak = berriaKonexioa.lortuLangileak();
        for (String langilea : langileak) {
            txtLangilea.addItem(langilea);
        }
    }

    private void kargatuBerriak() {
        List<Berria> berriakLista = berriaKonexioa.lortuBerriak();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"ID", "Izenburua", "Testua", "Data", "Langilea"});

        for (Berria berria : berriakLista) {
            model.addRow(new Object[] {
                berria.getIdBerria(), berria.getIzenburua(), berria.getTestua(), berria.getData(), berria.getLangilea()
            });
        }

        berriak.setModel(model);
        berriak.getColumnModel().getColumn(0).setMinWidth(0);
        berriak.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void sortuBotoiak() {
        JButton gehituBotoia = new JButton("Gehitu");
        gehituBotoia.setBounds(620, 40, 100, 20);
        gehituBotoia.addActionListener(e -> gehituBerria());
        contentPane.add(gehituBotoia);

        JButton eguneratuBotoia = new JButton("Eguneratu");
        eguneratuBotoia.setBackground(new Color(255, 255, 128));
        eguneratuBotoia.setBounds(620, 70, 100, 20);
        eguneratuBotoia.addActionListener(e -> eguneratuBerria());
        contentPane.add(eguneratuBotoia);

        JButton ezabatuBotoia = new JButton("Ezabatu");
        ezabatuBotoia.setBackground(new Color(255, 128, 128));
        ezabatuBotoia.setBounds(620, 100, 100, 20);
        ezabatuBotoia.addActionListener(e -> ezabatuBerria());
        contentPane.add(ezabatuBotoia);
    }

    private void gehituBerria() {
        Berria berria = new Berria(
            0,
            txtBerriIzenburua.getText(),
            txtTextua.getText(),
            txtData.getText(),
            (String) txtLangilea.getSelectedItem()
        );

        if (berriaKonexioa.gehituBerria(berria)) {
            JOptionPane.showMessageDialog(null, "Berria ongi gehituta.");
            kargatuBerriak();
        } else {
            JOptionPane.showMessageDialog(null, "Errorea berria gehitzean.");
        }
    }

    private void eguneratuBerria() {
        int selectedRow = berriak.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Hautatu berria bat eguneratzeko.");
            return;
        }

        int idBerria = (int) berriak.getValueAt(selectedRow, 0);
        Berria berria = new Berria(
            idBerria,
            txtBerriIzenburua.getText(),
            txtTextua.getText(),
            txtData.getText(),
            (String) txtLangilea.getSelectedItem()
        );

        if (berriaKonexioa.eguneratuBerria(berria)) {
            JOptionPane.showMessageDialog(null, "Berria ongi eguneratuta.");
            kargatuBerriak();
        } else {
            JOptionPane.showMessageDialog(null, "Errorea berria eguneratzean.");
        }
    }

    private void ezabatuBerria() {
        int selectedRow = berriak.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Hautatu berria bat ezabatzeko.");
            return;
        }

        int idBerria = (int) berriak.getValueAt(selectedRow, 0);

        if (berriaKonexioa.ezabatuBerria(idBerria)) {
            JOptionPane.showMessageDialog(null, "Berria ongi ezabatuta.");
            kargatuBerriak();
        } else {
            JOptionPane.showMessageDialog(null, "Errorea berria ezabatzean.");
        }
    }

    private void erregistroaErakutsi() {
        berriak.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && berriak.getSelectedRow() != -1) {
                    int selectedRow = berriak.getSelectedRow();
                    txtBerriIzenburua.setText(berriak.getValueAt(selectedRow, 1).toString());
                    txtTextua.setText(berriak.getValueAt(selectedRow, 2).toString());
                    txtData.setText(berriak.getValueAt(selectedRow, 3).toString());
                    txtLangilea.setSelectedItem(berriak.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
}
