import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        System.out.print("Koliko klubova želite unijeti: ");
        int brojKlubova = unos.nextInt();
        unos.nextLine();
        NogometniKlub[] klubovi = new NogometniKlub[brojKlubova];

        for (int i = 0; i < brojKlubova; i++) {
            System.out.print("===== UNOS KLUBA " + (i + 1) +  " =====");
            System.out.println("\n");
            System.out.print("Naziv kluba: ");
            String nazivKluba = unos.nextLine();
            System.out.print("Grad: ");
            String grad = unos.nextLine();
            System.out.print("Godina osnivanja: ");
            int godinaOsnivanja = unos.nextInt();
            unos.nextLine();
            System.out.print("\n");
            System.out.print("Naziv stadiona: ");
            String nazivStadiona = unos.nextLine();
            System.out.print("Grad stadiona: ");
            String gradStadiona = unos.nextLine();
            System.out.print("Kapacitet: ");
            int kapacitet = unos.nextInt();
            unos.nextLine();
            System.out.print("Godina izgradnje: ");
            int godinaIzgradnje = unos.nextInt();
            unos.nextLine();
            System.out.print("Je li stadion natkriven: ");
            boolean natkriven = unos.nextBoolean();
            unos.nextLine();
            Stadion stadion = new Stadion(nazivStadiona, gradStadiona, kapacitet, godinaIzgradnje, natkriven);
            System.out.print("\n");
            System.out.print("Ime trenera: ");
            String imeTrenera = unos.nextLine();
            System.out.print("Prezime trenera: ");
            String prezimeTrenera = unos.nextLine();
            System.out.print("Godina rođenja: ");
            int godinaRodenjaTrenera = unos.nextInt();
            unos.nextLine();
            System.out.print("Godine iskustva: ");
            int godineIskustva = unos.nextInt();
            unos.nextLine();
            Trener trener = new Trener(imeTrenera, prezimeTrenera, godinaRodenjaTrenera, godineIskustva);
            System.out.print("\n");
            System.out.print("Koliko igrača želite unijeti: ");
            int brojIgraca = unos.nextInt();
            unos.nextLine();
            Igrac[] igraci = new Igrac[brojIgraca];
            System.out.print("\n");
            for (int j = 0; j < brojIgraca; j++) {
                System.out.println("--- IGRAČ " + (j + 1) + " ---");
                System.out.print("Ime: ");
                String imeIgraca = unos.nextLine();
                System.out.print("Prezime: ");
                String prezimeIgraca = unos.nextLine();
                System.out.print("Godina rođenja: ");
                int godinaRodenjaIgraca = unos.nextInt();
                unos.nextLine();
                System.out.print("Broj dresa: ");
                int brojDresa = unos.nextInt();
                unos.nextLine();
                System.out.print("Pozicija: ");
                String pozicija = unos.nextLine();
                System.out.print("\n");
                Igrac igrac = new Igrac(imeIgraca, prezimeIgraca, godinaRodenjaIgraca, brojDresa, pozicija);
                igraci[j] = igrac;
            }
            NogometniKlub klub = new NogometniKlub(nazivKluba, grad, godinaOsnivanja, stadion, trener, igraci);
            klubovi[i] = klub;
        }

        System.out.print("\n");

        int odabir = -1;
        while (odabir != 0) {
            System.out.println("===== NOGOMETNI KLUBOVI =====");
            System.out.println("1 - Pretraži klub");
            System.out.println("0 - Završi program");
            System.out.print("\n");
            System.out.printf("Odabir: ");
            odabir = unos.nextInt();
            unos.nextLine();
            if (odabir == 1) {
                System.out.println("Unesite naziv kluba: ");
                String trazeniNaziv = unos.nextLine();
                boolean pronaden = false;
                for (int i = 0; i < klubovi.length; i++) {
                    if (klubovi[i].getNaziv().equalsIgnoreCase(trazeniNaziv)) {
                        System.out.println(klubovi[i].getOpis());
                        pronaden = true;
                    }
                }
                if (!pronaden) {
                    System.out.println("Nema kluba s tim nazivom.");
                }
            } else if (odabir == 0) {
                // Završi program
            }
        }
    }
}