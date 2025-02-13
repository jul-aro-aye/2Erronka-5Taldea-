package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SaioaHasi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField erabilTxt;
	private JPasswordField pasahitzKutxa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaioaHasi frame = new SaioaHasi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaioaHasi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logoa = new JLabel("New label");
		logoa.setIcon(new ImageIcon("C:\\Users\\Mirari\\Downloads\\Logoa_EkoTekno (1).jpg"));
		logoa.setBounds(247, 17, 300, 300);
		contentPane.add(logoa);

		JLabel lblNewLabel_1 = new JLabel("Erabiltzailea:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_1.setBounds(236, 347, 70, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pasahitza:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_2.setBounds(236, 387, 70, 20);
		contentPane.add(lblNewLabel_2);

		erabilTxt = new JTextField();
		erabilTxt.setBounds(340, 355, 120, 19);
		contentPane.add(erabilTxt);
		erabilTxt.setColumns(10);

		JButton loginBotoia = new JButton("Saioa Hasi");
		loginBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
				Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
				Connection konexioadb;
				try {
					konexioadb = konexioa.getConnection();

					String erabiltzaieSaiakera = erabilTxt.getText();
					char[] pasahitzaSaiakera = pasahitzKutxa.getPassword();
					String azkenPasahitza = new String(pasahitzaSaiakera);

					String kontsultaErab = "SELECT erabiltzailea, pasahitza, mota FROM erronka2.langilea WHERE erabiltzailea = ? AND pasahitza = ?";

					try (PreparedStatement ps = konexioadb.prepareStatement(kontsultaErab)) {
						ps.setString(1, erabiltzaieSaiakera);
						ps.setString(2, azkenPasahitza);

						try (ResultSet emaitza = ps.executeQuery()) {
							if (emaitza.next()) {
								String erabiltzaileaDB = emaitza.getString("erabiltzailea");
								String pasahitzaDB = emaitza.getString("pasahitza");
								String motaDb = emaitza.getString("mota");

								if (erabiltzaieSaiakera.equals(erabiltzaileaDB) && azkenPasahitza.equals(pasahitzaDB)) {
									if (motaDb.equals("A")) {
										dispose();
										TaulakAdm t = new TaulakAdm();
										t.setVisible(true);

									} else if (motaDb.equals("K")) {
										dispose();
										TaulakKud t = new TaulakKud();
										t.setVisible(true);
									} else if (motaDb.equals("L")) {
										dispose();
										ProduktuLan t = new ProduktuLan();
										t.setVisible(true);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Erabiltzaile eta pasahitz okerrak", "Arazoak",
											JOptionPane.INFORMATION_MESSAGE);
								}
							}

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		loginBotoia.setBounds(350, 442, 100, 21);
		contentPane.add(loginBotoia);

		pasahitzKutxa = new JPasswordField();
		pasahitzKutxa.setBounds(340, 390, 120, 20);
		contentPane.add(pasahitzKutxa);

	}
}
