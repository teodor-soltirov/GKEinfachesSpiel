package view;
import javax.swing.*;
import java.awt.*;

/**
 * Frame-Klasse
 */
public class SpielFrame extends JFrame {

    /**
     * SpielFrame-Konstruktor, nutzt die Methoden aus JFrame um
     * das Frame einszustellen.
     * @param p Das übergebene Panelobjekt
     */
    public SpielFrame(JPanel p) {
        super("Zahlen-Gewinnspiel V2.0");
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(800, 400, 400, 250);
        this.setVisible(true);
    }
}
