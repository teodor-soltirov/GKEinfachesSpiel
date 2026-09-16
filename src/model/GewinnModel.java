package model;

/**
 * Enthält die Spielelogik
 * @author Teodor Soltirov
 * @version 2026-09-16
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    /**
     * Parameterloser Konstruktor, Spiel beginnt mit 30 Punkten
     */
    public GewinnModel() {
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.gesamtPunkte = 30;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() { return gesamtPunkte; }

    public int getComputerZahl() { return computerZahl; }

    public int getRundenErgebnis() { return rundenErgebnis; }

    /**
     * Generiert eine zufällige Zahl zwischen 1 und 9 (inkl. 1 und 9) für den Computer
     */
    public void berechneComputerZahl() { this.computerZahl = (int) (Math.random() * 9) + 1; }

    /**
     * Überprüft die Eingabe des Spielers und berechnet die Differenz von der Zahl des Computers
     * @param spielerZahl - Der Guess des Spielers (erlaubt 1 - 9) (inkl. 1 und 9)
     */
    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) return;
        this.spielerZahl = spielerZahl;
        int diff = Math.abs(spielerZahl - this.computerZahl);
        if(diff == 0) rundenErgebnis = 20;
        else if (diff == 1) rundenErgebnis = 5;
        else rundenErgebnis = -10;
        this.gesamtPunkte += rundenErgebnis;
    }

    /**
     * Spieler gewinnt bei Gesamtpunktzahl größer oder gleich 100
     * @return true wenn >= 100, false wenn Gesamtpunktzahl unter 100
     */
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    /**
     * Spieler verliert bei Gesamtpunktzahl kleiner oder gleich 0
     * @return true wenn <= 0, false wenn Gesamtpunktzahl über 0
     */
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
