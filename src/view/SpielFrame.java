package view;
import javax.swing.*;
import java.awt.*;

public class SpielFrame extends JFrame {
    public SpielFrame(JPanel p) {
        super("Zahlen-Gewinnspiel(V1.0)");
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(800, 400, 400, 250);
        this.setVisible(true);
    }
}
