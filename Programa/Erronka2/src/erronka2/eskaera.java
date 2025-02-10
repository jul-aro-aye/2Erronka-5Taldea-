/**
 * 
 */
package erronka2;

import java.util.Date;

/**
 * 
 */
public class eskaera {
	private int id;
	private int idEskaera;
	private int kopurua;
	private Date data;
	private int langileID;
	private int idProduktua;
	
	public eskaera(int id, int idEskaera, int kopurua, Date data, int langileID, int idProduktua) {
		this.id = id;
		this.idEskaera = idEskaera;
		this.kopurua = kopurua;
		this.data = data;
		this.langileID = langileID;
		this.idProduktua = idProduktua;
	}
	
}
