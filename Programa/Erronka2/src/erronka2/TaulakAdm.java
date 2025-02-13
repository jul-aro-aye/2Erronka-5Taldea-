package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaulakAdm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaulakAdm frame = new TaulakAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TaulakAdm() {
		
		Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");

//		Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
		Connection konexioadb;

		try {
			konexioadb = konexioa.getConnection();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 950, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel taulaAukeraAdm = new JLabel("Nora joan nahiko zenuke?");
			taulaAukeraAdm.setFont(new Font("Agency FB", Font.BOLD, 15));
			taulaAukeraAdm.setBounds(170, 180, 150, 20);
			contentPane.add(taulaAukeraAdm);

			JComboBox<String> taulaAukerak = new JComboBox<>();
			taulaAukerak.setFont(new Font("Agency FB", Font.BOLD, 15));
			taulaAukerak.setBounds(400, 180, 120, 20);
			contentPane.add(taulaAukerak);

			taulaAukerak.addItem("Aukeratu");

			String taulaGuztiak = "SHOW TABLES";

			try (Statement taulaGuztiakEmaitzak = konexioadb.createStatement();
					ResultSet rs2 = taulaGuztiakEmaitzak.executeQuery(taulaGuztiak)) {

				while (rs2.next()) {
					String taulaIzena = rs2.getString(1);
					taulaAukerak.addItem(taulaIzena);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JButton joanBotoia = new JButton("Joan");
			joanBotoia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String aukeratutakoTaula = (String) taulaAukerak.getSelectedItem();

					if (aukeratutakoTaula != null && !aukeratutakoTaula.equals("Aukeratu")) {
						if (aukeratutakoTaula.equals("eskaera")) {
							dispose();
							EskaeraAdm t = new EskaeraAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("garraioa")) {
							dispose();
							GarraioAdm t = new GarraioAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("hornitzailea")) {
							dispose();
							HornitzaileAdm t = new HornitzaileAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("produktua")) {
							dispose();
							ProduktuAdm t = new ProduktuAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("berria")) {
							dispose();
							BerriaAdm t = new BerriaAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("bezeroa")) {
							dispose();
							BezeroaAdm t = new BezeroaAdm();
							t.setVisible(true);
						}
						if (aukeratutakoTaula.equals("langilea")) {
							dispose();
							LangileAdm t = new LangileAdm();
							t.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Joan nahiko zenukeen orri bat aukeratu behar duzu.");
					}
				}
			});
			joanBotoia.setFont(new Font("Agency FB", Font.BOLD, 15));
			joanBotoia.setBounds(600, 180, 70, 20);
			contentPane.add(joanBotoia);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
