package hr.tvz.nogomet.aplikacija;

import hr.tvz.nogomet.klase.Igrac;
import hr.tvz.nogomet.klase.NogometniKlub;
import hr.tvz.nogomet.klase.Stadion;
import hr.tvz.nogomet.klase.Trener;
import hr.tvz.nogomet.enumeracije.Pozicija;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        int brojKlubova = procitajInt(unos, "Koliko klubova želite unijeti: ");
        NogometniKlub[] klubovi = new NogometniKlub[brojKlubova];

        for (int i = 0; i < brojKlubova; i++) {
            System.out.println("===== UNOS KLUBA " + (i + 1) +  " =====");

            String nazivKluba = procitajString(unos, "Naziv kluba: ");
            String gradKluba = procitajString(unos, "Grad: ");
            int godinaOsnivanja = procitajInt(unos, "Godina osnivanja: ");
            String nazivStadiona = procitajString(unos, "Naziv stadiona: ");
            String gradStadiona = procitajString(unos, "Grad stadiona: ");
            int kapacitet = procitajInt(unos, "Kapacitet: ");
            int godinaIzgradnje = procitajInt(unos, "Godina izgradnje: ");
            System.out.print("Je li stadion natkriven (true/false): ");
            boolean natkriven = unos.nextBoolean();
            unos.nextLine();
            Stadion stadion = new Stadion(nazivStadiona, gradStadiona, kapacitet, godinaIzgradnje, natkriven);


            String imeTrenera = procitajString(unos, "Ime trenera: ");
            String prezimeTrenera = procitajString(unos, "Prezime trenera: ");
            int godinaRodenjaTrenera = procitajInt(unos, "Godina rođenja: ");
            int godineIskustva = procitajInt(unos, "Godine iskustva: ");
            Trener trener = new Trener(imeTrenera, prezimeTrenera, godinaRodenjaTrenera, godineIskustva);

            int brojIgraca = procitajInt(unos, "Koliko igrača želite unijeti: ");
            Igrac[] igraci = new Igrac[brojIgraca];

            for (int j = 0; j < brojIgraca; j++) {
                System.out.println();
                System.out.println("--- IGRAČ " + (j + 1) + " ---");
                String imeIgraca = procitajString(unos, "Ime: ");
                String prezimeIgraca = procitajString(unos, "Prezime: ");
                int godinaRodenjaIgraca = procitajInt(unos, "Godina rođenja: ");
                int brojDresa = procitajInt(unos, "Broj dresa: ");
                Pozicija pozicija = procitajPoziciju(unos, "Pozicija (1 - VRATAR, 2 - BRANIC, 3 - VEZNJAK, 4 - NAPADAC): ");
                Igrac igrac = new Igrac(imeIgraca, prezimeIgraca, godinaRodenjaIgraca, brojDresa, pozicija);
                igraci[j] = igrac;
            }
            NogometniKlub klub = new NogometniKlub(nazivKluba, gradKluba, godinaOsnivanja, stadion, trener, igraci);
            klubovi[i] = klub;
        }

        while (true) {
            System.out.println();
            System.out.println("===== NOGOMETNI KLUBOVI =====");
            System.out.println();
            System.out.println("1 - Pretraži klub");
            System.out.println("0 - Završi program");
            System.out.println();

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
        System.out.println("Program završen.");
    }

    private static NogometniKlub pronadiKlubPoNazivu(NogometniKlub[] klubovi, String naziv) {
        for (NogometniKlub klub : klubovi) {
            if (klub != null && klub.getNaziv() != null && klub.getNaziv().equalsIgnoreCase(naziv)) {
                return klub;
            }
        }
        return null;
    }

    private static String procitajString(Scanner scanner, String poruka) {
        while (true) {
            System.out.print(poruka);
            String unos = scanner.nextLine().trim();
            if (!unos.isEmpty()) {
                return unos;
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
}