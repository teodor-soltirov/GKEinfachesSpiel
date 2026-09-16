package model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.gesamtPunkte = 30;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() { return gesamtPunkte; }

    public int getComputerZahl() { return computerZahl; }

    public int getRundenErgebnis() { return rundenErgebnis; }

    public void berechneComputerZahl() { this.computerZahl = (int) (Math.random() * 9) + 1; }

    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) return;
        this.spielerZahl = spielerZahl;
        int diff = Math.abs(spielerZahl - this.computerZahl);
        if(diff == 0) rundenErgebnis = 20;
        else if (diff == 1) rundenErgebnis = 5;
        else rundenErgebnis = -10;
        this.gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
