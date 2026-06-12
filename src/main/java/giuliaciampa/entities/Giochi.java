package giuliaciampa.entities;

import giuliaciampa.exceptions.NegativePriceException;


public abstract class Giochi {

    //ATTRIBUTI
    private static int contatoreId = 1150;
    private int idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    //COSTRUTTORE
    public Giochi(String titolo, int annoPubblicazione, double prezzo) {
        if (prezzo < 0) throw new NegativePriceException("il prezzo negativo non valido");
        idGioco = contatoreId++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    //METODI GETTER E SETTER

    public int getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    //STAMPA

    @Override
    public String toString() {
        return "Giochi{" +
                "idGioco=" + idGioco +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
