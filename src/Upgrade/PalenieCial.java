package Upgrade;

import Rozgrywka.CoreGry;

public class PalenieCial extends Ulepszenia{
    public PalenieCial() {
        super.nazwa = "Spal ciala zmarlych";
        super.koszt = 35;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.01;
        super.wspolczynnikSmierci = 0;
        super.wspolczynnikWyzdrowien = 0;
    }

    @Override
    public void aktywacja() {
        czyAktywny = true;
        CoreGry.wspolczynnikSmierci -= wspolczynnikSmierci;
        CoreGry.wspolczynnikZarazania -= wspolczynnikZarazen;
        CoreGry.wspolczynnikWyzdrowienia += wspolczynnikWyzdrowien;
    }
}
