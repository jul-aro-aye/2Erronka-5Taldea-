package erronka2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;

public class ProduktuAdm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable produktuak;
	private JTextField produktuIzena;
	private JTextField produktuMarka;
	private JTextField produktuModeloa;
	private JTextField txtProduktuStock;
	private JTextField txtProduktuPrezioa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProduktuAdm frame = new ProduktuAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProduktuAdm() {
//		Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
		Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
		Connection konexioadb;

		try {
			konexioadb = konexioa.getConnection();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			produktuak = new JTable();
			produktuak.setBounds(115, 150, 650, 350);
			contentPane.add(produktuak);

			String produktuGuztiak = "SELECT idProduktua, izena, mota, marka, modeloa, stock, prezioa, h.enpresaIzena AS \"Hornitzailea\" "
			        + "FROM erronka2.produktua "
			        + "LEFT JOIN hornitzailea h ON produktua.Hornitzailea_idHornitzailea = h.idHornitzailea;";

			try (Statement produktuGuztienEmaitzak = konexioadb.createStatement();
					ResultSet rs2 = produktuGuztienEmaitzak.executeQuery(produktuGuztiak)) {

				ResultSetMetaData metaData = rs2.getMetaData();
				int zutabeak = metaData.getColumnCount();

				Vector<String> taulakoZutabeak = new Vector<>();
				for (int i = 1; i <= zutabeak; i++) {
					taulakoZutabeak.add(metaData.getColumnLabel(i));
				}

				Vector<Vector<Object>> datuak = new Vector<>();
				while (rs2.next()) {
					Vector<Object> ilara = new Vector<>();
					for (int i = 1; i <= zutabeak; i++) {
						ilara.add(rs2.getObject(i));
					}
					datuak.add(ilara);
				}

				DefaultTableModel model = new DefaultTableModel(datuak, taulakoZutabeak);
				produktuak.setModel(model);

				produktuak.getColumnModel().getColumn(0).setMaxWidth(0);
				produktuak.getColumnModel().getColumn(0).setMinWidth(0);
				produktuak.getColumnModel().getColumn(0).setPreferredWidth(0);

				JScrollPane scrollPane = new JScrollPane(produktuak);
				scrollPane.setBounds(115, 150, 650, 350);
				contentPane.add(scrollPane);
				contentPane.revalidate();
				contentPane.repaint();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			JLabel lblProduktuIzena = new JLabel("Izena:");
			lblProduktuIzena.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuIzena.setBounds(40, 40, 80, 20);
			contentPane.add(lblProduktuIzena);

			JLabel lblProduktuMota = new JLabel("Produktu Mota");
			lblProduktuMota.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuMota.setBounds(40, 75, 80, 20);
			contentPane.add(lblProduktuMota);

			JLabel lblProduktuMarka = new JLabel("Marka");
			lblProduktuMarka.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuMarka.setBounds(40, 110, 80, 20);
			contentPane.add(lblProduktuMarka);

			JLabel lblProduktuModeloa = new JLabel("Modeloa");
			lblProduktuModeloa.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuModeloa.setBounds(300, 40, 80, 20);
			contentPane.add(lblProduktuModeloa);

			JLabel lblProduktuStock = new JLabel("Stock");
			lblProduktuStock.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuStock.setBounds(300, 75, 80, 20);
			contentPane.add(lblProduktuStock);

			JLabel lblProduktuPrezioa = new JLabel("Prezioa");
			lblProduktuPrezioa.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblProduktuPrezioa.setBounds(300, 110, 80, 20);
			contentPane.add(lblProduktuPrezioa);

			JButton gehituProduktua = new JButton("Gehitu");
			gehituProduktua.setBounds(700, 40, 100, 20);
			contentPane.add(gehituProduktua);

			JButton eguneratuProduktua = new JButton("Eguneratu");
			eguneratuProduktua.setBackground(new Color(255, 255, 128));

			eguneratuProduktua.setBounds(700, 75, 100, 20);
			contentPane.add(eguneratuProduktua);

			JComboBox<String> produktuMotak = new JComboBox<>();
			produktuMotak.setBounds(155, 75, 120, 20);
			contentPane.add(produktuMotak);

			produktuMotak.addItem("Aukeratu");

			String produktuMotaLista = "SELECT DISTINCT mota FROM produktua;";

			try (Statement produktuGuztienEmaitzak = konexioadb.createStatement();
					ResultSet rs2 = produktuGuztienEmaitzak.executeQuery(produktuMotaLista)) {

				while (rs2.next()) {

					String produktuMota = rs2.getString("mota");
					produktuMotak.addItem(produktuMota);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			produktuIzena = new JTextField();
			produktuIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			produktuIzena.setBounds(155, 40, 120, 20);
			contentPane.add(produktuIzena);
			produktuIzena.setColumns(10);

			produktuMarka = new JTextField();
			produktuMarka.setFont(new Font("Tahoma", Font.PLAIN, 15));
			produktuMarka.setBounds(155, 110, 120, 20);
			contentPane.add(produktuMarka);
			produktuMarka.setColumns(10);

			produktuModeloa = new JTextField();
			produktuModeloa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			produktuModeloa.setColumns(10);
			produktuModeloa.setBounds(390, 40, 120, 20);
			contentPane.add(produktuModeloa);

			txtProduktuStock = new JTextField();
			txtProduktuStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtProduktuStock.setColumns(10);
			txtProduktuStock.setBounds(390, 75, 120, 20);
			contentPane.add(txtProduktuStock);

			txtProduktuPrezioa = new JTextField();
			txtProduktuPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtProduktuPrezioa.setColumns(10);
			txtProduktuPrezioa.setBounds(390, 110, 120, 20);
			contentPane.add(txtProduktuPrezioa);

			JComboBox<String> hornitzaileak = new JComboBox<>();
			hornitzaileak.setBounds(550, 75, 120, 20);
			contentPane.add(hornitzaileak);

			hornitzaileak.addItem("Aukeratu");

			String hornitzaileLista = "SELECT DISTINCT h.enpresaIzena FROM hornitzailea h INNER JOIN produktua p on p.Hornitzailea_idHornitzailea = h.idHornitzailea;";

			try (Statement produktuGuztienEmaitzak = konexioadb.createStatement();
					ResultSet rs2 = produktuGuztienEmaitzak.executeQuery(hornitzaileLista)) {

				while (rs2.next()) {

					String enpresaIzena = rs2.getString("enpresaIzena");
					hornitzaileak.addItem(enpresaIzena);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JLabel lblHornitzailea = new JLabel("Hornitzailea");
			lblHornitzailea.setFont(new Font("Agency FB", Font.BOLD, 15));
			lblHornitzailea.setBounds(550, 40, 80, 20);
			contentPane.add(lblHornitzailea);

			JLabel orriIzenburua = new JLabel("Produktuak");
			orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
			orriIzenburua.setBounds(40, 5, 110, 30);
			contentPane.add(orriIzenburua);
			
			JButton ezabatuBotoia = new JButton("Ezabatu");
			ezabatuBotoia.setBackground(new Color(255, 128, 128));
			ezabatuBotoia.setBounds(700, 110, 100, 20);
			contentPane.add(ezabatuBotoia);

			gehituProduktua.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String izena = produktuIzena.getText().trim();
					String mota = (String) produktuMotak.getSelectedItem();
					String marka = produktuMarka.getText().trim();
					String modeloa = produktuModeloa.getText().trim();
					String stockStr = txtProduktuStock.getText().trim();
					String prezioaStr = txtProduktuPrezioa.getText().trim();
					String hornitzailea = (String) hornitzaileak.getSelectedItem();

					if (izena.isEmpty() || mota.equals("Aukeratu") || marka.isEmpty() || modeloa.isEmpty()
							|| stockStr.isEmpty() || prezioaStr.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Ezin dituzu produktuaren hutsik bidali.");
						return;
					}

					int stock = 0;
					try {
						stock = Integer.parseInt(stockStr);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Stock-aren balioa ez da zenbaki oso bat.");
						return;
					}

					double prezioa = 0.0;
					if (!prezioaStr.matches("\\d+(\\.\\d{1,2})?")) {
						JOptionPane.showMessageDialog(null,
								"Prezioaren formatua okerra da. Puntua erabili eta 2 hamartar gehienez.");
						return;
					}
					prezioa = Double.parseDouble(prezioaStr);

					try (PreparedStatement stmt = konexioadb.prepareStatement(
							"INSERT INTO produktua (izena, mota, marka, modeloa, stock, prezioa, Hornitzailea_idHornitzailea) "
									+ "VALUES (?, ?, ?, ?, ?, ?, (SELECT idHornitzailea FROM hornitzailea WHERE enpresaIzena = ?))")) {

						stmt.setString(1, izena);
						stmt.setString(2, mota);
						stmt.setString(3, marka);
						stmt.setString(4, modeloa);
						stmt.setInt(5, stock);
						stmt.setDouble(6, prezioa);
						stmt.setString(7, hornitzailea);

						int egindakoKontsultak = stmt.executeUpdate();

						if (egindakoKontsultak > 0) {
							JOptionPane.showMessageDialog(null, "Produktua ongi sortuta.");

						} else {
							JOptionPane.showMessageDialog(null, "Ez da produkturik sortu.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Arazoak produktua sortzean: " + e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			eguneratuProduktua.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String izena = produktuIzena.getText().trim();
					String mota = (String) produktuMotak.getSelectedItem();
					String marka = produktuMarka.getText().trim();
					String modeloa = produktuModeloa.getText().trim();
					String stockStr = txtProduktuStock.getText().trim();
					String prezioaStr = txtProduktuPrezioa.getText().trim();
					String hornitzailea = (String) hornitzaileak.getSelectedItem();

					if (izena.isEmpty() || mota.equals("Aukeratu") || marka.isEmpty() || modeloa.isEmpty()
							|| stockStr.isEmpty() || prezioaStr.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Ezin dituzu produktuaren hutsik bidali.");
						return;
					}

					int stock = 0;
					try {
						stock = Integer.parseInt(stockStr);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Stock-aren balioa ez da zenbaki oso bat.");
						return;
					}

					double prezioa = 0.0;
					if (!prezioaStr.matches("\\d+(\\.\\d{1,2})?")) {
						JOptionPane.showMessageDialog(null,
								"Prezioaren formatua okerra da. Puntua erabili eta 2 hamartar gehienez.");
						return;
					}
					prezioa = Double.parseDouble(prezioaStr);

					try {

						int selectedRow = produktuak.getSelectedRow();
						int idProduktua = (int) produktuak.getValueAt(selectedRow, 0);

						try (PreparedStatement stmt = konexioadb.prepareStatement("UPDATE produktua\r\n" + "SET \r\n"
								+ "    izena = ?, \r\n" + "    mota = ?, \r\n" + "    marka = ?, \r\n"
								+ "    modeloa = ?, \r\n" + "    stock = ?, \r\n" + "    prezioa = ?, \r\n"
								+ "    Hornitzailea_idHornitzailea = (SELECT idHornitzailea FROM hornitzailea WHERE enpresaIzena = ?)\r\n"
								+ "WHERE idProduktua = ?;")) {

							stmt.setString(1, izena);
							stmt.setString(2, mota);
							stmt.setString(3, marka);
							stmt.setString(4, modeloa);
							stmt.setInt(5, stock);
							stmt.setDouble(6, prezioa);
							stmt.setString(7, hornitzailea);

							stmt.setInt(8, idProduktua);

							int egindakoKontsultak = stmt.executeUpdate();

							if (egindakoKontsultak > 0) {
								JOptionPane.showMessageDialog(null, "Produktua ongi eguneratuta.");
							} else {
								JOptionPane.showMessageDialog(null, "Ez da produkturik eguneratuko.");
							}

						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Arazoak produktua eguneratzean: " + e1.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Errore bat gertatu da: " + e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			ezabatuBotoia.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        int selectedRow = produktuak.getSelectedRow();

			        if (selectedRow != -1) {
			            int idProduktua = (int) produktuak.getValueAt(selectedRow, 0);

			            String query = "DELETE FROM produktua WHERE idProduktua = ?";

			            try (Connection conn = konexioa.getConnection(); 
			                 PreparedStatement stmt = conn.prepareStatement(query)) {

			                stmt.setInt(1, idProduktua);
			                int rowsAffected = stmt.executeUpdate();

			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(null, "Produktua ongi ezabatu da.");
			                } else {
			                    JOptionPane.showMessageDialog(null, "Ezin izan da produktua ezabatu.");
			                }
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Arazoak produktua ezabatzean", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Ez duzu ezabatzeko produkturik aukeratu.");
			        }
			    }
			});


			produktuak.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					int row = produktuak.getSelectedRow();
					if (row != -1) {

						produktuIzena.setText(produktuak.getValueAt(row, 1).toString());
						produktuMarka.setText(produktuak.getValueAt(row, 3).toString());
						produktuModeloa.setText(produktuak.getValueAt(row, 4).toString());
						txtProduktuStock.setText(produktuak.getValueAt(row, 5).toString());
						txtProduktuPrezioa.setText(produktuak.getValueAt(row, 6).toString());

						String mota = produktuak.getValueAt(row, 2).toString();
						for (int i = 0; i < produktuMotak.getItemCount(); i++) {
							if (produktuMotak.getItemAt(i).equals(mota)) {
								produktuMotak.setSelectedIndex(i);
								break;
							}
						}

						String hornitzailea = produktuak.getValueAt(row, 7).toString();
						for (int i = 0; i < hornitzaileak.getItemCount(); i++) {
							if (hornitzaileak.getItemAt(i).equals(hornitzailea)) {
								hornitzaileak.setSelectedIndex(i);
								break;
							}
						}
					}
				}
			});

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
