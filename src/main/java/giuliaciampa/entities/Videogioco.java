package giuliaciampa.entities;

import giuliaciampa.exceptions.NegativeNumberException;

public class Videogioco extends Gioco {

    //ATTRIBUTI
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    //CONSTRUCTOR MACHINE
    public Videogioco(int idGioco, String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        if (durataGioco < 0) {
            throw new NegativeNumberException("la durata del gioco non può essere negativa");
        }
        if (genere == null) {
            throw new IllegalArgumentException("Il genere è obbligatorio e deve essere uno di quelli definiti");
        }
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;

    }

    //METODI GETTER E SETTER

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    //STAMPA


    @Override
    public String toString() {
        return "Videogioco{" +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", piattaforma=" + getPiattaforma() +
                ", durataGioco=" + getDurataGioco() +
                ", genere=" + getGenere() +
                '}';
    }
}


