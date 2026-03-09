package Rozgrywka;

import Upgrade.Priorytet;
import Upgrade.Ulepszenia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoreGry implements Runnable {
    public final long liczbaLudzi;
    public Virus virus;
    public List<Kraj> kraje = new ArrayList<>();

    public static double wspolczynnikZarazania = 0;
    public static double wspolczynnikSmierci = 0;
    public static double wspolczynnikWyzdrowienia = 0.0000001;
    public static int postepLeku = 0;
    public static int punkty = 5;
    public static int dni = 0;

    public Kraj Usa = new Kraj("Usa", 490_000_000, 10, 10);
    public Kraj Chiny = new Kraj("Chiny", 1_200_000_000, 10, 10);
    public Kraj Indie = new Kraj("Indie", 1_200_000_000, 10, 10);
    public Kraj Kanada = new Kraj("Kanada", 200_000_000, 10, 10);
    public Kraj Brazylia =  new Kraj("Brazylia", 300_000_000, 10, 10);
    public Kraj Australia = new Kraj("Australia", 200_000_000, 10, 10);
    public Kraj Europa = new Kraj("Europa", 500_000_000, 10, 10);
    public Kraj Rosja = new Kraj("Rosja", 300_000_000, 10, 10);
    public Kraj AfrykaPln = new Kraj("AfrykaPln", 680_000_000, 10, 10);
    public Kraj AfrykaPld = new Kraj("AfrykaPld", 680_000_000, 10, 10);

    public CoreGry(Virus virus) {
        this.virus = virus;

        kraje.add(Usa);
        kraje.add(Chiny);
        kraje.add(Indie);
        kraje.add(Kanada);
        kraje.add(Brazylia);
        kraje.add(Australia);
        kraje.add(Europa);
        kraje.add(Rosja);
        kraje.add(AfrykaPln);
        kraje.add(AfrykaPld);

        wspolczynnikZarazania += virus.wspolczynnikZarazania;
        wspolczynnikSmierci += virus.wpsolczynnikSmierci;

        Chiny.setZarazeni(1000);
        Chiny.setCzyZarazone(true);
        liczbaLudzi = liczbaLudzi();
    }

    @Override
    public void run() {
        Random r = new Random();
        do{
            if( r.nextDouble(1) > virus.mutacje)
                virus.mutacja();
            if( r.nextDouble(1) > 0.75)
                punkty+=1;

            zarazanie();
            czyZarazicKraj();
            usmiercanie();
            uzdrawianie();

            postepLeku+= Ulepszenia.wspol;
            dni++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(liczbaZarazeni() > 1);
    }

    private long liczbaLudzi() {
        long liczba = 0;
        for (Kraj kraj : kraje) {
            liczba += kraj.getIloscLudzi();
        }
        return liczba;
    }

    public double liczbaZarazeni() {
        double liczba = 0;
        for (Kraj kraj : kraje) {
            liczba += kraj.getZarazeni();
        }
        return liczba;
    }

    public double liczbaSmierci() {
        double liczba = 0;
        for (Kraj kraj : kraje) {
            liczba += kraj.getSmierc();
        }
        return liczba;
    }

    public double liczbaWyzdrowieni() {
        double liczba = 0;
        for (Kraj kraj : kraje) {
            liczba += kraj.getWyzdrowieni();
        }
        return liczba;
    }

    private void czyZarazicKraj(){
        Random rand = new Random();
        double temp2;
        for (int i=0; i<kraje.size(); i++) {
            temp2 = rand.nextDouble(1);
            if(!kraje.get(i).getCzyZarazone() && temp2<0.1)
            {
                kraje.get(i).setCzyZarazone(true);
                kraje.get(i).setZarazeni(rand.nextDouble(20)+10);
            }
        }
    }

    private void zarazanie() {
        Random rand = new Random();
        double temp;
        for(Kraj kraj : kraje) {
            if(kraj.getCzyZarazone()){
                temp = kraj.getZarazeni() + kraj.getZarazeni()*wspolczynnikZarazania*(rand.nextDouble(0.3)+0.85)/10;
                kraj.setZarazeni(temp);
            }
        }
    }

    private void uzdrawianie(){
        Random rand = new Random();
        double temp;
        for(Kraj kraj : kraje) {
            temp = kraj.getZarazeni() * (rand.nextDouble(0.2) + 0.95) * wspolczynnikWyzdrowienia / 100;
            kraj.setWyzdrowieni(kraj.getWyzdrowieni() + temp);
            kraj.setZarazeni(kraj.getZarazeni()-temp);
        }
    }

    private void usmiercanie(){
        Random rand = new Random();
        double temp;
        for(Kraj kraj : kraje) {
            temp = kraj.getZarazeni() * (rand.nextDouble(0.2) + 0.95)*wspolczynnikSmierci/100 ;
            kraj.setSmierc(kraj.getSmierc() + temp);
            kraj.setZarazeni(kraj.getZarazeni()-temp);
        }
    }
}