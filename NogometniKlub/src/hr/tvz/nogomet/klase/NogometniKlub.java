package hr.tvz.nogomet.klase;

import hr.tvz.nogomet.apstraktne.Gradjevina;
import hr.tvz.nogomet.sucelja.Opisivo;

public class NogometniKlub implements Opisivo {

    private String naziv;
    private String grad;
    private int godinaOsnivanja;
    private Trener trener;
    private Gradjevina[] gradjevine;
    private Igrac[] igraci;

    public NogometniKlub(String naziv, String grad, int godinaOsnivanja,
                         Trener trener, Gradjevina[] gradjevine, Igrac[] igraci) {
        this.naziv = naziv;
        this.grad = grad;
        this.godinaOsnivanja = godinaOsnivanja;
        this.trener = trener;
        this.gradjevine = gradjevine;
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

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Gradjevina[] getGradjevine() {
        return gradjevine;
    }

    public void setGradjevine(Gradjevina[] gradjevine) {
        this.gradjevine = gradjevine;
    }

    public Igrac[] getIgraci() {
        return igraci;
    }

    public void setIgraci(Igrac[] igraci) {
        this.igraci = igraci;
    }

    public int getUkupanBrojKreveta() {
        int ukupanBrojKreveta = 0;

        if (gradjevine != null) {
            for (Gradjevina gradjevina : gradjevine) {
                if (gradjevina instanceof SportskiDom) {
                    SportskiDom sportskiDom = (SportskiDom) gradjevina;
                    ukupanBrojKreveta += sportskiDom.getBrojKreveta();
                }
            }
        }

        return ukupanBrojKreveta;
    }

    @Override
    public String getOpis() {
        String imeTrenera = trener == null ? "" :
                trener.getIme() + " " + trener.getPrezime();

        String opis = "===== " + naziv.toUpperCase() + " =====\n"
                + "Grad: " + grad + "\n"
                + "Godina osnivanja: " + godinaOsnivanja + "\n"
                + "Trener: " + imeTrenera + "\n";

        opis += "\nIgrači:\n";

        if (igraci != null) {
            for (int i = 0; i < igraci.length; i++) {
                Igrac igrac = igraci[i];

                opis += (i + 1) + ". "
                        + igrac.getIme() + " "
                        + igrac.getPrezime() + ", "
                        + igrac.getGodinaRodenja() + "., dres "
                        + igrac.getBrojDresa() + ", "
                        + igrac.getPozicija() + "\n";
            }
        }

        opis += "\nGrađevine:\n\n";

        if (gradjevine != null) {
            for (int i = 0; i < gradjevine.length; i++) {
                Gradjevina gradjevina = gradjevine[i];

                String vrsta;

                if (gradjevina instanceof Stadion) {
                    vrsta = "Stadion";
                } else if (gradjevina instanceof MedicinskaOrdinacija) {
                    vrsta = "Medicinska ordinacija";
                } else if (gradjevina instanceof SportskiDom) {
                    vrsta = "Sportski dom";
                } else {
                    vrsta = "Građevina";
                }

                opis += (i + 1) + ". " + vrsta + ": "
                        + gradjevina.getNaziv() + "\n"
                        + "   Adresa: " + gradjevina.getAdresa().ulica() + " "
                        + gradjevina.getAdresa().kucniBroj() + ", "
                        + gradjevina.getAdresa().grad() + "\n"
                        + "   " + gradjevina.getKapacitetZaIspis() + "\n";

                if (gradjevina instanceof Stadion) {
                    Stadion stadion = (Stadion) gradjevina;

                    opis += "   Godina izgradnje: "
                            + stadion.getGodinaIzgradnje() + "\n"
                            + "   Natkriven: "
                            + stadion.getNatkriven() + "\n";

                } else if (gradjevina instanceof MedicinskaOrdinacija) {
                    MedicinskaOrdinacija ordinacija =
                            (MedicinskaOrdinacija) gradjevina;

                    opis += "   Ima hitnu službu: "
                            + ordinacija.isImaHitnuSluzbu() + "\n";

                } else if (gradjevina instanceof SportskiDom) {
                    SportskiDom sportskiDom = (SportskiDom) gradjevina;

                    opis += "   Ima blagovaonicu: "
                            + sportskiDom.isImaBlagovaonicu() + "\n";
                }

                opis += "\n";
            }
        }

        opis += "Ukupan broj kreveta: "
                + getUkupanBrojKreveta() + "\n";

        return opis;
    }
}
