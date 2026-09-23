package controller;
import model.GewinnModel;
import view.SpielFrame;
import view.SpielPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpielController implements ActionListener {
    private GewinnModel gModel;
    private SpielPanel sp;
    public SpielController() {
        this.gModel = new GewinnModel();
        this.sp = new SpielPanel();
        SpielFrame sf = new SpielFrame(sp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ENTER")) {
            int spielerZahl = 0;

            try {
                spielerZahl = Integer.parseInt(sp.getInput).trim();
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
            sp.setEingabeAktiviert(false);
            sp.setNochEinmalAktiviert(true);

            if(model.hatGewonnen()) sp.setStatus("Gewonnen");
            else if(gModel.hatVerloren()) sp.setStatus("Verloren");
        }
        if(e.getActionCommand().equals("AGAIN")) {
            sp.resetRunde();
            sp.setAgainAktiviert(false);
            sp.setInputAktiviert(true);
        }
    }

    public static void main(String[] args) {
         new SpielController();
    }

}
