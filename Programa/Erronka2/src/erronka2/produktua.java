package erronka2;

public abstract class produktua {
	private int idProduktua;
	private String izena;
	private String mota;
	private String marka;
	private String modeloa;
	private int stock;
	private Double prezioa;
	
	public produktua(int idProduktua, String izena, String mota, String marka, String modeloa, int stock,
			Double prezioa) {
		this.idProduktua = idProduktua;
		this.izena = izena;
		this.mota = mota;
		this.marka = marka;
		this.modeloa = modeloa;
		this.stock = stock;
		this.prezioa = prezioa;
	}
	
}
