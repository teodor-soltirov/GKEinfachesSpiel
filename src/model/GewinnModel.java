package model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.spielerZahl = 30;
        this.computerZahl = 0;
        this.gesamtPunkte = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() { return gesamtPunkte; }

    public int getComputerZahl() { return computerZahl; }

    public int getRundenErgebnis() { return rundenErgebnis; }

    public void berechneComputerZahl() { this.computerZahl = (int) (Math.random() * 9) + 1; }

    public void berechneRunde(int spielerZahl) {

    }

    public boolean hatGewonnen() {

        return true;
    }

    public boolean hatVerloren() {

        return true;
    }
}
