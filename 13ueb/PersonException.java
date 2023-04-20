/**
 * <h1> PersonException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
 class PersonException extends RuntimeException    
{    

    private static final String FEHLER_NAME = "Der Namme darf nicht leer, nicht null und nicht aus Leerzeichen bestehen";

    public PersonException(){    
        super();
    }    
    
    public PersonException(String message){
        super(message);
    }

    /**    
     * Check if a string is not empty else throw an error     
     *     
     * @param String     
     * @throws PersonException    
     */    
    public static void checkName(String str) throws PersonException {
        if (str == null || str.isBlank()) {    
            throw new PersonException(FEHLER_NAME);
        }    
    }
}

