package Upgrade;

import Rozgrywka.CoreGry;

public class PromowanieHigieny extends Ulepszenia{
    public PromowanieHigieny() {
        super.nazwa = "Promowanie higieny";
        super.koszt = 20;
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
    }
}
