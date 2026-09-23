package view;
import controller.SpielController;
import javax.swing.*;
import java.awt.*;

/**
 * Enthält die Panelklasse
 * @author Teodor Soltirov
 * @version 2026-09-25
 */
public class SpielPanel extends JPanel {
    private JLabel ergebnis, punkte;
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
        ergebnis = new JLabel("Tippe eine Zahl von 1 bis 9");
        ergebnis.setEnabled(false);
        ergebnis.setBackground(Color.WHITE);
        punkte = new JLabel("30");
        punkte.setEnabled(false);
        punkte.setBackground(Color.WHITE);
        JLabel spZahl = new JLabel("Deine Zahl:");
        JLabel cpZahl = new JLabel("Computer:");
        cpZahl.setEnabled(true);
        status.add(rErgebnis);
        status.add(gPunkte);
        status.add(ergebnis);
        status.add(punkte);
        status.add(spZahl);
        status.add(cpZahl);

        add(status, BorderLayout.PAGE_START);
        JPanel inputArea = new JPanel();
        inputArea.setLayout(new GridLayout(1, 2, 20, 10));
        spielerInput = new JTextField();
        spielerInput.addActionListener(sc);
        spielerInput.setActionCommand("ENTER");
        computerAnzeige = new JTextField();
        computerAnzeige.setEditable(false);
        inputArea.add(spielerInput);
        inputArea.add(computerAnzeige);
        add(inputArea, BorderLayout.CENTER);
        nochmal = new JButton("Noch einmal!");
        nochmal.setEnabled(true);
        nochmal.addActionListener(sc);
        nochmal.setActionCommand("AGAIN");
        add(nochmal, BorderLayout.PAGE_END);
    }

    public void setComputerZahl(int cpZahl) {
        computerAnzeige.setText("" + cpZahl);
    }
    public void setRundenErgebnis(int ergebnisZahl) {
        ergebnis.setText(String.valueOf(ergebnisZahl));
    }
    public void setGesamtPunkte(int punkteZahl) {
        punkte.setText(String.valueOf(punkteZahl));
    }
    public void setEingabeAktiviert(boolean tf) {

    }
    public void setNochEinmalAktiviert(boolean tf) {

    }
    public void resetRunde() {
        spielerInput.setText("");
        computerAnzeige.setText("");
        ergebnis.setText("Tippe eine Zahl von 1 bis 9");
    }
    public void setAgainAktiviert() {

    }
    public void setInputAktiviert() {

    }
    public void setStatus(String anzeige) {

    }
    public void showError(String error) {
        ergebnis.setText(error);
    }
    public int getInput() {
        return Integer.parseInt(spielerInput.getText());
    }
}
