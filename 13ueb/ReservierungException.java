/**
 * <h1> ReservierungException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
class ReservierungException extends RuntimeException {                                        
    
    private static final String FEHLER_NAME = "Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen";    
    
    public ReservierungException(){                                        
        super();    
    }                                        
                                        
    public ReservierungException(String message){    
        super(message);    
    }    
    
    /**        
     * Check if a string is not empty else throw an error         
     *         
     * @param String         
     * @throws ReservierungException        
     */                                        
    public static void checkBemerkung(String str) throws ReservierungException {    
        if (str == null || str.isBlank()) {                                        
            throw new ReservierungException(FEHLER_NAME);    
        }                                        
    }    
}   
