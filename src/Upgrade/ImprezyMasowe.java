package Upgrade;

import Rozgrywka.CoreGry;

public class ImprezyMasowe extends Ulepszenia {

    public ImprezyMasowe() {
        super.nazwa = "Zakaz imprez masowych";
        super.koszt = 15;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.001;
        super.wspolczynnikSmierci = 0.0001;
        super.wspolczynnikWyzdrowien = 0.01;
    }

    @Override
    public void aktywacja() {
        czyAktywny = true;
        CoreGry.wspolczynnikSmierci -= wspolczynnikSmierci;
        CoreGry.wspolczynnikZarazania -= wspolczynnikZarazen;
        CoreGry.wspolczynnikWyzdrowienia += wspolczynnikWyzdrowien;
    }
}