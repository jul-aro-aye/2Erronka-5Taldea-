package erronka2;

public class Hornitzailea {
	private int idHornitzailea;
	private String enpresaIzena;
	private String kokapena;
	private int banatzaileKop;
	private String telefonoa;
	private String emaila;
	private String egoera;

	public Hornitzailea(int idHornitzailea, String enpresaIzena, String kokapena, int banatzaileKop, String telefonoa,
			String emaila, String egoera) {
		this.idHornitzailea = idHornitzailea;
		this.enpresaIzena = enpresaIzena;
		this.kokapena = kokapena;
		this.banatzaileKop = banatzaileKop;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.egoera = egoera;
	}

	public Hornitzailea() {
	}

	public Hornitzailea(String enpresaIzena) {
		this.enpresaIzena = enpresaIzena;
	}

	// Getters y Setters
	public int getIdHornitzailea() {
		return idHornitzailea;
	}
	
	

	public void setIdHornitzailea(int idHornitzailea) {
		this.idHornitzailea = idHornitzailea;
	}

	public String getEnpresaIzena() {
		return enpresaIzena;
	}

	public void setEnpresaIzena(String enpresaIzena) {
		this.enpresaIzena = enpresaIzena;
	}

	public String getKokapena() {
		return kokapena;
	}

	public void setKokapena(String kokapena) {
		this.kokapena = kokapena;
	}

	public int getBanatzaileKop() {
		return banatzaileKop;
	}

	public void setBanatzaileKop(int banatzaileKop) {
		this.banatzaileKop = banatzaileKop;
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

	public String getEgoera() {
		return egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	@Override
	public String toString() {
		return enpresaIzena;
	}

}
