package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaulakKud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaulakKud frame = new TaulakKud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TaulakKud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox taulaAukerak = new JComboBox();
		taulaAukerak.setForeground(new Color(0, 0, 0));
		taulaAukerak.setBackground(new Color(255, 255, 255));
		taulaAukerak.setFont(new Font("Agency FB", Font.PLAIN, 15));
		taulaAukerak
				.setModel(new DefaultComboBoxModel(new String[] { "Aukeratu", "eskaera", "garraioa", "hornitzailea" }));
		taulaAukerak.setMaximumRowCount(4);
		taulaAukerak.setToolTipText("");
		taulaAukerak.setBounds(400, 180, 120, 20);
		contentPane.add(taulaAukerak);

		JButton aukeratuTaulaKud = new JButton("Joan");
		aukeratuTaulaKud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String aukeratutakoTaula = (String) taulaAukerak.getSelectedItem();

				if (aukeratutakoTaula != null && !aukeratutakoTaula.equals("Aukeratu")) {
					if (aukeratutakoTaula.equals("eskaera")) {
						dispose();
						EskaeraKud t = new EskaeraKud();
						t.setVisible(true);
					}
					if (aukeratutakoTaula.equals("garraioa")) {
						dispose();
						GarraioKud t = new GarraioKud();
						t.setVisible(true);
					}
					if (aukeratutakoTaula.equals("hornitzailea")) {
						dispose();
						HornitzaileKud t = new HornitzaileKud();
						t.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Joan nahiko zenukeen orri bat aukeratu behar duzu.");
				}
			}
		});
		aukeratuTaulaKud.setFont(new Font("Agency FB", Font.BOLD, 15));
		aukeratuTaulaKud.setBounds(600, 180, 70, 20);
		contentPane.add(aukeratuTaulaKud);

		JLabel lblNewLabel = new JLabel("Nora joan nahiko zenuke?");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel.setBounds(170, 180, 150, 20);
		contentPane.add(lblNewLabel);
	}
}
