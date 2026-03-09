package Upgrade;

import Rozgrywka.CoreGry;

public class Kwarantanna extends Ulepszenia{

    public Kwarantanna(){
        super.nazwa = "Kwarantanna";
        super.koszt = 25;
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
