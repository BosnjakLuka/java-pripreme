public class Igrac extends Osoba{

    public static final String POZICIJA_VRATA = "VRATAR";
    public static final String POZICIJA_BRANIC = "BRANIC";
    public static final String POZICIJA_VEZNJAK = "VEZNJAK";
    public static final String POZICIJA_NAPADAC = "NAPADAC";

    private int brojDresa;
    private String pozicija;

    public Igrac(String ime, String prezime, int godinaRodenja, int brojDresa, String pozicija) {
        super(ime, prezime, godinaRodenja);
        this.brojDresa = brojDresa;
        this.pozicija = pozicija;
    }

    public int getBrojDresa() {
        return brojDresa;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public void setBrojDresa(int brojDresa) {
        this.brojDresa = brojDresa;
    }
}
