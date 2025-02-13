package erronka2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class BezeroaAdm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable bezeroak;
	private JTextField bezeroIzenAbizenak;
	private JTextField bezeroErabiltzailea;
	private JTextField bezeroPasahitza;
	private JTextField bezeroTelefonoa;
	private JTextField bezeroEmaila;
	private JTextField bezeroJaiotzeData;
	private Konexioa konexioa;
	private BezeroDatabase bezeroDatabase;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroaAdm frame = new BezeroaAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BezeroaAdm() {
		
		konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
		
//		konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea", "1MG3EkoTekno@");

		Connection konexioBerria = null;
        try {
            konexioBerria = konexioa.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bezeroDatabase = new BezeroDatabase(konexioBerria);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bezeroak = new JTable();
		bezeroak.setBounds(115, 150, 650, 350);
		contentPane.add(bezeroak);

		bezeroDatabase.datuakTaulanImprimitu(bezeroak);

		JScrollPane scrollPane = new JScrollPane(bezeroak);
		scrollPane.setBounds(115, 150, 650, 350);
		contentPane.add(scrollPane);

		JLabel orriIzenburua = new JLabel("Bezeroak");
		orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
		orriIzenburua.setBounds(40, 5, 120, 30);
		contentPane.add(orriIzenburua);

		JLabel lblbezeroIzenAbizenak = new JLabel("Izena:");
		lblbezeroIzenAbizenak.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroIzenAbizenak.setBounds(40, 40, 80, 20);
		contentPane.add(lblbezeroIzenAbizenak);

		JLabel lblbezeroErabiltzailea = new JLabel("Erabiltzailea:");
		lblbezeroErabiltzailea.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroErabiltzailea.setBounds(40, 75, 80, 20);
		contentPane.add(lblbezeroErabiltzailea);

		JLabel lblbezeroPasahitza = new JLabel("Pasahitza:");
		lblbezeroPasahitza.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroPasahitza.setBounds(40, 110, 80, 20);
		contentPane.add(lblbezeroPasahitza);

		JLabel lblbezeroTelefonoa = new JLabel("Telefonoa:");
		lblbezeroTelefonoa.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroTelefonoa.setBounds(300, 40, 80, 20);
		contentPane.add(lblbezeroTelefonoa);

		JLabel lblbezeroEmaila = new JLabel("Emaila:");
		lblbezeroEmaila.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroEmaila.setBounds(300, 75, 80, 20);
		contentPane.add(lblbezeroEmaila);

		JLabel lblbezeroJaioUrtea = new JLabel("JaioUrtea:");
		lblbezeroJaioUrtea.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblbezeroJaioUrtea.setBounds(300, 110, 80, 20);
		contentPane.add(lblbezeroJaioUrtea);

		bezeroIzenAbizenak = new JTextField();
		bezeroIzenAbizenak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroIzenAbizenak.setBounds(155, 40, 120, 20);
		contentPane.add(bezeroIzenAbizenak);

		bezeroErabiltzailea = new JTextField();
		bezeroErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroErabiltzailea.setBounds(155, 75, 120, 20);
		contentPane.add(bezeroErabiltzailea);

		bezeroPasahitza = new JTextField();
		bezeroPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroPasahitza.setColumns(10);
		bezeroPasahitza.setBounds(155, 110, 120, 20);
		contentPane.add(bezeroPasahitza);

		bezeroTelefonoa = new JTextField();
		bezeroTelefonoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroTelefonoa.setColumns(10);
		bezeroTelefonoa.setBounds(390, 40, 120, 20);
		contentPane.add(bezeroTelefonoa);

		bezeroEmaila = new JTextField();
		bezeroEmaila.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroEmaila.setColumns(10);
		bezeroEmaila.setBounds(390, 75, 120, 20);
		contentPane.add(bezeroEmaila);

		bezeroJaiotzeData = new JTextField();
		bezeroJaiotzeData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bezeroJaiotzeData.setColumns(10);
		bezeroJaiotzeData.setBounds(390, 110, 120, 20);
		contentPane.add(bezeroJaiotzeData);

		JButton eguneratuBezeroa = new JButton("Eguneratu");
		eguneratuBezeroa.setBackground(new Color(255, 255, 128));
		eguneratuBezeroa.setBounds(700, 90, 100, 20);
		contentPane.add(eguneratuBezeroa);

		eguneratuBezeroa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = bezeroak.getSelectedRow();
				if (selectedRow != -1) {
					int idBezeroa = (int) bezeroak.getValueAt(selectedRow, 0);
					String izenAbizenak = bezeroIzenAbizenak.getText().trim();
					String erabiltzailea = bezeroErabiltzailea.getText().trim();
					String pasahitza = bezeroPasahitza.getText().trim();
					String telefonoa = bezeroTelefonoa.getText().trim();
					String emaila = bezeroEmaila.getText().trim();
					String jaiotzeData = bezeroJaiotzeData.getText().trim();

					bezeroDatabase.bezeroaEguneratu(idBezeroa, izenAbizenak, erabiltzailea, pasahitza, telefonoa,
							emaila, jaiotzeData);
					bezeroDatabase.datuakTaulanImprimitu(bezeroak);
				} else {
					JOptionPane.showMessageDialog(null, "Ez da bezeroa aukeratu.");
				}
			}
		});

		JButton ezabatuBezeroa = new JButton("Ezabatu");
		ezabatuBezeroa.setBackground(new Color(255, 128, 128));
		ezabatuBezeroa.setBounds(700, 30, 100, 20);
		contentPane.add(ezabatuBezeroa);

		ezabatuBezeroa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = bezeroak.getSelectedRow();
				if (selectedRow != -1) {
					int idBezeroa = (int) bezeroak.getValueAt(selectedRow, 0);
					bezeroDatabase.bezeroaEzabatu(idBezeroa);
					bezeroDatabase.datuakTaulanImprimitu(bezeroak);
				} else {
					JOptionPane.showMessageDialog(null, "Ez da bezeroa aukeratu.");
				}
			}
		});

		bezeroak.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = bezeroak.getSelectedRow();
					if (selectedRow != -1) {
						bezeroIzenAbizenak.setText((String) bezeroak.getValueAt(selectedRow, 1));
						bezeroErabiltzailea.setText((String) bezeroak.getValueAt(selectedRow, 2));
						bezeroPasahitza.setText((String) bezeroak.getValueAt(selectedRow, 3));
						bezeroTelefonoa.setText((String) bezeroak.getValueAt(selectedRow, 4));
						bezeroEmaila.setText((String) bezeroak.getValueAt(selectedRow, 5));
						bezeroJaiotzeData.setText((String) bezeroak.getValueAt(selectedRow, 6));
					}
				}
			}
		});
	}

}
