package Grafika;

import Rozgrywka.CoreGry;
import Upgrade.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static Rozgrywka.CoreGry.punkty;


public class PanelUlepszen extends JDialog {
    private final Map<String, Ulepszenia> mapaUlepszen = new HashMap<>();
    public PanelUlepszen() {
        Ulepszenia kwarantanna = new Kwarantanna();
        Ulepszenia eksperymenty = new Eksperymenty();
        Ulepszenia priorytet = new Priorytet();
        Ulepszenia maseczki = new Maseczki();
        Ulepszenia hospitalizacja = new Hospitalizacja();
        Ulepszenia leki = new RozdawanieLekow();
        Ulepszenia imprezy = new ImprezyMasowe();
        Ulepszenia palenie = new PalenieCial();
        Ulepszenia higiena = new PromowanieHigieny();

        mapaUlepszen.put(kwarantanna.nazwa, kwarantanna);
        mapaUlepszen.put(eksperymenty.nazwa, eksperymenty);
        mapaUlepszen.put(priorytet.nazwa, priorytet);
        mapaUlepszen.put(maseczki.nazwa, maseczki);
        mapaUlepszen.put(hospitalizacja.nazwa, hospitalizacja);
        mapaUlepszen.put(leki.nazwa, leki);
        mapaUlepszen.put(imprezy.nazwa, imprezy);
        mapaUlepszen.put(palenie.nazwa, palenie);
        mapaUlepszen.put(higiena.nazwa, higiena);

        JButton button1 = new JButton(kwarantanna.nazwa + " |koszt: " + kwarantanna.koszt);
        JButton button2 = new JButton(eksperymenty.nazwa + " |koszt: " + eksperymenty.koszt);
        JButton button3 = new JButton(maseczki.nazwa + " |koszt: " + maseczki.koszt);
        JButton button4 = new JButton(priorytet.nazwa + " |koszt: " + priorytet.koszt);
        JButton button5 = new JButton(hospitalizacja.nazwa + " |koszt: " + hospitalizacja.koszt);
        JButton button6 = new JButton(leki.nazwa + " |koszt: " + leki.koszt);
        JButton button7 = new JButton(imprezy.nazwa + " |koszt: " + imprezy.koszt);
        JButton button8 = new JButton(palenie.nazwa + " |koszt: " + palenie.koszt);
        JButton button9 = new JButton(higiena.nazwa + " |koszt: " + higiena.koszt);

        button1.setFont(new Font("Arial", Font.BOLD, 12));
        button2.setFont(new Font("Arial", Font.BOLD, 12));
        button3.setFont(new Font("Arial", Font.BOLD, 12));
        button4.setFont(new Font("Arial", Font.BOLD, 12));
        button5.setFont(new Font("Arial", Font.BOLD, 12));
        button6.setFont(new Font("Arial", Font.BOLD, 12));
        button7.setFont(new Font("Arial", Font.BOLD, 12));
        button8.setFont(new Font("Arial", Font.BOLD, 12));
        button9.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setText("Punkty: " + punkty);

        button1.addActionListener(e -> aktywujUlepszenie(kwarantanna, button1));
        button2.addActionListener(e -> aktywujUlepszenie(eksperymenty, button2));
        button3.addActionListener(e -> aktywujUlepszenie(maseczki, button3));
        button4.addActionListener(e -> aktywujUlepszenie(priorytet, button4));
        button5.addActionListener(e -> aktywujUlepszenie(hospitalizacja, button5));
        button6.addActionListener(e -> aktywujUlepszenie(leki, button6));
        button7.addActionListener(e -> aktywujUlepszenie(imprezy, button7));
        button8.addActionListener(e -> aktywujUlepszenie(palenie, button8));
        button9.addActionListener(e -> aktywujUlepszenie(leki, button9));

        JPanel panel = new JPanel();
        setTitle("Ulepszenia");
        panel.setLayout(new GridLayout(5, 1));
        setContentPane(panel);
        setModal(true);
        setSize(500,300);
        setLocationRelativeTo(null);

        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
    }

    public void odswiez() {
        JLabel label = (JLabel) getContentPane().getComponent(0);
        label.setText("Punkty: " + CoreGry.punkty);

        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;

                String nazwaUlepszenia = button.getText().split(" \\|")[0];
                Ulepszenia ulepszenie = znajdzUlepszeniePoNazwie(nazwaUlepszenia);

                if (ulepszenie != null) {
                    button.setEnabled(!ulepszenie.czyAktywny);
                    if (ulepszenie.czyAktywny) {
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(CoreGry.punkty >= ulepszenie.koszt);
                    }
                }
            }
        }
        repaint();
        revalidate();
    }

    private void aktywujUlepszenie(Ulepszenia ulepszenie, JButton button) {
        if (CoreGry.punkty >= ulepszenie.koszt && !ulepszenie.czyAktywny) {
            ulepszenie.aktywacja();
            CoreGry.punkty -= ulepszenie.koszt;
            button.setEnabled(false);
            odswiez();
        }
    }

    private Ulepszenia znajdzUlepszeniePoNazwie(String nazwa) {
        return mapaUlepszen.getOrDefault(nazwa, null);
    }
}
