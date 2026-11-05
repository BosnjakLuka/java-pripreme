
package hr.tvz.nogomet.aplikacija;

import hr.tvz.nogomet.apstraktne.Gradjevina;
import hr.tvz.nogomet.enumeracije.Pozicija;
import hr.tvz.nogomet.klase.Igrac;
import hr.tvz.nogomet.klase.MedicinskaOrdinacija;
import hr.tvz.nogomet.klase.NogometniKlub;
import hr.tvz.nogomet.klase.SportskiDom;
import hr.tvz.nogomet.klase.Stadion;
import hr.tvz.nogomet.klase.Trener;
import hr.tvz.nogomet.zapisi.Adresa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);

        int brojKlubova = procitajInt(unos, "Koliko klubova želite unijeti: ");
        NogometniKlub[] klubovi = new NogometniKlub[brojKlubova];

        for (int i = 0; i < brojKlubova; i++) {
            System.out.println();
            System.out.println("===== UNOS KLUBA " + (i + 1) + " =====");
            System.out.println();

            String nazivKluba = procitajString(unos, "Naziv kluba: ");
            String gradKluba = procitajString(unos, "Grad: ");
            int godinaOsnivanja = procitajInt(unos, "Godina osnivanja: ");

            System.out.println();
            String imeTrenera = procitajString(unos, "Ime trenera: ");
            String prezimeTrenera = procitajString(unos, "Prezime trenera: ");
            int godinaRodenjaTrenera = procitajInt(unos, "Godina rođenja: ");
            int godineIskustva = procitajInt(unos, "Godine iskustva: ");

            Trener trener = new Trener(imeTrenera, prezimeTrenera,
                    godinaRodenjaTrenera, godineIskustva);

            System.out.println();
            int brojIgraca = procitajInt(unos, "Koliko igrača želite unijeti: ");
            Igrac[] igraci = new Igrac[brojIgraca];

            for (int j = 0; j < brojIgraca; j++) {
                System.out.println("--- IGRAČ " + (j + 1) + " ---");

                String imeIgraca = procitajString(unos, "Ime: ");
                String prezimeIgraca = procitajString(unos, "Prezime: ");
                int godinaRodenjaIgraca = procitajInt(unos, "Godina rođenja: ");
                int brojDresa = procitajInt(unos, "Broj dresa: ");

                Pozicija pozicija = procitajPoziciju(unos,
                        "Pozicija (1 - VRATAR, 2 - BRANIC, 3 - VEZNJAK, 4 - NAPADAC): ");

                igraci[j] = new Igrac(imeIgraca, prezimeIgraca,
                        godinaRodenjaIgraca, brojDresa, pozicija);
            }

            System.out.println();
            int brojGradjevina = procitajInt(unos, "Koliko građevina želite unijeti: ");
            Gradjevina[] gradjevine = new Gradjevina[brojGradjevina];

            for (int j = 0; j < brojGradjevina; j++) {
                System.out.println();
                System.out.println("--- GRAĐEVINA " + (j + 1) + " ---");

                int vrsta = procitajVrstuGradjevine(unos);

                String nazivGradjevine = procitajString(unos, "Naziv: ");
                String ulica = procitajString(unos, "Ulica: ");
                String kucniBroj = procitajString(unos, "Kućni broj: ");
                String gradGradjevine = procitajString(unos, "Grad: ");

                Adresa adresa = new Adresa(ulica, kucniBroj, gradGradjevine);

                if (vrsta == 1) {
                    int kapacitet = procitajInt(unos, "Kapacitet: ");
                    int godinaIzgradnje = procitajInt(unos, "Godina izgradnje: ");
                    boolean natkriven = procitajBoolean(unos, "Natkriven (true/false): ");

                    gradjevine[j] = new Stadion(nazivGradjevine, adresa,
                            kapacitet, godinaIzgradnje, natkriven);

                } else if (vrsta == 2) {
                    int brojAmbulanti = procitajInt(unos, "Broj ambulanti: ");
                    boolean imaHitnuSluzbu = procitajBoolean(unos,
                            "Ima hitnu službu (true/false): ");

                    gradjevine[j] = new MedicinskaOrdinacija(nazivGradjevine, adresa,
                            brojAmbulanti, imaHitnuSluzbu);

                } else {
                    int brojKreveta = procitajInt(unos, "Broj kreveta: ");
                    boolean imaBlagovaonicu = procitajBoolean(unos,
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

            int odabir = procitajInt(unos, "Odabir: ");

            if (odabir == 0) {
                break;
            }

            if (odabir == 1) {
                String trazeniNaziv = procitajString(unos, "Unesite naziv kluba: ");
                NogometniKlub pronadeniKlub = pronadiKlubPoNazivu(klubovi, trazeniNaziv);

                if (pronadeniKlub == null) {
                    System.out.println("Nema kluba s tim nazivom.");
                } else {
                    System.out.println(pronadeniKlub.getOpis());
                }
            } else {
                System.out.println("Nepoznat odabir.");
            }
        }

        unos.close();
    }

    private static NogometniKlub pronadiKlubPoNazivu(NogometniKlub[] klubovi, String naziv) {
        for (NogometniKlub klub : klubovi) {
            if (klub != null && klub.getNaziv() != null
                    && klub.getNaziv().equalsIgnoreCase(naziv)) {
                return klub;
            }
        }
        return null;
    }

    private static String procitajString(Scanner scanner, String poruka) {
        while (true) {
            System.out.print(poruka);
            String tekst = scanner.nextLine().trim();

            if (!tekst.isEmpty()) {
                return tekst;
            }

            System.out.println("Unos ne smije biti prazan.");
        }
    }

    private static int procitajInt(Scanner scanner, String poruka) {
        while (true) {
            System.out.print(poruka);

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Morate unijeti cijeli broj.");
                continue;
            }

            int broj = scanner.nextInt();
            scanner.nextLine();

            if (broj >= 0) {
                return broj;
            }

            System.out.println("Broj ne smije biti negativan.");
        }
    }

    private static boolean procitajBoolean(Scanner scanner, String poruka) {
        while (true) {
            String vrijednost = procitajString(scanner, poruka);

            if (vrijednost.equalsIgnoreCase("true")) {
                return true;
            }

            if (vrijednost.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Unesite true ili false.");
        }
    }

    private static Pozicija procitajPoziciju(Scanner scanner, String poruka) {
        while (true) {
            int odabir = procitajInt(scanner, poruka);

            switch (odabir) {
                case 1:
                    return Pozicija.VRATAR;
                case 2:
                    return Pozicija.BRANIC;
                case 3:
                    return Pozicija.VEZNJAK;
                case 4:
                    return Pozicija.NAPADAC;
                default:
                    System.out.println("Nepoznat odabir. Pokušajte ponovno.");
            }
        }
    }

    private static int procitajVrstuGradjevine(Scanner scanner) {
        while (true) {
            int odabir = procitajInt(scanner,
                    "Vrsta (1 - Stadion, 2 - MedicinskaOrdinacija, 3 - SportskiDom): ");

            if (odabir >= 1 && odabir <= 3) {
                return odabir;
            }

            System.out.println("Nepoznata vrsta građevine. Pokušajte ponovno.");
        }
    }
}
