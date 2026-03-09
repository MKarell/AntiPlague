package Upgrade;

import Rozgrywka.CoreGry;

public class Priorytet extends Ulepszenia{
    public Priorytet(){
        super.nazwa = "Priorytet badan leku";
        super.koszt = 30;
        super.czyAktywny = false;
        super.wspolczynnikZarazen = 0.001;
        super.wspolczynnikSmierci = 0.0001;
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
