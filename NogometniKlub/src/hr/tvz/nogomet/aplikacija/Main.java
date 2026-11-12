package hr.tvz.nogomet.aplikacija;

import hr.tvz.nogomet.apstraktne.Gradjevina;
import hr.tvz.nogomet.enumeracije.Pozicija;
import hr.tvz.nogomet.iznimke.KlubNijePronadenException;
import hr.tvz.nogomet.klase.Igrac;
import hr.tvz.nogomet.klase.MedicinskaOrdinacija;
import hr.tvz.nogomet.klase.NogometniKlub;
import hr.tvz.nogomet.klase.SportskiDom;
import hr.tvz.nogomet.klase.Stadion;
import hr.tvz.nogomet.klase.Trener;
import hr.tvz.nogomet.pomocne.ExceptionHandler;
import hr.tvz.nogomet.zapisi.Adresa;

import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        try {
            ExceptionHandler exceptionHandler = new ExceptionHandler(unos);
            int trenutnaGodina = Year.now().getValue();

            int brojKlubova = exceptionHandler.unesiCijeliBroj(
                    "Koliko klubova želite unijeti: ", 1, Integer.MAX_VALUE);
            NogometniKlub[] klubovi = new NogometniKlub[brojKlubova];

            for (int i = 0; i < brojKlubova; i++) {
                System.out.println();
                System.out.println("===== UNOS KLUBA " + (i + 1) + " =====");
                System.out.println();

                String nazivKluba = exceptionHandler.unesiObavezanTekst("Naziv kluba: ");
                String gradKluba = exceptionHandler.unesiObavezanTekst("Grad: ");
                int godinaOsnivanja = exceptionHandler.unesiCijeliBroj(
                        "Godina osnivanja: ", 1, trenutnaGodina);

                System.out.println();
                String imeTrenera = exceptionHandler.unesiObavezanTekst("Ime trenera: ");
                String prezimeTrenera = exceptionHandler.unesiObavezanTekst("Prezime trenera: ");
                int godinaRodenjaTrenera = exceptionHandler.unesiCijeliBroj(
                        "Godina rođenja: ", 1, trenutnaGodina);
                int godineIskustva = exceptionHandler.unesiCijeliBroj(
                        "Godine iskustva: ", 0, trenutnaGodina - godinaRodenjaTrenera);

                Trener trener = new Trener(imeTrenera, prezimeTrenera,
                        godinaRodenjaTrenera, godineIskustva);

                System.out.println();
                int brojIgraca = exceptionHandler.unesiCijeliBroj(
                        "Koliko igrača želite unijeti: ", 0, Integer.MAX_VALUE);
                Igrac[] igraci = new Igrac[brojIgraca];

                for (int j = 0; j < brojIgraca; j++) {
                    System.out.println("--- IGRAČ " + (j + 1) + " ---");

                    String imeIgraca = exceptionHandler.unesiObavezanTekst("Ime: ");
                    String prezimeIgraca = exceptionHandler.unesiObavezanTekst("Prezime: ");
                    int godinaRodenjaIgraca = exceptionHandler.unesiCijeliBroj(
                            "Godina rođenja: ", 1, trenutnaGodina);
                    int brojDresa = exceptionHandler.unesiCijeliBroj("Broj dresa: ", 1, 99);

                    Pozicija pozicija = exceptionHandler.unesiPoziciju("Pozicija ");

                    igraci[j] = new Igrac(imeIgraca, prezimeIgraca,
                            godinaRodenjaIgraca, brojDresa, pozicija);
                }

                System.out.println();
                int brojGradjevina = exceptionHandler.unesiCijeliBroj(
                        "Koliko građevina želite unijeti: ", 0, Integer.MAX_VALUE);
                Gradjevina[] gradjevine = new Gradjevina[brojGradjevina];

                for (int j = 0; j < brojGradjevina; j++) {
                    System.out.println();
                    System.out.println("--- GRAĐEVINA " + (j + 1) + " ---");

                    int vrsta = exceptionHandler.unesiOdabir(
                            "Vrsta (1 - Stadion, 2 - MedicinskaOrdinacija, 3 - SportskiDom): ", 1, 3);

                    String nazivGradjevine = exceptionHandler.unesiObavezanTekst("Naziv: ");
                    String ulica = exceptionHandler.unesiObavezanTekst("Ulica: ");
                    String kucniBroj = exceptionHandler.unesiObavezanTekst("Kućni broj: ");
                    String gradGradjevine = exceptionHandler.unesiObavezanTekst("Grad: ");

                    Adresa adresa = new Adresa(ulica, kucniBroj, gradGradjevine);

                    if (vrsta == 1) {
                        Integer kapacitet = exceptionHandler.unesiOpcionalniCijeliBroj(
                                "Kapacitet (Enter = nije unesen): ", 1, Integer.MAX_VALUE);
                        Integer godinaIzgradnje = exceptionHandler.unesiOpcionalniCijeliBroj(
                                "Godina izgradnje (Enter = nije unesena): ", 1, trenutnaGodina);
                        Boolean natkriven = exceptionHandler.unesiOpcionalniBoolean(
                                "Natkriven (true/false, Enter = nije uneseno): ");

                        gradjevine[j] = new Stadion(nazivGradjevine, adresa,
                                kapacitet, godinaIzgradnje, natkriven);

                    } else if (vrsta == 2) {
                        int brojAmbulanti = exceptionHandler.unesiCijeliBroj(
                                "Broj ambulanti: ", 1, Integer.MAX_VALUE);
                        boolean imaHitnuSluzbu = exceptionHandler.unesiBoolean(
                                "Ima hitnu službu (true/false): ");

                        gradjevine[j] = new MedicinskaOrdinacija(nazivGradjevine, adresa,
                                brojAmbulanti, imaHitnuSluzbu);

                    } else {
                        int brojKreveta = exceptionHandler.unesiCijeliBroj(
                                "Broj kreveta: ", 1, Integer.MAX_VALUE);
                        boolean imaBlagovaonicu = exceptionHandler.unesiBoolean(
                                "Ima blagovaonicu (true/false): ");

                        gradjevine[j] = new SportskiDom(nazivGradjevine, adresa,
                                brojKreveta, imaBlagovaonicu);
                    }
                }

                klubovi[i] = new NogometniKlub(nazivKluba, gradKluba, godinaOsnivanja,
                        trener, gradjevine, igraci);
            }

            while (true) {
                System.out.println();
                System.out.println("===== NOGOMETNI KLUBOVI =====");
                System.out.println("1 - Pretraži klub");
                System.out.println("0 - Završi program");

                int odabir = exceptionHandler.unesiOdabir("Odabir: ", 0, 1);

                if (odabir == 0) {
                    break;
                }

                if (odabir == 1) {
                    String trazeniNaziv = exceptionHandler.unesiObavezanTekst("Unesite naziv kluba: ");
                    try {
                        NogometniKlub pronadeniKlub = pronadiKlub(klubovi, trazeniNaziv);
                        System.out.println(pronadeniKlub.getOpis());
                    } catch (KlubNijePronadenException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } finally {
            unos.close();
            System.out.println("Program je završio.");
        }
    }

    private static NogometniKlub pronadiKlub(NogometniKlub[] klubovi, String naziv)
            throws KlubNijePronadenException {
        for (NogometniKlub klub : klubovi) {
            if (klub != null && klub.getNaziv() != null
                    && klub.getNaziv().equalsIgnoreCase(naziv)) {
                return klub;
            }
        }
        throw new KlubNijePronadenException(naziv);
    }
}
