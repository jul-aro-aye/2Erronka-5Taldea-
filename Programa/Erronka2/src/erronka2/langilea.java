/**
 * 
 */
package erronka2;

/**
 * 
 */
public abstract class langilea {
	private int idLangilea;
	private String izenAbizenak;
	private String erabiltzailea;
	private String pasahitza;
	private String telefonoa;
	private String emaila;
	private String mota;
	
	public langilea(int idLangilea, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String emaila, String mota) {
		this.idLangilea = idLangilea;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.mota = mota;
	}

	public langilea(int idLangilea, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String mota) {
		this.idLangilea = idLangilea;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.mota = mota;
	}
	
}
