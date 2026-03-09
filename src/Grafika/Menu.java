package Grafika;

import Rozgrywka.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Menu extends JFrame {

    public Menu() {

        setTitle("Anti Plague");
        JButton nowaGra = new JButton("Nowa gra");
        JButton wyjscie = new JButton("Wyjscie");
        JButton tablica = new JButton("Tablica");

        JButton latwy = new JButton("Latwy");
        JButton sredni = new JButton("Sredni");
        JButton trudny = new JButton("Trudny");

        latwy.setFont(new Font("TimesRoman", Font.BOLD, 20));
        latwy.setBounds(50,50, 200, 50);
        latwy.setForeground(Color.WHITE);
        latwy.setBackground(Color.GREEN);
        latwy.setContentAreaFilled(false);
        latwy.setOpaque(true);
        latwy.setVisible(false);

        sredni.setFont(new Font("TimesRoman", Font.BOLD, 20));
        sredni.setBounds(50,110, 200, 50);
        sredni.setForeground(Color.WHITE);
        sredni.setBackground(Color.BLUE);
        sredni.setContentAreaFilled(false);
        sredni.setOpaque(true);
        sredni.setVisible(false);

        trudny.setFont(new Font("TimesRoman", Font.BOLD, 20));
        trudny.setBounds(50,170, 200, 50);
        trudny.setForeground(Color.WHITE);
        trudny.setBackground(Color.GRAY);
        trudny.setContentAreaFilled(false);
        trudny.setOpaque(true);
        trudny.setVisible(false);

        nowaGra.setFont(new Font("TimesRoman", Font.BOLD, 20));
        nowaGra.setBounds(50,50, 200, 50);
        nowaGra.setForeground(Color.WHITE);
        nowaGra.setBackground(Color.GREEN);
        nowaGra.setContentAreaFilled(false);
        nowaGra.setOpaque(true);

        tablica.setFont(new Font("TimesRoman", Font.BOLD, 20));
        tablica.setBounds(50,110, 200, 50);
        tablica.setForeground(Color.WHITE);
        tablica.setBackground(Color.BLUE);
        tablica.setContentAreaFilled(false);
        tablica.setOpaque(true);

        wyjscie.setFont(new Font("TimesRoman", Font.BOLD, 20));
        wyjscie.setBounds(50,170, 200, 50);
        wyjscie.setForeground(Color.WHITE);
        wyjscie.setBackground(Color.GRAY);
        wyjscie.setContentAreaFilled(false);
        wyjscie.setOpaque(true);

        JPanel buttonPane = new JPanel();

        buttonPane.setBackground(Color.RED);
        buttonPane.add(nowaGra);
        buttonPane.add(tablica);
        buttonPane.add(wyjscie);

        buttonPane.add(latwy);
        buttonPane.add(sredni);
        buttonPane.add(trudny);

        buttonPane.setLayout(null);
        add(buttonPane);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);

        nowaGra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nowaGra.setVisible(false);
                tablica.setVisible(false);
                wyjscie.setVisible(false);
                latwy.setVisible(true);
                sredni.setVisible(true);
                trudny.setVisible(true);
            }
        });
        tablica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame oknoWynikow = new JFrame("Wyniki");
                oknoWynikow.setSize(400, 300);
                oknoWynikow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Lista wynikiPlik = new Lista("src/Wyniki.txt");
                java.util.List<String> wyniki = wynikiPlik.wczytajWyniki();
                String[] wynikiArray = wyniki.toArray(new String[0]);
                JList<String> listaWynikow = new JList<>(wynikiArray);
                JScrollPane scrollPane = new JScrollPane(listaWynikow);
                oknoWynikow.add(scrollPane);
                oknoWynikow.setVisible(true);
                oknoWynikow.setLocationRelativeTo(null);
            }
        });
        wyjscie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });

        latwy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Grafika(Trudnosc.LATWY);
                setVisible(false);
            }
        });

        sredni.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Grafika(Trudnosc.SREDNI);
                setVisible(false);
            }
        });

        trudny.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Grafika(Trudnosc.TRUDNY);
                setVisible(false);
            }
        });
    }
}