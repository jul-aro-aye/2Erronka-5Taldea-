package erronka2;

public class Garraioa {
    private int idGarraioa;
    private String enpresaIzena;
    private String telefonoa;
    private String emaila;

    public Garraioa(int idGarraioa, String enpresaIzena, String telefonoa, String emaila) {
        this.idGarraioa = idGarraioa;
        this.enpresaIzena = enpresaIzena;
        this.telefonoa = telefonoa;
        this.emaila = emaila;
    }

    public int getIdGarraioa() {
        return idGarraioa;
    }

    public void setIdGarraioa(int idGarraioa) {
        this.idGarraioa = idGarraioa;
    }

    public String getEnpresaIzena() {
        return enpresaIzena;
    }

    public void setEnpresaIzena(String enpresaIzena) {
        this.enpresaIzena = enpresaIzena;
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
}
