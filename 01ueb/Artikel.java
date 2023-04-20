/**
 * <h1>Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.4
 * @since 2022-11-04
 */
public class Artikel {
	private int artikelNr;
	private int bestand;
	private String art;
	
	/*
	 * This constructor is the main entry point for the Artikel class
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public Artikel(int artikelNr, String art, int bestand) { 
		if (artikelNr < 0) {
			throw new IllegalArgumentException("Die Artikelnummer kann nicht negativ seien");
		} else if (art.strip().isEmpty()) {
			throw new IllegalArgumentException("Art kann nicht leer seien");
		} else if (bestand < 0 ) {
			throw new IllegalArgumentException("Der Bestand kann nicht negativ seien");
		} 
		this.artikelNr = artikelNr;
		this.art = art;
		this.bestand = bestand;
	}
	
	
	/*
	 * This constructor is the second entry of the class Artikel
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel 
	 */
	public Artikel(int artikelNr, String art) { 
		this(artikelNr, art, 0);
	}

	/*
	 * This methode is used to increase the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void bucheZugang(int menge) {
		this.bestand += menge;
	}

	/*
	 * This methode is used to decrease the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void bucheAbgang(int menge) { 
		if (this.bestand - menge < 0) {
			throw new IllegalArgumentException("Der Bestand wurde nicht aktualisert, sonst ist der Bestand negativ");	
		} 
		this.bestand -= menge;
	}

	/*
	 * This methode is used to return the value of the attribute art
	 * @param art This is the second attribute of the class Artikel
	 * @return string This returns the value of art
	 */
	public String getArt() { 
		return art;
	}

	/*
	* This methode is used to return the value of the attribute artikelNr
	* @param artikelNr This is the first attribute of the class Artikel
	* @return string This returns the content of art
	*/
	public int getArtikel() { 
		return artikelNr;
	}

	/*
	 * This methode is used to return the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 * @return int This returns the value of bestand
	 */
	public int getBestand() { 
		return bestand;
	}
	
	/*
	 * This method is used to set the value of art
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void setArt(String neuerArt) {
		if (neuerArt.strip().isEmpty()) {
			throw new IllegalArgumentException("Art kann nicht leer seien");	
		}
		this.art = neuerArt;
	}

	/*
	 * This method is used to set the value of bestand
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void setBestand(int neuerBestand) { 
		if (neuerBestand < 0) {
			throw new IllegalArgumentException("Der neue Bestand kann nicht negativ seien");
		}
		this.bestand = neuerBestand;
	}
	
	/*
	 * This method is used to return the values of the attributes of the class Artikel
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel
	 * @param bestand This is the third attribute of the class Artikel
	 * @return string This returns the attributes artikelNr, art and bestand in a String
	 */
	public String toString() { 
		return "Artikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand;
	}
}
