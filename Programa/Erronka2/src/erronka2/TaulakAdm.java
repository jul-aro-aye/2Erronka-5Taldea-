package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class TaulakAdm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TaulakAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox taulaAukera = new JComboBox();
		taulaAukera.setForeground(new Color(0, 0, 0));
		taulaAukera.setBackground(new Color(128, 255, 255));
		taulaAukera.setFont(new Font("Agency FB", Font.PLAIN, 15));
		taulaAukera.setModel(new DefaultComboBoxModel(new String[] {"Aukeratu", "berria", "bezeroa", "eskaera", "garraioa", "hornitzailea", "langilea", "produktua"}));
		taulaAukera.setMaximumRowCount(9);
		taulaAukera.setToolTipText("");
		taulaAukera.setBounds(50, 55, 115, 20);
		contentPane.add(taulaAukera);
		
		JButton aukeraBidali = new JButton("Bidali");
		aukeraBidali.setFont(new Font("Agency FB", Font.BOLD, 15));
		aukeraBidali.setBounds(200, 55, 80, 20);
		contentPane.add(aukeraBidali);
	}
}
