package Rozgrywka;

public class Virus {
    public double mutacje;
    public double wspolczynnikZarazania;
    public double wpsolczynnikSmierci;
    public double szansaSamolot;
    public double szansaStatek;
    public int ileSamolot;
    public int ileStatek;
    public boolean czyAktywny;

    public Virus (Trudnosc trudnosc) {
        czyAktywny = true;
        if(trudnosc == Trudnosc.LATWY){
            mutacje = 0.9;
            wspolczynnikZarazania = 1.01;
            wpsolczynnikSmierci = 1.001;
            szansaSamolot = 0.1;
            szansaStatek = 0.1;
            ileSamolot = 5;
            ileStatek = 5;
        } else if (trudnosc == Trudnosc.SREDNI) {
            mutacje = 0.8;
            wspolczynnikZarazania = 1.05;
            wpsolczynnikSmierci = 1.005;
            szansaSamolot = 0.2;
            szansaStatek = 0.2;
            ileSamolot = 10;
            ileStatek = 10;
        } else if (trudnosc == Trudnosc.TRUDNY) {
            mutacje = 0.7;
            wspolczynnikZarazania = 1.1;
            wpsolczynnikSmierci = 1.01;
            szansaSamolot = 0.3;
            szansaStatek = 0.3;
            ileSamolot = 15;
            ileStatek = 15;
        }
    }

    public void mutacja(){
        CoreGry.wspolczynnikZarazania *= wspolczynnikZarazania;
        CoreGry.wspolczynnikSmierci *= wpsolczynnikSmierci;
    }
}