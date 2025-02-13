package erronka2;

public class Bezeroa {
	private int idBezeroa;
	private String izenAbizenak;
	private String erabiltzailea;
	private String pasahitza;
	private String telefonoa;
	private String emaila;
	private String jaioUrtea;
	
	public Bezeroa(int idBezeroa, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String emaila, String jaioUrtea) {
		this.idBezeroa = idBezeroa;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.jaioUrtea = jaioUrtea;
	}

	public Bezeroa(int idBezeroa, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String jaioUrtea) {
		this.idBezeroa = idBezeroa;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.jaioUrtea = jaioUrtea;
	}

	public int getIdBezeroa() {
		return idBezeroa;
	}

	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}

	public String getIzenAbizenak() {
		return izenAbizenak;
	}

	public void setIzenAbizenak(String izenAbizenak) {
		this.izenAbizenak = izenAbizenak;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getJaioUrtea() {
		return jaioUrtea;
	}

	public void setJaioUrtea(String jaioUrtea) {
		this.jaioUrtea = jaioUrtea;
	}
	
}
