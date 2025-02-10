package erronka2;

public class garraioa {
	private int idGarraioa;
	private String EnpresaIzena;
	private String telefonoa;
	private String emaila;
	
	public garraioa(int idGarraioa, String enpresaIzena, String telefonoa, String emaila) {
		this.idGarraioa = idGarraioa;
		EnpresaIzena = enpresaIzena;
		this.telefonoa = telefonoa;
		this.emaila = emaila;
	}

	public garraioa(int idGarraioa, String enpresaIzena, String telefonoa) {
		this.idGarraioa = idGarraioa;
		EnpresaIzena = enpresaIzena;
		this.telefonoa = telefonoa;
	}
	
}
