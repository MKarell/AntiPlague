package Upgrade;

import Rozgrywka.CoreGry;

public class Hospitalizacja  extends Ulepszenia{

    public Hospitalizacja(){
        super.nazwa = "Hospitalizacja";
        super.koszt = 25;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.01;
        super.wspolczynnikSmierci = 0.01;
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
