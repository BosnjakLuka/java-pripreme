public class Trener extends Osoba{

    private int godineIskustva;

    public Trener(String ime, String prezime, int godinaRodenja, int godinaIskustva) {
        super(ime, prezime, godinaRodenja);
        this.godineIskustva = godinaIskustva;
    }


    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }
}
