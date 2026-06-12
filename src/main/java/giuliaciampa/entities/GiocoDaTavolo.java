package giuliaciampa.entities;

import giuliaciampa.exceptions.NegativeNumberException;
import giuliaciampa.exceptions.NumberOfPlayersException;

public class GiocoDaTavolo extends Gioco {
    //ATTRIBUTI
    private int numeroGiocatori;
    private double durataMediaPartita;

    //CONSTRUCTOR MACHINE
    public GiocoDaTavolo(int idGioco, String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, double durataMediaPartita) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        if (numeroGiocatori < 2 || numeroGiocatori > 10)
            throw new NumberOfPlayersException("Il numero di giocatori deve essere compreso tra 2 e 10");
        if (durataMediaPartita < 0) {
            throw new NegativeNumberException("la durata della partita non può essere negativa");
        }
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
        return "GiocoDaTavolo{" +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", numeroGiocatori=" + getNumeroGiocatori() +
                ", durataMediaPartita=" + getDurataMediaPartita() +
                '}';

    }
}
