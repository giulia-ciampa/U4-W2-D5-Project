package giuliaciampa.entities;

public class Videogiochi extends Giochi {

    //ATTRIBUTI
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    //CONSTRUCTOR MACHINE
    public Videogiochi(String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(titolo, annoPubblicazione, prezzo);
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
        return "Videogiochi{" +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", piattaforma=" + getPiattaforma() + '\'' +
                ", durataGioco=" + getDurataGioco() +
                ", genere=" + getGenere() +
                '}';
    }
}


