import javax.imageio.IIOException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

public class Kadry implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Pracownik> pracownicy = new ArrayList<>();

    public Kadry(List<Pracownik> pracownicy) {
        this.pracownicy = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }
    public boolean usunPracownika(String imie, String nazwisko) {
        return pracownicy.removeIf(pracownik -> pracownik.getImie().equals(imie) && pracownik.getNazwisko().equals(nazwisko));
    }

    public boolean aktualizujPracownika(String imie, String nazwisko, Pracownik nowyPracownik) {
        for (int i = 0; i < pracownicy.size(); i++) {
            Pracownik pracownik = pracownicy.get(i);
            if (pracownik.getImie().equals(imie) && pracownik.getNazwisko().equals(nazwisko)) {
                pracownicy.set(i, nowyPracownik);
                return true;
            }
        }
        return false;
    }

    public void wyswietlPracownikow(){
        for (Pracownik pracownik : pracownicy) {
            System.out.println("Imie: " + pracownik.getImie());
            System.out.println("Nazwisko: " + pracownik.getNazwisko());
            System.out.println("Adres: " + pracownik.getAdres());
            System.out.println("Zawód: " + pracownik.getZawod());
            System.out.println("Data urodzenia: " + pracownik.getDataUrodzenia());
        }
    }

    public List<Pracownik> znajdzPracownikowPoImieniu(String imie) {
        List<Pracownik> wyniki = new ArrayList<>();
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getImie().equalsIgnoreCase(imie)) {
                wyniki.add(pracownik);
            }
        }
        return wyniki;

    }

    public List<Pracownik> znajdzPracownikowPoNazwisku(String nazwisko) {
        List<Pracownik> wyniki = new ArrayList<>();
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getNazwisko().equalsIgnoreCase(nazwisko)) {
                wyniki.add(pracownik);
            }
        }
        return wyniki;

    }

    public List<Pracownik> znajdzPracownikowPoZawodzie(String zawod) {
        List<Pracownik> wyniki = new ArrayList<>();
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getZawod().equalsIgnoreCase(zawod)) {
                wyniki.add(pracownik);
            }
        }
        return wyniki;

    }

    public void wyswietlDanePracownika(String imie, String nazwisko) {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getImie().equals(imie) && pracownik.getNazwisko().equals(nazwisko)) {
                System.out.println(pracownik);
                return;
            }
        }
        System.out.println("Pracownik o podanym imieniu i nazwisku nie został znaleziony.");
    }

    public void zapiszDoPliku(String plik) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(plik))) {
            oos.writeObject(pracownicy);
            System.out.println("Lista pracowników została dodana do pliku: "+plik);
        } catch (IIOException e) {
            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void odczytajZPliku(String nazwaPliku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            pracownicy = (List<Pracownik>) ois.readObject();
            System.out.println("Lista pracowników została wczytana z pliku: " + nazwaPliku);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd podczas odczytu z pliku: " + e.getMessage());
        }
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }
}