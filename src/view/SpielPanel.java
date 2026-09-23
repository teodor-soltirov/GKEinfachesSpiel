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

    /**
     * Panel-Konstruktor zur Erstellung der GUI des Spiels
     * Beinhaltet Labels und Buttons
     * @param sc Das SpielController-Objekt
     */
    public SpielPanel(SpielController sc) {
        this.sc = sc;
        this.setLayout(new BorderLayout());
        JPanel status = new JPanel();
        status.setLayout(new GridLayout(3,  2, 10, 0));
        JLabel rErgebnis = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel gPunkte = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        ergebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        ergebnis.setEnabled(true);
        ergebnis.setBackground(Color.WHITE);
        punkte = new JLabel("30", SwingConstants.CENTER);
        punkte.setEnabled(true);
        punkte.setBackground(Color.WHITE);
        JLabel spZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        JLabel cpZahl = new JLabel("Computer:", SwingConstants.CENTER);
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
        nochmal.setPreferredSize(new Dimension(125, 20));
        JPanel buttonArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonArea.add(nochmal);
        add(buttonArea, BorderLayout.PAGE_END);
        Font font = new Font("Arial", Font.BOLD, 20);
        spielerInput.setFont(font);
        computerAnzeige.setFont(font);
        spielerInput.setHorizontalAlignment(JTextField.CENTER);
        computerAnzeige.setHorizontalAlignment(JTextField.CENTER);

    }

    /**
     * Setzt den übergebenen Parameter als Text des Textfields unter "Computer"
     * @param cpZahl - Die zufälllig erstellte Zahl für den Computer
     */
    public void setComputerZahl(int cpZahl) {
        computerAnzeige.setText("" + cpZahl);
    }

    /**
     * Setzt den übergebenen Parameter als Text des Labels unter "Rundenergebnis"
     * @param ergebnisZahl
     */
    public void setRundenErgebnis(int ergebnisZahl) {
        ergebnis.setText(String.valueOf(ergebnisZahl));
    }

    /**
     * Setzt den übergebenen Parameter als Text des Textfields unter "Gesamtpunkte"
     * @param punkteZahl
     */
    public void setGesamtPunkte(int punkteZahl) {
        punkte.setText(String.valueOf(punkteZahl));
    }

    public void setEingabeAktiviert(boolean tf) {

    }
    public void setNochEinmalAktiviert(boolean tf) {

    }

    /**
     * Setzt alle Anzeigen zurück
     */
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

    /**
     * Setzt den Textfield unter "Rundenergebnis"
     * @param error Der Übergebene Fehler (String)
     */
    public void showError(String error) {
        ergebnis.setText(error);
    }

    /**
     * Holt den Input des Benutzers
     * @return Die eingegebene Zahl
     */
    public int getInput() {
        return Integer.parseInt(spielerInput.getText());
    }
}
