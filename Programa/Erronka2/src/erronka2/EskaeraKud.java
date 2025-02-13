package erronka2;

import java.awt.EventQueue;
import erronka2.EskaeraDatabase;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class EskaeraKud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable eskaerak;
	private JTable eskaeraProduktuak;
	private JComboBox<String> txtEgoera;
	private JComboBox<String> txtLangilea;
	private JButton eguneratuBotoia;
	private Connection konexioadb;
	private EskaeraDatabase EskaeraDatabase;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EskaeraKud frame = new EskaeraKud();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public EskaeraKud() {
//        Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//				"1MG3EkoTekno@");
//    	Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
//    	
//    	EskaeraDatabase = new EskaeraDatabase(konexioadb);
//    	

		try {

//			konexioadb = DriverManager.getConnection("jdbc:mysql://172.16.237.86:3306/erronka2", "administratzailea",
//					"1MG3EkoTekno@");
			konexioadb = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
			EskaeraDatabase = new EskaeraDatabase(konexioadb);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 950, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			kargatuOsagaiak();
			EskaeraDatuak();
			EskaeraProduktuDatuak();
			setupEventListeners();

			addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					try {
						if (konexioadb != null && !konexioadb.isClosed()) {
							konexioadb.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void kargatuOsagaiak() {
		JLabel orriIzenburua = new JLabel("Eskaerak");
		orriIzenburua.setFont(new Font("Agency FB", Font.BOLD, 25));
		orriIzenburua.setBounds(40, 5, 120, 30);
		contentPane.add(orriIzenburua);

		eskaerak = new JTable();
		JScrollPane scrollPane = new JScrollPane(eskaerak);
		scrollPane.setBounds(400, 155, 500, 350);
		contentPane.add(scrollPane);
		
		LangileCombobox();
		setupComboBox();

		eskaeraProduktuak = new JTable();
		eskaeraProduktuak.setBounds(25, 155, 350, 350);
		contentPane.add(eskaeraProduktuak);
		
		eguneratuBotoia = new JButton("Eguneratu");
		eguneratuBotoia.setBackground(new Color(255, 255, 128));
		eguneratuBotoia.setBounds(550, 110, 120, 25);
		contentPane.add(eguneratuBotoia);
		
		JLabel lblEgoera = new JLabel("Egoera");
		lblEgoera.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEgoera.setBounds(220, 80, 100, 20);
		contentPane.add(lblEgoera);
		
		JLabel lblNewLabel = new JLabel("Zeinek onartzen du?");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel.setBounds(390, 80, 110, 20);
		contentPane.add(lblNewLabel);

	}

	private void setupComboBox() {
		
		
		txtEgoera = new JComboBox<>();
		txtEgoera.setBounds(220, 110, 120, 20);
		contentPane.add(txtEgoera);
		txtEgoera.addItem("Aukeratu");

		String egoeraLista = "SELECT DISTINCT egoera FROM eskaera";

		try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(egoeraLista)) {
			while (rs.next()) {
				txtEgoera.addItem(rs.getString("egoera"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void LangileCombobox() {
		
		txtLangilea = new JComboBox<>();
		txtLangilea.setBounds(390, 110, 120, 20);
		contentPane.add(txtLangilea);
		txtLangilea.addItem("Aukeratu");

		String langileLista = "SELECT DISTINCT izenAbizenak FROM langilea WHERE mota IN ('K', 'A')";

		try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(langileLista)) {
			while (rs.next()) {
				txtLangilea.addItem(rs.getString("izenAbizenak"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void EskaeraDatuak() {
		try {

			List<Eskaera> listaEskaera = EskaeraDatabase.EskaeraGuztiak();

			DefaultTableModel model = new DefaultTableModel();

			model.addColumn("ID");
			model.addColumn("Bezeroa");
			model.addColumn("Kopurua");
			model.addColumn("Data");
			model.addColumn("Garaio Enpresa");
			model.addColumn("Egoera");
			
			for (Eskaera eskaera : listaEskaera) {
				Vector<Object> row = new Vector<>();
				row.add(eskaera.getIdEskaera()); // ID eskaera
				row.add(eskaera.getLangilea()); // Langilea
				row.add(eskaera.getKopurua()); // Kopurua
				row.add(eskaera.getData()); // Data
				row.add(eskaera.getGaraioEnpresa()); // Garaio Enpresa
				row.add(eskaera.getEgoera()); // Egoera

				model.addRow(row);
			}

			eskaerak.setModel(model);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void EskaeraProduktuDatuak() {
	    String query = "SELECT pr.eskaera_id, p.izena FROM produktua_has_eskaera pr " +
	                   "INNER JOIN produktua p ON p.idProduktua = pr.produktua_idProduktua " +
	                   "ORDER BY eskaera_id";

	    try (Statement stmt = konexioadb.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

	        DefaultTableModel model = new DefaultTableModel();

	        model.addColumn("ID Eskaera");
	        model.addColumn("Izena Produktua");

	        while (rs.next()) {
	            Vector<Object> row = new Vector<>();
	            row.add(rs.getInt("eskaera_id"));
	            row.add(rs.getString("izena"));

	            model.addRow(row);
	        }

	        eskaeraProduktuak.setModel(model);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar los productos", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void setupEventListeners() {
		eskaerak.getSelectionModel().addListSelectionListener(e -> fillFieldsFromSelectedRow());

		eguneratuBotoia.addActionListener(e -> updateEskaera());

	}

	private void updateEskaera() {

		String aukeratutakoEgoera = txtEgoera.getSelectedItem().toString().trim();
	    String aukeratutakoLangilea = txtLangilea.getSelectedItem().toString().trim();

	    if (!aukeratutakoEgoera.equals("Aukeratu") && !aukeratutakoLangilea.equals("Aukeratu")) {
	        
	    	int row = eskaerak.getSelectedRow();
	        if (row != -1) {
	            
	        	String idEskaera = eskaerak.getValueAt(row, 0).toString();
	            
	            Eskaera eskaera = new Eskaera();
	            eskaera.setIdEskaera(Integer.parseInt(idEskaera));
	            eskaera.setEgoera(aukeratutakoEgoera);
	            
	            try {
	                EskaeraDatabase.updateEskaera(konexioadb, eskaera, aukeratutakoLangilea);
	                JOptionPane.showMessageDialog(this, "Eskaera ongi eguneratuta.", "Eguneraketa ona", JOptionPane.INFORMATION_MESSAGE);
	                EskaeraDatuak();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Arazoak eguneraketa egitean.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Egoera eta langile datuak bete mesedez", "Selección inválida", JOptionPane.WARNING_MESSAGE);
	    }
	}


	private void fillFieldsFromSelectedRow() {
		int row = eskaerak.getSelectedRow();
		if (row != -1) {

			String egoera = eskaerak.getValueAt(row, 5).toString().trim();

			for (int i = 0; i < txtEgoera.getItemCount(); i++) {
				if (txtEgoera.getItemAt(i).toString().trim().equals(egoera)) {
					txtEgoera.setSelectedIndex(i);
					break;
				}
			}

			String langilea = eskaerak.getValueAt(row, 1).toString().trim();

			for (int i = 0; i < txtLangilea.getItemCount(); i++) {
				if (txtLangilea.getItemAt(i).toString().trim().equals(langilea)) {
					txtLangilea.setSelectedIndex(i);
					break;
				}
			}
		}
	}
}