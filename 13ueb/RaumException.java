/**
 * <h1> RaumException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
class RaumException extends RuntimeException {    
    private static final String FEHLER_INDEX = "Index ist nicht im gültigen Bereich.";
    private static final String FEHLER_RAUM = "Die Zahl muss größer als 0 sein.";

    public RaumException(){    
        super();
    }    
    
    public RaumException(String message){
        super(message);
    }

    public static void checkIndex(int index, Reservierung[] reservierungen) throws RaumException{
        if ( reservierungen[index] == null ) {
            throw new RaumException(FEHLER_INDEX);
        }
    }

    public static void checkIfPositive(int number) throws RaumException{
        if(number < 0){
            throw new RaumException(FEHLER_RAUM);
        }
    }
}
