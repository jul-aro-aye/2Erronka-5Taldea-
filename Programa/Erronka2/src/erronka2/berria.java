package erronka2;

class Berria {
    private int idBerria;
    private String izenburua, testua, data, langilea;

    public Berria(int idBerria, String izenburua, String testua, String data, String langilea) {
        this.idBerria = idBerria;
        this.izenburua = izenburua;
        this.testua = testua;
        this.data = data;
        this.langilea = langilea;
    }

    public int getIdBerria() {
        return idBerria;
    }

    public String getIzenburua() {
        return izenburua;
    }

    public String getTestua() {
        return testua;
    }

    public String getData() {
        return data;
    }

    public String getLangilea() {
        return langilea;
    }

    @Override
    public String toString() {
        return "Berria [idBerria=" + idBerria + ", izenburua=" + izenburua + ", testua=" + testua + ", data=" + data
                + ", langilea=" + langilea + "]";
    }
}
