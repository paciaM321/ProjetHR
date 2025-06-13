import java.io.Serializable;
import java.util.Date;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

public class Pracownik  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String imie;
    private String nazwisko;
    private String adres;
    private String zawod;
    private Date dataUrodzenia;

    public Pracownik() {}

    public Pracownik(String imie, String nazwisko, String adres, String zawod, Date dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.zawod = zawod;
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public String getZawod() {
        return zawod;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String toString() {
        return "Pracownik: " + "imię: " +imie+ ", nazwisko: " +nazwisko+ " ,adres: " +adres+ " , zawód: " +zawod+ ", data urodzenia: " +dataUrodzenia;
    }

}

