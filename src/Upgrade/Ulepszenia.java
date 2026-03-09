package Upgrade;

public abstract class Ulepszenia {
    public String nazwa;
    public int koszt;
    public double wspolczynnikZarazen;
    public double wspolczynnikSmierci;
    public double wspolczynnikWyzdrowien;
    public boolean czyAktywny;
    public static int wspol = 1;

    public abstract void aktywacja();
}
