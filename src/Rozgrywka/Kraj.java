package Rozgrywka;

public class Kraj {
    private final String name;
    private final int iloscLudzi;
    private double zarazeni;
    private double wyzdrowieni;
    private double smierc;
    private final int liczbaLotnisk;
    private final int liczbaPortow;
    private boolean czyLotniskaOtwarte;
    private boolean czyPortowOtwarte;
    private boolean czyZarazone;

    public Kraj(String name, int iloscLudzi, int liczbaLotnisk, int liczbaPortow) {
        this.name = name;
        this.iloscLudzi = iloscLudzi;
        this.liczbaLotnisk = liczbaLotnisk;
        this.liczbaPortow = liczbaPortow;
        zarazeni = 0;
        wyzdrowieni = 0;
        smierc = 0;
        czyLotniskaOtwarte = true;
        czyPortowOtwarte = true;
        czyZarazone = false;
    }
    public boolean getCzyZarazone() {
        return czyZarazone;
    }

    public void setCzyZarazone(boolean czyZarazone) {
        this.czyZarazone = czyZarazone;
    }

    public String getName() {
        return name;
    }

    public int getIloscLudzi() {
        return iloscLudzi;
    }

    public double getZarazeni() {
        return zarazeni;
    }

    public double getWyzdrowieni() {
        return wyzdrowieni;
    }

    public double getSmierc() {
        return smierc;
    }

    public int getLiczbaLotnisk() {
        return liczbaLotnisk;
    }

    public int getLiczbaPortow() {
        return liczbaPortow;
    }

    public boolean isCzyLotniskaOtwarte() {
        return czyLotniskaOtwarte;
    }

    public boolean isCzyPortowOtwarte() {
        return czyPortowOtwarte;
    }

    public void setZarazeni(double zarazeni) {
        if(zarazeni>(double) this.iloscLudzi-this.wyzdrowieni-this.smierc) {
            this.zarazeni = (double)this.iloscLudzi-this.wyzdrowieni-this.smierc;
        }else {
            this.zarazeni = zarazeni;
        }
    }

    public void setWyzdrowieni(double wyzdrowieni) {
            this.wyzdrowieni = wyzdrowieni;
    }

    public void setSmierc(double smierc) {
            this.smierc = smierc;
    }

    public void setCzyLotniskaOtwarte(boolean czyLotniskaOtwarte) {
        this.czyLotniskaOtwarte = czyLotniskaOtwarte;
    }

    public void setCzyPortowOtwarte(boolean czyPortowOtwarte) {
        this.czyPortowOtwarte = czyPortowOtwarte;
    }
}