package controller;
import model.GewinnModel;
import view.SpielFrame;
import view.SpielPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Enthält die main-Methode
 */
public class SpielController implements ActionListener {
    private GewinnModel gModel;
    private SpielPanel sp;

    /**
     * Deklariert und Initialisiert ein neues Model- Panel- und Frameobjekt.
     */
    public SpielController() {
        this.gModel = new GewinnModel();
        this.sp = new SpielPanel(this);
        SpielFrame sf = new SpielFrame(sp);
    }

    /**
     * Behandlet die Inputs des Users (Enter, Klick des Buttons)
     * @param e Das ausgelöste Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ENTER")) {
            int spielerZahl = 0;

            try {
                spielerZahl = sp.getInput();
            } catch (NumberFormatException exc) {
                sp.showError("Bitte eine Zahl von 1-9 eingeben");
                return;
            }

            if(spielerZahl < 1 || spielerZahl > 9) {
                sp.showError("Bitte eine Zahl von 1-9 eingeben");
                return;
            }

            gModel.berechneComputerZahl();
            gModel.berechneRunde(spielerZahl);
            sp.setComputerZahl(gModel.getComputerZahl());
            sp.setRundenErgebnis(gModel.getRundenErgebnis());
            sp.setGesamtPunkte(gModel.getGesamtPunkte());

            if (gModel.getRundenErgebnis() > 0) {
                sp.setLabelFarbe(Color.GREEN);
            } else if (gModel.getRundenErgebnis() < 0) {
                sp.setLabelFarbe(Color.RED);
            } else {
                sp.setLabelFarbe(Color.WHITE);
            }

            sp.setEingabeAktiviert(false);
            sp.setNochEinmalAktiviert(true);
        }
        if(e.getActionCommand().equals("AGAIN")) {
            sp.resetRunde();
            sp.setEingabeAktiviert(true);
            sp.setNochEinmalAktiviert(false);
        }
    }

    public static void main(String[] args) {
         new SpielController();
    }

}
