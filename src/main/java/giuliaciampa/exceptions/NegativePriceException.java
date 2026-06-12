package giuliaciampa.exceptions;

public class NegativePriceException extends RuntimeException {
    //COSTRUTTORE ECCEZIONE

    public NegativePriceException(String string) {
        super(string);
    }

}
