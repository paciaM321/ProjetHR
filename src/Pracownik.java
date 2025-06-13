import java.io.Serializable;
import java.util.Date;

public class Pracownik extends Osoba implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adres;
    private String zawod;

    public Pracownik(String imie, String nazwisko, String adres, String zawod, Date dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);
        this.adres = adres;
        this.zawod = zawod;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getZawod() {
        return zawod;
    }

    public void setZawod(String zawod) {
        this.zawod = zawod;
    }

    @Override
    public String toString() {
        return "Pracownik: " +
                "imię: " + imie +
                ", nazwisko: " + nazwisko +
                ", adres: " + adres +
                ", zawód: " + zawod +
                ", data urodzenia: " + dataUrodzenia;
    }
}

