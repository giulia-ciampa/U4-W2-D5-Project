package giuliaciampa.entities;

import giuliaciampa.exceptions.DuplicateIdException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Collezione {

    //ATTRIBUTO

    private List<Gioco> listaGiochi = new ArrayList<>();


    //METODO GETTER

    public List<Gioco> getListaGiochi() {
        return listaGiochi;
    }


    //METODO 1 - AGGIUNTA DI UN ELEMENTO
    public void aggiungiUnGioco(Gioco nuovoGioco) {
        boolean idEsistente = listaGiochi.stream().anyMatch(gioco -> gioco.getIdGioco() == nuovoGioco.getIdGioco());
        if (idEsistente) {
            throw new DuplicateIdException("id già inserito! Inserisci nuovo id");
        } else {
            listaGiochi.add(nuovoGioco);
        }
    }


    //METODO 2 - RICERCA PER ID
    public Gioco ricercaPerId(int idInserito) {
        List<Gioco> giochiTrovati = listaGiochi.stream().filter(gioco -> gioco.getIdGioco() == idInserito).toList();

        if (giochiTrovati.isEmpty()) throw new IllegalArgumentException("l'id " + idInserito + " non esiste");
        return giochiTrovati.getFirst();


    }

    //METODO 3 - RICERCA PER PREZZO, TORNA LISTA CON GIOCHI INFERIORE AL PREZZO INSERITO

    public List<Gioco> ricercaPerPrezzo(double prezzoInserito) {
        List<Gioco> giochiPerPrezzo = listaGiochi.stream().filter(gioco -> gioco.getPrezzo() < prezzoInserito).toList();
        return giochiPerPrezzo;
    }

    //METODO 4 - RICERCA PER NUMERO DI GIOCATORI

    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numeroCercato) {
        List<GiocoDaTavolo> giochiDaTavoloPerNumeroGiocatori = listaGiochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).map(gioco -> (GiocoDaTavolo) gioco).filter(giocoDaTavolo -> giocoDaTavolo.getNumeroGiocatori() == numeroCercato).toList(); //rileggi

        return giochiDaTavoloPerNumeroGiocatori;
    }
    //METODO 5 - RIMOZIONE DI UN ELEMENTO DATO UN CODICE ID

    public void rimozioneTramiteId(int idDigitato) {
        boolean giocoDaRimuovere = listaGiochi.removeIf((gioco -> gioco.getIdGioco() == idDigitato));

        if (!giocoDaRimuovere) throw new IllegalArgumentException("l'id digitato " + idDigitato + "non esiste");

    }

    //METODO 6 - AGGIORNAMENTO DI UN ELEMENTO ESISTENTE DATO ID

    public Gioco aggiornamentoElementoEsistente(int idGiocoDaAggiornare, double nuovoPrezzo) {
        Gioco giocoDaAggiornare = ricercaPerId(idGiocoDaAggiornare);

        giocoDaAggiornare.setPrezzo(nuovoPrezzo);
        Gioco giocoAggiornato = giocoDaAggiornare;

        return giocoAggiornato;
    }

    //METODO 7

    public void totaleGiochi() {
        //TOTALE GIOCHI LISTA
        Integer nTotaleGiochi = listaGiochi.size();

        //TOTALE GIOCHI DA TAVOLO
        List<GiocoDaTavolo> nGiochiDaTavolo = listaGiochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).map(gioco -> (GiocoDaTavolo) gioco).toList();
        int numeroGiochiDaTavolo = nGiochiDaTavolo.size();

        System.out.println("Il numero totale dei giochi è: " + nTotaleGiochi);
        System.out.println("di cui giochi da tavolo: " + numeroGiochiDaTavolo);

        //GIOCO CON IL PREZZO PIU ALTO
        List<Gioco> giocoPrezzoPiuAlto = listaGiochi.stream().sorted(Comparator.comparing(Gioco::getPrezzo).reversed()).limit(1).toList();

        System.out.println("il gioco con il prezzo più alto è " + giocoPrezzoPiuAlto);

        //MEDIA PREZZI DI TUTTI GLI ELEMENTI
        OptionalDouble mediaPrezzi = listaGiochi.stream().mapToDouble(Gioco::getPrezzo).average();
        System.out.println("la media totale dei prezzi è: " + mediaPrezzi);

    }

}
