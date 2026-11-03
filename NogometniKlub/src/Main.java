import klase.Igrac;
import klase.NogometniKlub;
import klase.Stadion;
import klase.Trener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Koliko klubova želite unijeti: ");
        int brojKlubova = unos.nextInt();
        unos.nextLine();
        NogometniKlub[] klubovi = new NogometniKlub[brojKlubova];

        for (int i = 0; i < brojKlubova; i++) {
            System.out.println("===== UNOS KLUBA " + (i + 1) +  " =====");


            String nazivKluba = procitajString(unos, "Naziv kluba: ");
            String gradKluba = procitajString(unos, "Grad: ");
            System.out.print("Godina osnivanja: ");
            int godinaOsnivanja = unos.nextInt();
            unos.nextLine();
            String nazivStadiona = procitajString(unos, "Naziv stadiona: ");
            String gradStadiona = procitajString(unos, "Grad stadiona: ");
            System.out.print("Kapacitet: ");
            int kapacitet = unos.nextInt();
            unos.nextLine();
            System.out.print("Godina izgradnje: ");
            int godinaIzgradnje = unos.nextInt();
            unos.nextLine();
            System.out.print("Je li stadion natkriven (true/false): ");
            boolean natkriven = unos.nextBoolean();
            unos.nextLine();
            Stadion stadion = new Stadion(nazivStadiona, gradStadiona, kapacitet, godinaIzgradnje, natkriven);


            String imeTrenera = procitajString(unos, "Ime trenera: ");
            String prezimeTrenera = procitajString(unos, "Prezime trenera: ");
            System.out.print("Godina rođenja: ");
            int godinaRodenjaTrenera = unos.nextInt();
            unos.nextLine();
            System.out.print("Godine iskustva: ");
            int godineIskustva = unos.nextInt();
            unos.nextLine();
            Trener trener = new Trener(imeTrenera, prezimeTrenera, godinaRodenjaTrenera, godineIskustva);

            System.out.print("Koliko igrača želite unijeti: ");
            int brojIgraca = unos.nextInt();
            unos.nextLine();
            Igrac[] igraci = new Igrac[brojIgraca];

            for (int j = 0; j < brojIgraca; j++) {
                System.out.println();
                System.out.println("--- IGRAČ " + (j + 1) + " ---");
                String imeIgraca = procitajString(unos, "Ime: ");
                String prezimeIgraca = procitajString(unos, "Prezime: ");
                System.out.print("Godina rođenja: ");
                int godinaRodenjaIgraca = unos.nextInt();
                unos.nextLine();
                System.out.print("Broj dresa: ");
                int brojDresa = unos.nextInt();
                unos.nextLine();
                String pozicija = procitajString(unos, "Pozicija: ");
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

            System.out.print("Odabir: ");
            int odabir = unos.nextInt();
            unos.nextLine();

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
}