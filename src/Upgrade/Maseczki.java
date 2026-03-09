package Upgrade;

import Rozgrywka.CoreGry;

public class Maseczki extends Ulepszenia{
    public Maseczki(){
        super.nazwa = "Obowiazek maseczek";
        super.koszt = 10;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.01;
        super.wspolczynnikSmierci = 0;
        super.wspolczynnikWyzdrowien = 0.0001;
    }

    @Override
    public void aktywacja() {
        czyAktywny = true;
        CoreGry.wspolczynnikSmierci -= wspolczynnikSmierci;
        CoreGry.wspolczynnikZarazania -= wspolczynnikZarazen;
        CoreGry.wspolczynnikWyzdrowienia += wspolczynnikWyzdrowien;
    }
}
