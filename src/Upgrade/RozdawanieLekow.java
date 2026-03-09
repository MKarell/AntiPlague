package Upgrade;

import Rozgrywka.CoreGry;

public class RozdawanieLekow  extends Ulepszenia{
    public RozdawanieLekow(){
        super.nazwa = "Rozrzucanie leków";
        super.koszt = 20;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.01;
        super.wspolczynnikSmierci = 0.001;
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