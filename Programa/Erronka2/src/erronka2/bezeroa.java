package erronka2;

public class bezeroa {
	private int idBezeroa;
	private String izenAbizenak;
	private String erabiltzailea;
	private String pasahitza;
	private String telefonoa;
	private String emaila;
	private String jaioUrtea;
	
	public bezeroa(int idBezeroa, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String emaila, String jaioUrtea) {
		this.idBezeroa = idBezeroa;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.jaioUrtea = jaioUrtea;
	}

	public bezeroa(int idBezeroa, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String jaioUrtea) {
		this.idBezeroa = idBezeroa;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.jaioUrtea = jaioUrtea;
	}
	
}
