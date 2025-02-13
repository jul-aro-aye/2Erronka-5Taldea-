package erronka2;

public class Produktua {
	private int idProduktua;
	private String izena;
	private String mota;
	private String marka;
	private String modeloa;
	private int stock;
	private Double prezioa;
	private String enpresaIzena;
	private int hornitzaileaId;

	public Produktua(int idProduktua, String izena, String mota, String marka, String modeloa, int stock,
			Double prezioa, int hornitzaileaId) {
		this.idProduktua = idProduktua;
		this.izena = izena;
		this.mota = mota;
		this.marka = marka;
		this.modeloa = modeloa;
		this.stock = stock;
		this.prezioa = prezioa;
		this.hornitzaileaId = hornitzaileaId;
	}
	
	public Produktua(int idProduktua, String izena, String mota, String marka, String modeloa, int stock,
			Double prezioa, String enpresaIzena) {
		this.idProduktua = idProduktua;
		this.izena = izena;
		this.mota = mota;
		this.marka = marka;
		this.modeloa = modeloa;
		this.stock = stock;
		this.prezioa = prezioa;
		this.enpresaIzena = enpresaIzena;
	}

	// Getters eta setters
	public int getIdProduktua() {
		return idProduktua;
	}

	public String getIzena() {
		return izena;
	}

	public String getMota() {
		return mota;
	}

	public String getMarka() {
		return marka;
	}

	public String getModeloa() {
		return modeloa;
	}

	public int getStock() {
		return stock;
	}

	public Double getPrezioa() {
		return prezioa;
	}

	public int getHornitzaileaId() {
		return hornitzaileaId;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrezioa(Double prezioa) {
		this.prezioa = prezioa;
	}

}
