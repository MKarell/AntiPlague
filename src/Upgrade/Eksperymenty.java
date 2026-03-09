package Upgrade;

import Rozgrywka.CoreGry;

public class Eksperymenty extends Ulepszenia{
    public Eksperymenty() {
        super.nazwa = "Eksperymanty z lekiem";
        super.koszt = 25;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.001;
        super.wspolczynnikSmierci = 0.001;
        super.wspolczynnikWyzdrowien = 0.001;
    }

    @Override
    public void aktywacja() {
        czyAktywny = true;
        CoreGry.wspolczynnikSmierci -= wspolczynnikSmierci;
        CoreGry.wspolczynnikZarazania -= wspolczynnikZarazen;
        CoreGry.wspolczynnikWyzdrowienia += wspolczynnikWyzdrowien;
        wspol += 1;
    }
}
