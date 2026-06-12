package giuliaciampa;

import giuliaciampa.entities.*;
import giuliaciampa.exceptions.DuplicateIdException;
import giuliaciampa.exceptions.NegativeNumberException;
import giuliaciampa.exceptions.NumberOfPlayersException;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione miaCollezione = new Collezione();
        Scanner scanner = new Scanner(System.in);

        //PROVA
        try {
            miaCollezione.aggiungiUnGioco(new Videogioco(2, "Fifa", 2024, 49.99, "PC", -1, Genere.Sport));
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        try {
            miaCollezione.aggiungiUnGioco(new Videogioco(2, "GTA", 2010, 25.60, "PlayStation", 2, Genere.Azione));
            miaCollezione.aggiungiUnGioco(new GiocoDaTavolo(5, "Risiko", 2000, 18.90, 15, 3));
        } catch (DuplicateIdException | NegativeNumberException | IllegalArgumentException |
                 NumberOfPlayersException ex) {
            System.out.println("Errore nell'inserimento: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Errore ");
        }


        while (true) {

            System.out.println("----------GESTIONE GIOCHI--------");
            System.out.println("Digita 1 per aggiungere un videogioco");
            System.out.println("Digita 2 per aggiungere un gioco da tavolo");
            System.out.println("Digita 0 per uscire dal programma");
            System.out.println("Digita 3 per cercare un gioco tramite ID");
            System.out.println("Digita 4 per filtrare i giochi per prezzo");
            System.out.println("Digita 5 per filtrare i giochi da tavolo per numero giocatori");
            System.out.println("Digita 6 per rimuovere un elemento tramite id");
            System.out.println("Digita 7 per modificare il prezzo di un gioco");
            System.out.println("Digita 8 per vedere delle statistiche sui giochi");
            System.out.print("Scegli un'opzione: ");


            try {

                int input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    System.out.println("Chiusura del programma. Arrivederci!");
                    break;
                }


                switch (input) {
                    case 1:
                        System.out.println("Hai scelto di aggiungere un VIDEOGIOCO");

                        System.out.println("Digita l'id per il tuo videogioco");
                        int idV = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita il titolo:");
                        String titoloV = scanner.nextLine();

                        System.out.println("Digita l'anno di pubblicazione:");
                        int annoPubblicazioneV = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita il prezzo");
                        double prezzoV = Double.parseDouble(scanner.nextLine());

                        System.out.println("Digita la piattaforma (es. PC, PS5)");
                        String piattaformaV = scanner.nextLine();

                        System.out.println("Digita la durata del gioco in ORE");
                        int durataGiocoV = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita il genere (es. Azione, Sport, Strategia):");
                        String genereStr = scanner.nextLine();
                        Genere genereV = Genere.valueOf(genereStr);

                        Videogioco v = new Videogioco(idV, titoloV, annoPubblicazioneV, prezzoV, piattaformaV, durataGiocoV, genereV);
                        Gioco nuovoVideogioco = miaCollezione.aggiungiUnGioco(v);
                        System.out.println("gioco aggiunto con successo: " + nuovoVideogioco);


                        break;


                    case 2:
                        System.out.println("Hai scelto di aggiungere un GIOCO DA TAVOLO");

                        System.out.println("Digita l'id per il tuo videogioco");
                        int idGDT = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita il titolo:");
                        String titoloGDT = scanner.nextLine();

                        System.out.println("Digita l'anno di pubblicazione:");
                        int annoPubblicazioneGDT = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita il prezzo");
                        double prezzoGDT = Double.parseDouble(scanner.nextLine());

                        System.out.println("Digita il numero di giocatori");
                        int numeroGiocatoriGDT = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digita la durata media della partita");
                        double durataMediaPartitaGDT = Double.parseDouble(scanner.nextLine());

                        GiocoDaTavolo gdt = new GiocoDaTavolo(idGDT, titoloGDT, annoPubblicazioneGDT, prezzoGDT, numeroGiocatoriGDT, durataMediaPartitaGDT);

                        miaCollezione.aggiungiUnGioco(gdt);
                        break;

                    case 3:
                        System.out.println("Hai scelto di cercare un gioco tramite id");
                        System.out.println("digita l'id per trovare il gioco");
                        int nInserito = Integer.parseInt(scanner.nextLine());
                        Gioco giocoTrovato = miaCollezione.ricercaPerId(nInserito);

                        System.out.println("Elemento trovato -> " + giocoTrovato);
                        break;

                    case 4:
                        System.out.println("Hai scelto di filtrare i giochi tramite prezzo");
                        System.out.println("inserisci il prezzo massimo");
                        double prezzoInserito = Double.parseDouble(scanner.nextLine());
                        List<Gioco> giochiConPrezzoInferiore = miaCollezione.ricercaPerPrezzo(prezzoInserito);
                        System.out.println("giochi da mostrare: " + giochiConPrezzoInferiore);
                        break;

                    case 5:
                        System.out.println("Hai scelto di filtrare i giochi da tavolo in base al numero di giocatori");
                        System.out.println("inserisci il numero di giocatori");
                        int numeroGiocatori = Integer.parseInt(scanner.nextLine());

                        List<GiocoDaTavolo> giochiCorrispondenti = miaCollezione.ricercaPerNumeroGiocatori(numeroGiocatori);
                        break;

                    case 6:
                        System.out.println("Hai scelto di rimuovere un elemento tramite id");
                        System.out.println("inserisci l'id");
                        int idDigitato = Integer.parseInt(scanner.nextLine());
                        miaCollezione.rimozioneTramiteId(idDigitato);
                        System.out.println("Gioco rimosso con successo!");

                        System.out.println("Ecco la collezione aggiornata senza il gioco:");
                        miaCollezione.getListaGiochi().forEach(System.out::println);
                        break;

                    case 7:
                        System.out.println("Hai scelto di modificare il prezzo di un gioco, per continuare, inserisci l'id:");
                        int idGioco = Integer.parseInt(scanner.nextLine());
                        System.out.println("ora inserisci il nuovo prezzo");
                        double nuovoPrezzo = Double.parseDouble(scanner.nextLine());

                        Gioco giocoAggiornato = miaCollezione.aggiornamentoElementoEsistente(idGioco, nuovoPrezzo);
                        System.out.println("Gioco aggiornato con successo: " + giocoAggiornato);
                        break;

                    case 8:
                        System.out.println("Hai scelto di visualizzare le statistiche sui giochi, ecco a te:");
                        miaCollezione.totaleGiochi();

                    default:
                        System.out.println("Opzione non valida. Scegli un numero da 0 a 8.");

                }


            } catch (DuplicateIdException | NegativeNumberException | NumberOfPlayersException |
                     IllegalArgumentException ex) {
                System.out.println("Errore: " + ex.getMessage());

            }
        }

    }
}
