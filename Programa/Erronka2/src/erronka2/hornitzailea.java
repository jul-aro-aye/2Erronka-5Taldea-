/**
 * 
 */
package erronka2;

/**
 * 
 */
public class hornitzailea {
	private int idHornitzailea;
	private String enpresaIzena;
	private String kokapena;
	private int banatzaileKop;
	private int telefonoa;
	private String emaila;
	private String egoera;

	public hornitzailea(int idHornitzailea, String enpresaIzena, String kokapena, int banatzaileKop, int telefonoa,
			String emaila, String egoera) {
		this.idHornitzailea = idHornitzailea;
		this.enpresaIzena = enpresaIzena;
		this.kokapena = kokapena;
		this.banatzaileKop = banatzaileKop;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
		this.egoera = egoera;
	}

	public hornitzailea() {

	}

	public hornitzailea(int idHornitzailea, String enpresaIzena, String kokapena, int banatzaileKop, int telefonoa,
			String egoera) {
		this.idHornitzailea = idHornitzailea;
		this.enpresaIzena = enpresaIzena;
		this.kokapena = kokapena;
		this.banatzaileKop = banatzaileKop;
		this.telefonoa = telefonoa;
		this.egoera = egoera;
	}

}
