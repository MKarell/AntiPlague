package Grafika;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import Rozgrywka.*;
import Upgrade.Ulepszenia;

public class Grafika extends JFrame implements Runnable {

    public Thread gra;
    public Thread grafika;
    public Virus virus;
    public CoreGry core;
    public Staty staty;
    //public List<Point> coor= new ArrayList<>();
    public static KeyStroke exit = KeyStroke.getKeyStroke("ctrl shift pressed Q");
    public Lista lista;

    public Kraj temp;

    public Grafika(Trudnosc trudnosc) {
        setTitle("AntiPlague");
        virus = new Virus(trudnosc);
        core= new CoreGry(virus);
        staty = new Staty();
//        coor.add(new Point(100,150));
//        coor.add(new Point(100,800));
//        coor.add(new Point(1500,100));
//        coor.add(new Point(1500,800));
//        ImageIcon icon = new ImageIcon("samolot1.png");
//        AnimacjaZdjec samoloty = new AnimacjaZdjec(coor,icon.getImage(),50, this);
//        new Thread(samoloty).start();
        gra = new Thread(core);
        gra.start();
        grafika = new Thread(this);
        grafika.start();
        temp = core.Chiny;

        //add(samoloty);

        JPanel p1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    super.paintComponent(g);
                    InputStream mapStream = this.getClass().getClassLoader().getResourceAsStream("MapaSwiata.jpg");
                    assert mapStream != null;
                    g.drawImage(ImageIO.read(mapStream)
                            .getScaledInstance(1585, 860, 0), 0, 50, this);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        p1.setLayout(new BorderLayout());
        p1.setPreferredSize(new Dimension(1600, 900));

        JButton usa = new KrajButton(core.Usa.getName(),275,390);
        usa.addActionListener(e -> {
            temp = core.Usa;
        });
        JButton kanada = new KrajButton(core.Kanada.getName(),245,270);
        kanada.addActionListener(e -> {
            temp = core.Kanada;
        });
        JButton chiny = new KrajButton(core.Chiny.getName(),1150,410);
        chiny.addActionListener(e -> {
            temp = core.Chiny;
        });
        JButton indie = new KrajButton(core.Indie.getName(),1030,500);
        indie.addActionListener(e -> {
            temp = core.Indie;
        });
        JButton europa = new KrajButton(core.Europa.getName(),830,330);
        europa.addActionListener(e -> {
            temp = core.Europa;
        });
        JButton australia = new KrajButton(core.Australia.getName(),1310,730);
        australia.addActionListener(e -> {
            temp = core.Australia;
        });
        JButton brazylia = new KrajButton(core.Brazylia.getName(),480,630);
        brazylia.addActionListener(e -> {
            temp = core.Brazylia;
        });
        JButton rosja = new KrajButton(core.Rosja.getName(),1110,250);
        rosja.addActionListener(e -> {
            temp = core.Rosja;
        });
        JButton afrykaPln = new KrajButton(core.AfrykaPln.getName(),790,520);
        afrykaPln.addActionListener(e -> {
            temp = core.AfrykaPln;
        });
        JButton afrykaPld = new KrajButton(core.AfrykaPld.getName(),830,610);
        afrykaPld.addActionListener(e -> {
            temp = core.AfrykaPld;
        });

        p1.add(staty);
        p1.add(usa);
        p1.add(kanada);
        p1.add(chiny);
        p1.add(indie);
        p1.add(europa);
        p1.add(australia);
        p1.add(brazylia);
        p1.add(rosja);
        p1.add(afrykaPln);
        p1.add(afrykaPld);

        setContentPane(p1);
        setSize(1600, 950);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(e -> {
            KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
            if (exit.equals(keyStroke)) {
                grafika.interrupt();
                gra.interrupt();
                this.dispose();
                new Menu();
            }
            return false;
        });
    }

    @Override
    public void run() {
        do {
            staty.lek.setValue(CoreGry.postepLeku);
            staty.aktualizacjaStaty(temp,core.liczbaZarazeni(),core.liczbaSmierci(),core.liczbaWyzdrowieni());
            this.repaint();
            staty.repaint();
            staty.panelUlepszen.odswiez();;

            if(staty.lek.getMaximum() <= CoreGry.postepLeku && CoreGry.postepLeku <= staty.lek.getMaximum()+ Ulepszenia.wspol){
                CoreGry.wspolczynnikWyzdrowienia += 5;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(gra.isAlive());
        if(core.liczbaZarazeni() == core.liczbaLudzi)
            System.out.println("Przegrales");
        else {
            Lista lista = new Lista("src/Wyniki.txt");

            JDialog dialog = new JDialog((Frame) null, "Pokonales zaraze", true);
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 150);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);

            JTextField poleTekstowe = new JTextField();
            JLabel etykieta = new JLabel("Podaj nick", SwingConstants.CENTER);
            JButton przyciskOk = new JButton("OK");
            JPanel panelPrzyciskow = new JPanel();
            panelPrzyciskow.add(przyciskOk);

            dialog.add(etykieta, BorderLayout.NORTH);
            dialog.add(poleTekstowe, BorderLayout.CENTER);
            dialog.add(panelPrzyciskow, BorderLayout.SOUTH);
            System.out.println(CoreGry.dni);

            przyciskOk.addActionListener(e->{
                if(!poleTekstowe.getText().isEmpty()) {
                    lista.dodajWynik("Dzien: " + CoreGry.dni + " | Nick: " + poleTekstowe.getText() + " |Wynik: " + core.liczbaWyzdrowieni());
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
        }
        System.exit(0);
    }
}