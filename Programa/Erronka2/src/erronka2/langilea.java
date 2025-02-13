/**
 * 
 */
package erronka2;

/**
 * 
 */
public class Langilea {
	private int idLangilea;
	private String izenAbizenak;
	private String erabiltzailea;
	private String pasahitza;
	private String telefonoa;
	private String emaila;
	private String mota;
	
	public Langilea(int idLangilea, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String emaila, String mota) {
		this.idLangilea = idLangilea;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.mota = mota;
	}

	public Langilea(int idLangilea, String izenAbizenak, String erabiltzailea, String pasahitza, String telefonoa,
			String mota) {
		this.idLangilea = idLangilea;
		this.izenAbizenak = izenAbizenak;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.telefonoa = telefonoa;
		this.mota = mota;
	}

	/**
	 * @return the idLangilea
	 */
	public int getIdLangilea() {
		return idLangilea;
	}

	/**
	 * @param idLangilea the idLangilea to set
	 */
	public void setIdLangilea(int idLangilea) {
		this.idLangilea = idLangilea;
	}

	/**
	 * @return the izenAbizenak
	 */
	public String getIzenAbizenak() {
		return izenAbizenak;
	}

	/**
	 * @param izenAbizenak the izenAbizenak to set
	 */
	public void setIzenAbizenak(String izenAbizenak) {
		this.izenAbizenak = izenAbizenak;
	}

	/**
	 * @return the erabiltzailea
	 */
	public String getErabiltzailea() {
		return erabiltzailea;
	}

	/**
	 * @param erabiltzailea the erabiltzailea to set
	 */
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	/**
	 * @return the pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * @param pasahitza the pasahitza to set
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * @return the telefonoa
	 */
	public String getTelefonoa() {
		return telefonoa;
	}

	/**
	 * @param telefonoa the telefonoa to set
	 */
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	/**
	 * @return the emaila
	 */
	public String getEmaila() {
		return emaila;
	}

	/**
	 * @param emaila the emaila to set
	 */
	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	/**
	 * @return the mota
	 */
	public String getMota() {
		return mota;
	}

	/**
	 * @param mota the mota to set
	 */
	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
