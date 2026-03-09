package Grafika;

import javax.swing.*;
import java.awt.*;

public class KrajButton extends JButton {

    public KrajButton(String name, int x, int y) {
        super(name);
        setFont(new Font("TimesRoman", Font.BOLD, 14));
        setBounds(x,y, 100, 30);
        setForeground(Color.WHITE);
        setBackground(new Color(247, 107, 0));
        setContentAreaFilled(false);
        setOpaque(true);
    }
}
