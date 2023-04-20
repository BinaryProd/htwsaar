/**
 * <h1> MitarbeiterException </h1>
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.
 * @since 2023-04-11
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MitarbeiterException extends RuntimeException    
{    
    private static final Pattern VALID_MAIL = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");

    private static final String FEHLER_MAIL_FORMAT = "Die E-Mail Adresse muss diesem Format entschprechen : example@domain .";
    private static final String FEHLER_MAIL = "Die E-Mail Adresse darf nicht leer sein, null oder aus Leerzeichen bestehen.";

 
    public MitarbeiterException(){    
        super();
    }    
    
    public MitarbeiterException(String message){
        super(message);
    }

    /**    
     * Check if a string is not empty else throw an error     
     *     
     * @param String     
     * @throws MitarbeiterException    
     */    
    public static void checkEMail(String str) throws MitarbeiterException {
        if (str == null || str.isBlank()) {    
            throw new MitarbeiterException(FEHLER_MAIL);
        }    
    }

    /**
     * Check if a string is a valid mail else throw an error 
     * 
     * @param String 
     * @throws MitarbeiterException
     */ 
    public static void checkIfValidMail(String str) throws MitarbeiterException{
        Matcher is_valid_mail = VALID_MAIL.matcher(str);
        if (!is_valid_mail.find()) {
            throw new MitarbeiterException(FEHLER_MAIL);
        }
    }
}
