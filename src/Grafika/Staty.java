package Grafika;

import Rozgrywka.CoreGry;
import Rozgrywka.Kraj;

import javax.swing.*;
import java.awt.*;

public class Staty extends JPanel {
    public JButton ulepszenia = new JButton();
    public JLabel statystykiGlobalne = new JLabel();
    public JLabel statystykiKraju = new JLabel();
    public JProgressBar lek = new JProgressBar();
    public PanelUlepszen panelUlepszen;

    public void aktualizacjaStaty(Kraj k,double z,double s,double w) {
        ulepszenia.setText("Ulepszenia, liczba punktow: " + CoreGry.punkty);
        statystykiGlobalne.setText("Dni: " + CoreGry.dni + "     Globalne: Zarazeni:"+ (long)z + " /Smierci:" + (long)s +" /Wyzdrowieni: " + (long)w);
        statystykiKraju.setText(k.getName() +": Zarazeni:"+ (long)k.getZarazeni() + " /Smierc:" + (long)k.getSmierc() +" /Wyzdrowieni: " + (long)k.getWyzdrowieni());
    }

    public Staty() {
        setSize(1600, 50);
        setLayout(null);
        setDoubleBuffered(true);
        panelUlepszen = new PanelUlepszen();

        ulepszenia.setBackground(Color.CYAN);
        ulepszenia.setBorder(null);
        ulepszenia.setOpaque(true);
        ulepszenia.setFocusPainted(false);
        ulepszenia.setBounds(0,5,200,40);
        statystykiGlobalne.setBounds(210,5,500,40);
        statystykiKraju.setBounds(720,5,400,40);
        lek.setBounds(1130,0,470,50);

        lek.setValue(CoreGry.postepLeku);
        lek.setStringPainted(true);
        lek.setString("Postęp leku");
        lek.setMaximum(1000);

        ulepszenia.addActionListener(e -> {
            panelUlepszen.odswiez();
            panelUlepszen.setVisible(true);
        });

        add(ulepszenia);
        add(statystykiGlobalne);
        add(statystykiKraju);
        add(lek);
        setVisible(true);
        setOpaque(true);
    }
}
