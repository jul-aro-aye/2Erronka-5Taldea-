/**
 * 
 */
package erronka2;

import java.util.Date;

/**
 * 
 */
public class Eskaera {
	private int idEskaera;
	private int kopurua;
	private String data;
	private String langilea;
	private String egoera;
    private String garaioEnpresa;

	public Eskaera(int idEskaera, int kopurua, String data, String langilea, String egoera, String garaioEnpresa) {
		this.idEskaera = idEskaera;
		this.kopurua = kopurua;
		this.data = data;
		this.langilea = langilea;
		this.egoera = egoera;
		this.garaioEnpresa = garaioEnpresa;
	}

	public Eskaera() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idEskaera
	 */
	public int getIdEskaera() {
		return idEskaera;
	}

	/**
	 * @param idEskaera the idEskaera to set
	 */
	public void setIdEskaera(int idEskaera) {
		this.idEskaera = idEskaera;
	}

	/**
	 * @return the kopurua
	 */
	public int getKopurua() {
		return kopurua;
	}

	/**
	 * @param kopurua the kopurua to set
	 */
	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the langilea
	 */
	public String getLangilea() {
		return langilea;
	}

	/**
	 * @param langilea the langilea to set
	 */
	public void setLangilea(String langilea) {
		this.langilea = langilea;
	}

	/**
	 * @return the egoera
	 */
	public String getEgoera() {
		return egoera;
	}

	/**
	 * @param egoera the egoera to set
	 */
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	
	/**
	 * @param egoera the egoera to set
	 */
    public String getGaraioEnpresa() {
        return garaioEnpresa;
    }

    /**
	 * @param egoera the egoera to set
	 */
    public void setGaraioEnpresa(String garaioEnpresa) {
        this.garaioEnpresa = garaioEnpresa;
    }
	
}
