package Rozgrywka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lista {

    private final String sciezkaPliku;

    public Lista(String sciezkaPliku) {
        this.sciezkaPliku = sciezkaPliku;
    }

    public List<String> wczytajWyniki() {
        List<String> wyniki = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sciezkaPliku))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                wyniki.add(linia);
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania wyników: " + e.getMessage());
        }
        return wyniki;
    }

    public void dodajWynik(String wynik) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaPliku, true))) {
            writer.write(wynik);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Błąd podczas dodawania wyniku: " + e.getMessage());
        }
    }
}
