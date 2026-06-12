package giuliaciampa.entities;

import giuliaciampa.exceptions.NegativeNumberException;


public abstract class Gioco {

    //ATTRIBUTI
    private int idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    //COSTRUTTORE
    public Gioco(int idGioco, String titolo, int annoPubblicazione, double prezzo) {
        if (prezzo < 0) throw new NegativeNumberException("prezzo negativo non valido");
        if (annoPubblicazione < 0) throw new NegativeNumberException("l'anno di pubblicazione non può essere negativo");
        if (idGioco < 0) throw new NegativeNumberException("l'id non può essere negativo");
        this.idGioco = idGioco;
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

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //STAMPA

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco=" + idGioco +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
