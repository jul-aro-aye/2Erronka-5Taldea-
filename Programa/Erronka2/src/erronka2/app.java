/**
 * 
 */
package erronka2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//	    public Main {
//	        try {
//	            String rola = login();
//	            if (!rola.equals("none")) {
//	                System.out.println("Autenticación exitosa. Rol: " + rola);
//	            } else {
//	                System.out.println("Autenticación fallida.");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    public static String login() throws SQLException {
//	        Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
//	        Connection konexioadb = konexioa.getConnection();
//	        Scanner sc = new Scanner(System.in);
//	        int saikera = 0;
//	        String rola = "none";
//	        int saikeraMax = 3;
//	        String erabiltzailea;
//	        String pasahitza;
//
//	        System.out.println("Ongi etorri EkoTeknoren aplikaziora.");
//	        while (saikera < saikeraMax) {
//	            System.out.print("Sartu zure erabiltzailea: ");
//	            erabiltzailea = sc.nextLine();
//	            System.out.print("Sartu zure pasahitza: ");
//	            pasahitza = sc.nextLine();
//
//	            String kontsulta = "SELECT erabiltzailea, pasahitza, mota FROM erronka2.langilea WHERE erabiltzailea = ? AND pasahitza = ?";
//	            try (PreparedStatement ps = konexioadb.prepareStatement(kontsulta)) {
//	                ps.setString(1, erabiltzailea);
//	                ps.setString(2, pasahitza);
//	                try (ResultSet emaitza = ps.executeQuery()) {
//	                    if (emaitza.next()) {
//	                        String mota = emaitza.getString("mota");
//
//	                        switch (mota) {
//	                            case "A":
//	                                rola = "Admin";
//	                                System.out.println("Administratzailea zara");
//	                                break;
//	                            case "K":
//	                                rola = "kudeatzailea";
//	                                System.out.println("Kudeatzailea zara");
//	                                break;
//	                            case "L":
//	                                rola = "langilea";
//	                                System.out.println("Langile arrunta zara");
//	                                break;
//	                            default:
//	                                rola = "none";
//	                                System.out.println("Rol ezezaguna");
//	                                break;
//	                        }
//	                        break;
//	                    } else {
//	                        System.out.println("Erabiltzailea edo pasahitza okerra da.");
//	                    }
//	                }
//	            }
//	            saikera++;
//	            if (saikera == saikeraMax) {
//	                System.out.println("Kontua blokeatu egin da. Saiakera gehiegi.");
//	            }
//	        }
//	        konexioadb.close();
//	        sc.close();
//	        return rola;
//	    }
//	}
		
		// TODO Auto-generated method stub
//		Scanner eskannerra = new Scanner(System.in);
//
//        // Konexioa
//		Konexioa konexioa = new Konexioa("jdbc:mysql://localhost:3306/erronka2", "root", "1MG2024");
//
//        // Datu basera konexioa
//        konexioa.connect();
//
//        String rol = login(konexioa, eskannerra);
//
//        if (rol == null) {
//            System.out.println("Saioa huts egin du. Programa ixten...");
//            konexioa.disconnect();
//            return;
//        }
//
//        boolean irten = false;
//
//        while (!irten) {
//            System.out.println("Ongi etorri Aplikaziora");
//            System.out.println("1. Taulak ikusi");
//            if (rol.equals("admin")) {
//                System.out.println("2. Taulak editatu");
//            }
//            System.out.println("3. Programa itxi");
//            System.out.print("Aukeratu aukera bat: ");
//
//            int aukera = eskannerra.nextInt();
//
//            switch (aukera) {
//                case 1:
//                    taulakIkusi(konexioa, eskannerra);
//                    break;
//                case 2:
//                    if (rol.equals("admin")) {
//                        taulakEditatu(konexioa, eskannerra);
//                    } else {
//                        System.out.println("Ez daukazu baimenik taulak editatzeko.");
//                    }
//                    break;
//                case 3:
//                    System.out.println("Programa ixten...");
//                    irten = true;
//                    break;
//                default:
//                    System.out.println("Aukera ez da baliozkoa.");
//                    break;
//            }
//        }
//
//        // Konexio itxiera bukatzerakoan
//        konexioa.disconnect();
//    }
//
//    public static String login(Konexioa konexioa, Scanner eskannerra) {
//    	Scanner sc = new Scanner(System.in);
//		int saikera = 0;
//		String role = "none";
//		int saikeraMax = 3;
//		String erabiltzailea;
//		String pasahitza;
//		Connection konexioadb = konexioa;
//
//		System.out.println("Ongi etorri EkoTeknoren aplikaziora.");
//		while (saikera < saikeraMax) {
//			System.out.print("Sartu zure erabiltzailea: ");
//			erabiltzailea = sc.nextLine();
//			System.out.print("Sartu zure pasahitza: ");
//			pasahitza = sc.nextLine();
//
//			try {
//				String kontsulta = "SELECT erabiltzailea, pasahitza, mota FROM erronka2.langilea WHERE erabiltzailea = ? AND pasahitza = ?";
//				PreparedStatement ps = konexioadb.prepareStatement(kontsulta);
//				ps.setString(1, erabiltzailea);
//				ps.setString(2, pasahitza);
//				ResultSet emaitza = ps.executeQuery();
//
//				if (emaitza.next()) {
//					String mota = emaitza.getString("mota");
//
//					if (mota.equals("A")) {
//						role = "Admin";
//						System.out.println("Administratzailea zara");
//					} else if (mota.equals("K")) {
//						role = "kudeatzailea";
//						System.out.println("Kudeatzailea zara");
//					} else if (mota.equals("L")) {
//						role = "langilea";
//						System.out.println("Langile arrunta zara");
//					} else {
//						role = "none";
//						System.out.println("Rol ezezaguna");
//					}
//					break;
//				} else {
//					System.out.println("Erabiltzailea edo pasahitza okerra da.");
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			saikera++;
//			if (saikera == saikeraMax) {
//				System.out.println("Kontua blokeatu egin da. Saiakera gehiegi.");
//			}
//		}
//		return role;
//    }
//
//    public static void taulakIkusi(Konexioa dbKonexioa, Scanner eskannerra) {
//        System.out.println("Taulak bistaratzeko saiatzen...");
//        	// Konexioa klaseko getConnection hartzen dugu
//        Connection konexioa = dbKonexioa.getConnection();
//
//        String kontsulta = "SHOW TABLES";
//        List<String> taulak = new ArrayList<>();
//
//        try (Statement adierazpena = konexioa.createStatement();
//             ResultSet emaitzaMultzoa = adierazpena.executeQuery(kontsulta)) {
//
//            System.out.println("Taulak:");
//            int index = 1;
//            while (emaitzaMultzoa.next()) {
//                String taulaIzena = emaitzaMultzoa.getString(1);
//                taulak.add(taulaIzena);
//                System.out.println(index + ". " + taulaIzena);
//                index++;
//            }
//
//            if (!taulak.isEmpty()) {
//                System.out.print("Aukeratu taula bat bistaratzeko (edo 0 itzultzeko): ");
//                int taulaAukera = eskannerra.nextInt();
//
//                if (taulaAukera == 0) {
//                    return;
//                } else if (taulaAukera > 0 && taulaAukera <= taulak.size()) {
//                    String hautatutakoTaula = taulak.get(taulaAukera - 1);
//                    taulaDatuakBistaratu(konexioa, hautatutakoTaula);
//                } else {
//                    System.out.println("Aukera ez da baliozkoa.");
//                }
//            } else {
//                System.out.println("Ez dago taularik datu-basean.");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Errorea taulak bistaratzean: " + e.getMessage());
//        }
//    }
//
//    public static void taulaDatuakBistaratu(Connection konexioa, String taulaIzena) {
//        String kontsulta = "SELECT * FROM " + taulaIzena;
//
//        try (Statement adierazpena = konexioa.createStatement();
//             ResultSet emaitzaMultzoa = adierazpena.executeQuery(kontsulta)) {
//
//            int zutabeKopurua = emaitzaMultzoa.getMetaData().getColumnCount();
//            System.out.println("Taulako datuak: " + taulaIzena);
//
//            for (int i = 1; i <= zutabeKopurua; i++) {
//                System.out.print(emaitzaMultzoa.getMetaData().getColumnName(i) + "\t");
//            }
//            System.out.println();
//
//            while (emaitzaMultzoa.next()) {
//                for (int i = 1; i <= zutabeKopurua; i++) {
//                    System.out.print(emaitzaMultzoa.getString(i) + "\t");
//                }
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            System.out.println("Errorea taulako datuak bistaratzean: " + e.getMessage());
//        }
//    }
//
//    public static void taulakEditatu(Konexioa dbKonexioa, Scanner eskannerra) {
//        boolean irten = false;
//
//        while (!irten) {
//            System.out.println("1. Gehitu");
//            System.out.println("2. Ezabatu");
//            System.out.println("3. Editatu");
//            System.out.println("4. Itzuli");
//            System.out.print("Aukeratu aukera bat: ");
//
//            int aukera = eskannerra.nextInt();
//            eskannerra.nextLine(); 
//
//            switch (aukera) {
//                case 1:
//                    gehituProduktua(dbKonexioa, eskannerra);
//                    break;
//                case 2:
//                    // Produktua ezabatzeko aukera
//                    System.out.println("Sartu ezabatu nahi duzun produktua IDa: ");
//                    int produktuaId = eskannerra.nextInt();
//                    ezabatuProduktua(dbKonexioa, produktuaId);
//                    break;
//                case 3:
//                    // Produktua editatzeko aukera
//                    System.out.println("Sartu editatu nahi duzun produktua IDa: ");
//                    produktuaId = eskannerra.nextInt();
//                    eskannerra.nextLine(); 
//                    try {
//                        updateProduktua(dbKonexioa, produktuaId);
//                    } catch (SQLException e) {
//                        System.out.println("Errorea produktua eguneratzerakoan: " + e.getMessage());
//                    }
//                    break;
//                case 4:
//                    irten = true;
//                    break;
//                default:
//                    System.out.println("Aukera ez da baliozkoa.");
//                    break;
//            }
//        }
//    }
//
//    public static void gehituProduktua(Konexioa dbKonexioa, Scanner eskannerra) {
//    	Connection konexioadb = null;
//        PreparedStatement psProduktua = null;
//
//        // Produktuaren datuen bariableak
//        String sartutakoProduktua;
//        String sartutakoProzesadorea;
//        String sartutakoPantaila;
//        String sartutakoRAM;
//        String sartutakoAlmazenamendua;
//        String sartutakoInterfazeGrafikoa;
//        String sartutakoBateria;
//        String sartutakoKonektorea;
//        String sartutakoFabrikazioData;
//        double sartutakoPrezioa;
//        int sartutakoStocka;
//        double sartutakoBidalketaGastuak;
//        String sartutakoBidalketaIraupena;
//
//        try {
//            // Konexioa erabiltzen dugu
//            konexioadb = dbKonexioa.getConnection();
//
//            Scanner sc = new Scanner(System.in);
//
//            // Erabiltzaileari datuak eskatzen dizkiogu
//            System.out.println("Sartu produktuaren izena:");
//            sartutakoProduktua = sc.nextLine();
//
//            System.out.println("Sartu produktuko prozesadorea:");
//            sartutakoProzesadorea = sc.nextLine();
//
//            System.out.println("Sartu pantailaren tamaina:");
//            sartutakoPantaila = sc.nextLine();
//
//            System.out.println("Sartu RAM kantitatea:");
//            sartutakoRAM = sc.nextLine();
//
//            System.out.println("Sartu almacenamenduaren tamaina:");
//            sartutakoAlmazenamendua = sc.nextLine();
//
//            System.out.println("Sartu interfaz grafikoa:");
//            sartutakoInterfazeGrafikoa = sc.nextLine();
//
//            System.out.println("Sartu bateria iraupena:");
//            sartutakoBateria = sc.nextLine();
//
//            System.out.println("Sartu konektorea:");
//            sartutakoKonektorea = sc.nextLine();
//
//            System.out.println("Sartu fabrikazio data (YYYY-MM-DD):");
//            sartutakoFabrikazioData = sc.nextLine();
//
//            System.out.println("Sartu prezioa:");
//            sartutakoPrezioa = sc.nextDouble();
//
//            System.out.println("Sartu stocka:");
//            sartutakoStocka = sc.nextInt();
//
//            System.out.println("Sartu bidalketa gastuak:");
//            sartutakoBidalketaGastuak = sc.nextDouble();
//            sc.nextLine();  
//
//            System.out.println("Sartu bidalketa iraupena:");
//            sartutakoBidalketaIraupena = sc.nextLine();
//
//            // Frabrikazio urtea Date bezala definitu
//            Date fabrikazioDataDate = Date.valueOf(sartutakoFabrikazioData);
//
//            // Insert kontsulta sortu
//            String insert = "INSERT INTO produktuak (Produktua, Prozesadorea, Pantaila, RAM, Almazenamendua, InterfazeGrafikoa, Bateria, Konektorea, FabrikazioData, Prezioa, Stocka, BidalketaGastuak, BidalketaIraupena) "
//                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            // Parametroekin kontsulta prestatu
//            psProduktua = konexioadb.prepareStatement(insert);
//            psProduktua.setString(1, sartutakoProduktua);
//            psProduktua.setString(2, sartutakoProzesadorea);
//            psProduktua.setString(3, sartutakoPantaila);
//            psProduktua.setString(4, sartutakoRAM);
//            psProduktua.setString(5, sartutakoAlmazenamendua);
//            psProduktua.setString(6, sartutakoInterfazeGrafikoa);
//            psProduktua.setString(7, sartutakoBateria);
//            psProduktua.setString(8, sartutakoKonektorea);
//            psProduktua.setDate(9, fabrikazioDataDate);  // Date bihurtu
//            psProduktua.setDouble(10, sartutakoPrezioa);
//            psProduktua.setInt(11, sartutakoStocka);
//            psProduktua.setDouble(12, sartutakoBidalketaGastuak);
//            psProduktua.setString(13, sartutakoBidalketaIraupena);
//
//            // Inserta ejekutatzeko
//            int insertatuta = psProduktua.executeUpdate();
//
//            if (insertatuta > 0) {
//                System.out.println("Produktua ondo gehitu da.");
//            } else {
//                System.out.println("Errorea gertatu da produktuaren gehiketan.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Errorea produktuaren gehiketan: " + e.getMessage());
//        } finally {
//            // Konexioak itxi
//            try {
//                if (psProduktua != null) psProduktua.close();
//                if (konexioadb != null) konexioadb.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    
//
//    public static void ezabatuProduktua(Konexioa dbKonexioa, int produktuaId) {
//    	Connection konexioadb = null;
//	     PreparedStatement psProduktua = null;
//		int sartutakoId = 0;
//      
//       Konexioa konexioa = new Konexioa("jdbc:mysql://172.16.241.231/erronka2", "Admin", "1MG3@2024");
//
//       try {
//           konexioa.connect();
//           konexioadb = konexioa.getConnection();
//
//           Scanner sc = new Scanner(System.in);
//
//           System.out.println("Sartu Id-a berriro mesedez:");
//           sartutakoId = sc.nextInt();
//           sc.nextLine();
//          
//           String ezabatu = "DELETE FROM produktuak WHERE IdProduktua=?";
//           psProduktua = konexioadb.prepareStatement(ezabatu);
//          
//           psProduktua.setInt(1, sartutakoId);
//          
//           int aldatutakoIlarak = psProduktua.executeUpdate();
//           if (aldatutakoIlarak > 0) {
//               System.out.println("Produktua ondo ezabatu da.");
//           } else {
//               System.out.println("Produktua ez da ezabatu.");
//           }
//
//       } catch (SQLException e) {
//           e.printStackTrace();
//       } finally {
//           
//           try {
//               if (psProduktua != null) psProduktua.close();
//               if (konexioadb != null) konexioadb.close();
//           } catch (SQLException e) {
//               e.printStackTrace();
//           }
//       }
//   }
//
//    public static void updateProduktua(Konexioa dbKonexioa, int produktuaId) throws SQLException {
//        Connection konexioadb = null;
//        PreparedStatement psProduktua = null;
//
//        int sartutakoId = 0;
//        String sartutakoProduktua = null;
//        String sartutakoProzesadorea = null;
//        String sartutakoPantaila = null;
//        String sartutakoRAM = null;
//        String sartutakoAlmazenamendua = null;
//        String sartutakoInterfazeGrafikoa = null;
//        String sartutakoBateria = null;
//        String sartutakoKonektorea = null;
//        String sartutakoFabrikazioData = null;
//        double sartutakoPrezioa = 0.00;
//        int sartutakoStocka = 0;
//        double sartutakoBidalketaGastuak = 0.00;
//        String sartutakoBidalketaIraupena = null;
//
//        // Usamos la conexión de la clase Konexioa
//        konexioadb = dbKonexioa.getConnection();
//
//        try {
//            Scanner sc = new Scanner(System.in);
//
//            // Erabiltzaileari editatu nahi duen Id-a eskatu
//            System.out.println("Produktuaren Id-a berriro sartu mesedez:");
//            sartutakoId = sc.nextInt();
//            sc.nextLine();  
//
//            // Editatu nahi dugun produktuaren datuak eskatzeko:
//            System.out.println("Sartu beharreko datuak: Produktua, Prozesadorea, Pantaila, RAM, Almazenamendua, Interfaze Grafikoa, Bateria, Konektorea, Fabrikazio data, Prezioa, Stocka, Bidalketa Gastuak, Bidalketa Iraupena");
//            sartutakoProduktua = sc.nextLine();
//            sartutakoProzesadorea = sc.nextLine();
//            sartutakoPantaila = sc.nextLine();
//            sartutakoRAM = sc.nextLine();
//            sartutakoAlmazenamendua = sc.nextLine();
//            sartutakoInterfazeGrafikoa = sc.nextLine();
//            sartutakoBateria = sc.nextLine();
//            sartutakoKonektorea = sc.nextLine();
//            sartutakoFabrikazioData = sc.nextLine();
//
//            	// Frabrikazio urtea Date bezala definitu
//            Date fabrikazioDataDate = Date.valueOf(sartutakoFabrikazioData);
//
//            sartutakoPrezioa = sc.nextDouble();
//            sc.nextLine();  
//            sartutakoStocka = sc.nextInt();
//            sc.nextLine();  
//            sartutakoBidalketaGastuak = sc.nextDouble();
//            sc.nextLine();  
//            sartutakoBidalketaIraupena = sc.nextLine();
//
//            	// Kontsultaren aktualizazioa prestatu
//            String editatu = "UPDATE produktuak SET Produktua=?, Prozesadorea=?, Pantaila=?, RAM=?, Almazenamendua=?, InterfazeGrafikoa=?, Bateria=?, Konektorea=?, FabrikazioData=?, Prezioa=?, Stocka=?, BidalketaGastuak=?, BidalketaIraupena=? WHERE IdProduktua=?";
//            psProduktua = konexioadb.prepareStatement(editatu);
//
//            	// Erabiltzaileak kontsultara sartzeko balioak asignatu
//            psProduktua.setString(1, sartutakoProduktua);
//            psProduktua.setString(2, sartutakoProzesadorea);
//            psProduktua.setString(3, sartutakoPantaila);
//            psProduktua.setString(4, sartutakoRAM);
//            psProduktua.setString(5, sartutakoAlmazenamendua);
//            psProduktua.setString(6, sartutakoInterfazeGrafikoa);
//            psProduktua.setString(7, sartutakoBateria);
//            psProduktua.setString(8, sartutakoKonektorea);
//            psProduktua.setDate(9, fabrikazioDataDate);  // Convertir la fecha
//            psProduktua.setDouble(10, sartutakoPrezioa);
//            psProduktua.setInt(11, sartutakoStocka);
//            psProduktua.setDouble(12, sartutakoBidalketaGastuak);
//            psProduktua.setString(13, sartutakoBidalketaIraupena);
//            psProduktua.setInt(14, sartutakoId);
//
//            // Aktualizazioa ejekutatzeko
//            int aldatutakoIlarak = psProduktua.executeUpdate();
//
//            if (aldatutakoIlarak > 0) {
//                System.out.println("Produktua ondo aktualizatu da.");
//            } else {
//                System.out.println("Produktua ez da aktualizatu.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            
//            try {
//                if (psProduktua != null) psProduktua.close();
//                if (konexioadb != null) konexioadb.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
	}
}
		
