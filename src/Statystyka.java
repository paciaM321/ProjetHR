import java.util.*;
import java.util.stream.Collectors;

public class Statystyka {
    private List<Pracownik> pracownicy;

    public Statystyka(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public int liczbaPracownikow() {
        return pracownicy.size();
    }

    public Map<String, Long> liczbaPracownikowWedlugZawodu() {
        return pracownicy.stream()
                .collect(Collectors.groupingBy(Pracownik::getZawod, Collectors.counting()));
    }

    public double sredniWiek() {
        Date teraz = new Date();
        return pracownicy.stream()
                .mapToLong(p -> (teraz.getTime() - p.getDataUrodzenia().getTime()) / (1000L * 60 * 60 * 24 * 365))
                .average()
                .orElse(0);
    }

    public List<String> najczestszeZawody() {
        Map<String, Long> zawodCount = liczbaPracownikowWedlugZawodu();
        long max = zawodCount.values().stream().mapToLong(v -> v).max().orElse(0);
        return zawodCount.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}