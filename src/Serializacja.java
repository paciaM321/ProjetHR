import java.util.Date;
import java.util.Scanner;

public class Serializacja {
    public static void main(String[] args) {
        Kadry kadry = new Kadry();
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj pracownika");
            System.out.println("2. Usuń pracownika");
            System.out.println("3. Zaktualizuj pracownika");
            System.out.println("4. Wyświetl pracowników");
            System.out.println("5. Wyszukaj pracowników po imieniu");
            System.out.println("6. Wyszukaj pracowników po nazwisku");
            System.out.println("7. Wyszukaj pracowników po zawodzie");
            System.out.println("8. Statystyki");
            System.out.println("9. Zapisz do pliku");
            System.out.println("10. Odczytaj z pliku");
            System.out.println("0. Zakończ");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();
            scanner.nextLine(); // Odczytanie nowej linii

            switch (wybor) {
                case 1: // Dodaj pracownika
                    System.out.print("Podaj imię: ");
                    String imie = scanner.nextLine();
                    System.out.print("Podaj nazwisko: ");
                    String nazwisko = scanner.nextLine();
                    System.out.print("Podaj adres: ");
                    String adres = scanner.nextLine();
                    System.out.print("Podaj zawód: ");
                    String zawod = scanner.nextLine();
                    System.out.print("Podaj datę urodzenia (format: yyyy-MM-dd): ");
                    String dataString = scanner.nextLine();
                    Date dataUrodzenia = java.sql.Date.valueOf(dataString);
                    Pracownik nowyPracownik = new Pracownik(imie, nazwisko, adres, zawod, dataUrodzenia);
                    kadry.dodajPracownika(nowyPracownik);
                    break;

                case 2: // Usuń pracownika
                    System.out.print("Podaj imię: ");
                    String imieUsuniecie = scanner.nextLine();
                    System.out.print("Podaj nazwisko: ");
                    String nazwiskoUsuniecie = scanner.nextLine();
                    if (kadry.usunPracownika(imieUsuniecie, nazwiskoUsuniecie)) {
                        System.out.println("Pracownik usunięty.");
                    } else {
                        System.out.println("Pracownik nie został znaleziony.");
                    }
                    break;

                case 3: // Zaktualizuj pracownika
                    System.out.print("Podaj imię pracownika do aktualizacji: ");
                    String imieAktualizacji = scanner.nextLine();
                    System.out.print("Podaj nazwisko pracownika do aktualizacji: ");
                    String nazwiskoAktualizacji = scanner.nextLine();
                    System.out.print("Podaj nowe imię: ");
                    String noweImie = scanner.nextLine();
                    System.out.print("Podaj nowe nazwisko: ");
                    String noweNazwisko = scanner.nextLine();
                    System.out.print("Podaj nowy adres: ");
                    String nowyAdres = scanner.nextLine();
                    System.out.print("Podaj nowy zawód: ");
                    String nowyZawod = scanner.nextLine();
                    System.out.print("Podaj nową datę urodzenia (format: yyyy-MM-dd): ");
                    String nowaDataString = scanner.nextLine();
                    Date nowaDataUrodzenia = java.sql.Date.valueOf(nowaDataString);
                    Pracownik zaktualizowanyPracownik = new Pracownik(noweImie, noweNazwisko, nowyAdres, nowyZawod, nowaDataUrodzenia);
                    if (kadry.aktualizujPracownika(imieAktualizacji, nazwiskoAktualizacji, zaktualizowanyPracownik)) {
                        System.out.println("Dane pracownika zaktualizowane.");
                    } else {
                        System.out.println("Pracownik nie został znaleziony.");
                    }
                    break;

                case 4: // Wyświetl pracowników
                    kadry.wyswietlPracownikow();
                    break;

                case 5: // Wyszukaj po imieniu
                    System.out.print("Podaj imię: ");
                    String imieWyszukiwanie = scanner.nextLine();
                    kadry.znajdzPracownikowPoImieniu(imieWyszukiwanie).forEach(System.out::println);
                    break;

                case 6: // Wyszukaj po nazwisku
                    System.out.print("Podaj nazwisko: ");
                    String nazwiskoWyszukiwanie = scanner.nextLine();
                    kadry.znajdzPracownikowPoNazwisku(nazwiskoWyszukiwanie).forEach(System.out::println);
                    break;

                case 7: // Wyszukaj po zawodzie
                    System.out.print("Podaj zawód: ");
                    String zawodWyszukiwanie = scanner.nextLine();
                    kadry.znajdzPracownikowPoZawodzie(zawodWyszukiwanie).forEach(System.out::println);
                    break;
                case 8: //statystyki
                    Statystyka statystyki = new Statystyka(kadry.getPracownicy());
                    System.out.println("liczba pracowników: " + statystyki.liczbaPracownikow());
                    System.out.println("liczba pracowników wedle zawodu: " +statystyki.liczbaPracownikowWedlugZawodu());
                    System.out.println("średni wiek pracowników: " +statystyki.sredniWiek());
                    System.out.println("najczęstsze zawody: " +statystyki.najczestszeZawody());

                case 9: // Zapisz do pliku
                    kadry.zapiszDoPliku("firma.bin");
                    break;

                case 10: // Odczytaj z pliku
                    kadry.odczytajZPliku("firma.bin");
                    break;

                case 0: // Zakończ
                    System.out.println("Zamykanie programu...");
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        } while (wybor != 0);

        scanner.close();
    }
}
