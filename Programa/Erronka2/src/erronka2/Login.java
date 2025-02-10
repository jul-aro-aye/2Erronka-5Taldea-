package erronka2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	private Connection konexioadb;
	private String erabiltzailea;
	private String pasahitza;
	private int saikeraMax = 3;

	public Login(Connection konexioadb, String erabiltzailea, String pasahitza, int saikeraMax) {
		this.konexioadb = konexioadb;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.saikeraMax = saikeraMax;
	}

	public Login(Connection konexioadb) {
		this.konexioadb = konexioadb;
	}

	public static String login(Connection konexioadb, Scanner eskannerra) {
		Scanner sc = new Scanner(System.in);
		int saikera = 0;
		String role = "none";
		int saikeraMax = 3;
		String erabiltzailea;
		String pasahitza;

		System.out.println("Ongi etorri EkoTeknoren aplikaziora.");
		while (saikera < saikeraMax) {
			System.out.print("Sartu zure erabiltzailea: ");
			erabiltzailea = sc.nextLine();
			System.out.print("Sartu zure pasahitza: ");
			pasahitza = sc.nextLine();

			try {
				String kontsulta = "SELECT erabiltzailea, pasahitza, mota FROM erronka2.langilea WHERE erabiltzailea = ? AND pasahitza = ?";
				PreparedStatement ps = konexioadb.prepareStatement(kontsulta);
				ps.setString(1, erabiltzailea);
				ps.setString(2, pasahitza);
				ResultSet emaitza = ps.executeQuery();

				if (emaitza.next()) {
					String mota = emaitza.getString("mota");

					if (mota.equals("A")) {
						role = "Admin";
						System.out.println("Administratzailea zara");
					} else if (mota.equals("K")) {
						role = "kudeatzailea";
						System.out.println("Kudeatzailea zara");
					} else if (mota.equals("L")) {
						role = "langilea";
						System.out.println("Langile arrunta zara");
					} else {
						role = "none";
						System.out.println("Rol ezezaguna");
					}
					break;
				} else {
					System.out.println("Erabiltzailea edo pasahitza okerra da.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			saikera++;
			if (saikera == saikeraMax) {
				System.out.println("Kontua blokeatu egin da. Saiakera gehiegi.");
			}
		}
		return role;
	}

}
