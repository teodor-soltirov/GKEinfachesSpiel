package view;
import controller.SpielController;
import javax.swing.*;
import java.awt.*;

public class SpielPanel extends JPanel {
    private JTextField ergebnis, punkte;
    private JButton nochmal;
    private SpielController sc;
    private JTextField spielerInput, computerAnzeige;

    public SpielPanel(SpielController sc) {
        this.sc = sc;
        this.setLayout(new BorderLayout());
        JPanel status = new JPanel();
        status.setLayout(new GridLayout(3,  2, 10, 0));
        JLabel rErgebnis = new JLabel("Rundenergebnis:");
        JLabel gPunkte = new JLabel("Gesamtpunkte:");
        ergebnis = new JTextField("Tippe eine Zahl von 1 bis 9");
        ergebnis.setEnabled(false);
        punkte = new JTextField("30");
        JLabel spZahl = new JLabel("Deine Zahl:");
        JLabel cpZahl = new JLabel("Computer:");
        cpZahl.setEnabled(false);
        status.add(ergebnis);
        status.add(gPunkte);
        status.add(rErgebnis);
        status.add(punkte);
        status.add(spZahl);
        status.add(cpZahl);

        add(status, BorderLayout.PAGE_START);
        JPanel inputArea = new JPanel();
        inputArea.setLayout(new GridLayout(1, 2, 20, 10));
        spielerInput = new JTextField();
        computerAnzeige = new JTextField();
        inputArea.add(spielerInput);
        inputArea.add(computerAnzeige);
        add(inputArea, BorderLayout.CENTER);
        nochmal = new JButton("Noch einmal!");
        nochmal.setEnabled(false);
        nochmal.addActionListener(sc);
        nochmal.setActionCommand("NOCHMAL");
        add(nochmal, BorderLayout.PAGE_END);
    }
}
