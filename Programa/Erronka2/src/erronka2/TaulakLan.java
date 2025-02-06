package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TaulakLan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable produktuak;
	private JTextField produktuIzena;
	private JTextField produktuMarka;
	private JTextField produktuModeloa;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaulakLan frame = new TaulakLan();
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
	public TaulakLan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		produktuak = new JTable();
		produktuak.setBounds(115, 150, 650, 350);
		contentPane.add(produktuak);
		
		JLabel lblProduktuIzena = new JLabel("Izena:");
		lblProduktuIzena.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblProduktuIzena.setBounds(40, 20, 80, 20);
		contentPane.add(lblProduktuIzena);
		
		JLabel lblProduktuMota = new JLabel("Produktu Mota");
		lblProduktuMota.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblProduktuMota.setBounds(40, 55, 80, 20);
		contentPane.add(lblProduktuMota);
		
		JLabel lblProduktuMarka = new JLabel("Marka");
		lblProduktuMarka.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblProduktuMarka.setBounds(40, 90, 80, 20);
		contentPane.add(lblProduktuMarka);
		
		JLabel txtProduktuModeloa = new JLabel("Modeloa");
		txtProduktuModeloa.setFont(new Font("Agency FB", Font.BOLD, 15));
		txtProduktuModeloa.setBounds(300, 20, 80, 20);
		contentPane.add(txtProduktuModeloa);
		
		JLabel txtProduktuStock = new JLabel("Stock");
		txtProduktuStock.setFont(new Font("Agency FB", Font.BOLD, 15));
		txtProduktuStock.setBounds(300, 55, 80, 20);
		contentPane.add(txtProduktuStock);
		
		JLabel txtProduktuPrezioa = new JLabel("Prezioa");
		txtProduktuPrezioa.setFont(new Font("Agency FB", Font.BOLD, 15));
		txtProduktuPrezioa.setBounds(300, 90, 80, 20);
		contentPane.add(txtProduktuPrezioa);
		
		JButton gehituProduktua = new JButton("Gehitu");
		gehituProduktua.setBackground(new Color(128, 255, 128));
		gehituProduktua.setBounds(600, 60, 80, 20);
		contentPane.add(gehituProduktua);
		
		JComboBox produktuMota = new JComboBox();
		produktuMota.setBounds(155, 55, 120, 20);
		contentPane.add(produktuMota);
		
		produktuIzena = new JTextField();
		produktuIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		produktuIzena.setBounds(155, 20, 120, 20);
		contentPane.add(produktuIzena);
		produktuIzena.setColumns(10);
		
		produktuMarka = new JTextField();
		produktuMarka.setFont(new Font("Tahoma", Font.PLAIN, 15));
		produktuMarka.setBounds(155, 90, 120, 20);
		contentPane.add(produktuMarka);
		produktuMarka.setColumns(10);
		
		produktuModeloa = new JTextField();
		produktuModeloa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		produktuModeloa.setColumns(10);
		produktuModeloa.setBounds(390, 90, 120, 20);
		contentPane.add(produktuModeloa);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(390, 55, 120, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(390, 23, 120, 20);
		contentPane.add(textField_2);
	}
}
