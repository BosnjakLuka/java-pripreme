package hr.tvz.nogomet.pomocne;

import hr.tvz.nogomet.enumeracije.Pozicija;

import java.util.Scanner;

public class ExceptionHandler {
    private Scanner unos;

    public ExceptionHandler(Scanner unos) {
        this.unos = unos;
    }

    public String unesiObavezanTekst(String poruka) {
        while (true) {
            System.out.print(poruka);
            String tekst = unos.nextLine().trim();

            if (!tekst.isEmpty()) {
                return tekst;
            }

            System.out.println("Unos ne smije biti prazan.");
        }
    }

    public int unesiCijeliBroj(String poruka, int min, int max) {
        while (true) {
            System.out.print(poruka);

            try {
                int broj = Integer.parseInt(unos.nextLine().trim());

                if (broj < min || broj > max) {
                    throw new IllegalArgumentException(
                            "Broj mora biti između " + min + " i " + max + ".");
                }

                return broj;
            } catch (NumberFormatException e) {
                System.out.println("Morate unijeti cijeli broj.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer unesiOpcionalniCijeliBroj(String poruka, int min, int max) {
        while (true) {
            System.out.print(poruka);
            String tekst = unos.nextLine().trim();

            if (tekst.isEmpty()) {
                return null;
            }

            try {
                int broj = Integer.parseInt(tekst);

                if (broj < min || broj > max) {
                    throw new IllegalArgumentException(
                            "Broj mora biti između " + min + " i " + max + ".");
                }

                return broj;
            } catch (NumberFormatException e) {
                System.out.println("Morate unijeti cijeli broj.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean unesiBoolean(String poruka) {
        while (true) {
            System.out.print(poruka);
            String vrijednost = unos.nextLine().trim();

            if (vrijednost.equalsIgnoreCase("true")) {
                return true;
            }
            if (vrijednost.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Unesite true ili false.");
        }
    }

    public Boolean unesiOpcionalniBoolean(String poruka) {
        while (true) {
            System.out.print(poruka);
            String vrijednost = unos.nextLine().trim();

            if (vrijednost.isEmpty()) {
                return null;
            }
            if (vrijednost.equalsIgnoreCase("true")) {
                return true;
            }
            if (vrijednost.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Unesite true ili false ili pritisnite Enter.");
        }
    }

    public Pozicija unesiPoziciju(String poruka) {
        int odabir = unesiOdabir(
                poruka + "(1 - VRATAR, 2 - BRANIC, 3 - VEZNJAK, 4 - NAPADAC): ", 1, 4);

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
                throw new IllegalArgumentException("Nepoznata pozicija.");
        }
    }

    public int unesiOdabir(String poruka, int min, int max) {
        return unesiCijeliBroj(poruka, min, max);
    }
}
