package giuliaciampa.entities;

import giuliaciampa.exceptions.NumberOfPlayersException;

public class GiochiDaTavolo extends Giochi {
    //ATTRIBUTI
    private int numeroGiocatori;
    private double durataMediaPartita;

    //CONSTRUCTOR MACHINE
    public GiochiDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, double durataMediaPartita) {
        super(titolo, annoPubblicazione, prezzo);
        if (numeroGiocatori < 2 || numeroGiocatori > 10)
            throw new NumberOfPlayersException("il numero di giocatori deve essere compreso tra 2 e 10");
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    //METODI GETTER E SETTER

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public double getDurataMediaPartita() {
        return durataMediaPartita;
    }

    //STAMPA

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", numeroGiocatori=" + getNumeroGiocatori() +
                ", durataMediaPartita=" + getDurataMediaPartita() +
                '}';

    }
}
