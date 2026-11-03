public class NogometniKlub {

    private String naziv;
    private String grad;
    private int godinaOsnivanja;
    private Stadion stadion;
    private Trener trener;
    private Igrac[] igraci;

    public NogometniKlub(String naziv, String grad, int godinaOsnivanja, Stadion stadion, Trener trener, Igrac[] igraci) {
        this.naziv = naziv;
        this.grad = grad;
        this.godinaOsnivanja = godinaOsnivanja;
        this.stadion = stadion;
        this.trener = trener;
        this.igraci = igraci;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getGodinaOsnivanja() {
        return godinaOsnivanja;
    }

    public void setGodinaOsnivanja(int godinaOsnivanja) {
        this.godinaOsnivanja = godinaOsnivanja;
    }

    public Stadion getStadion() {
        return stadion;
    }

    public void setStadion(Stadion stadion) {
        this.stadion = stadion;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Igrac[] getIgraci() {
        return igraci;
    }

    public void setIgraci(Igrac[] igraci) {
        this.igraci = igraci;
    }

    public String getOpis() {
        return "===== " + naziv + " =====\n" + "Grad: " + grad + "\n" +
                "Godina osnivanja: " + godinaOsnivanja + "\n" +
                "Trener: " + trener.getIme() + " " + trener.getPrezime() +"\n" +
                "Stadion: " + stadion.getNaziv() + "\n";
    }
}