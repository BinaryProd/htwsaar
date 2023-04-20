/** 
 * This class is used to extract links from a given input and display their text and URL.
 * It also counts the number of links found and the number of lines in the input.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2013-13-13
 */

public class Patientenwarteschlange {
    private Patient[] warteschlange; 

    /**
     * Constructor for the PatientenWarteschlange class.
     * @param groesse The size of the queue
     * @throws IllegalArgumentException If groesse is less than 1
     */
    public Patientenwarteschlange(int groesse) {
	TestUtils.checkAboveOne(groesse);

	warteschlange = new Patient[groesse];
    }

    /**
     * Adds a new patient to the queue.
     * @param patientenNr The patient's number
     * @param vorname The patient's first name
     * @param nachname The patient's last name
     */
    public void neuerPatient(int patientenNr, String vorname, String nachname) {

	Patient patient = new Patient(patientenNr, vorname, nachname);

	for (int i = 0; i < warteschlange.length; i++) {
	    if (warteschlange[i] == null) {
		warteschlange[i] = patient;
		break;
	    }
	}
    }

    /**
     * Removes a patient from the queue based on their number.
     * @param patientenNr The patient's number
     * @return The patient that was removed, or null if no patient with the given number was found
     */
    public Patient entfernePatient(int patientenNr) {

	for (int i = 0; i < warteschlange.length; i++) {
	    if (warteschlange[i] != null && warteschlange[i].getPatientenNr() == patientenNr) {
		Patient patientValue = warteschlange[i];
		warteschlange[i] = null;

		sort();

		return patientValue;
	    }
	}

	return null;
    }

    /**
     * Removes the patient at the front of the queue and returns them.
     * @return The patient at the front of the queue
     */
    public Patient derNaechsteBitte() {

	Patient patientValue = warteschlange[0];
	warteschlange[0] = null;

	sort();

	return patientValue;
    }

    /**
     * Returns a string representation of the queue.
     * @return A string representation of the queue
     */
    @Override
    public String toString() {
	String buffer = new String();
	buffer = "Warteschlange\n" + "Patientenummer Vorname Nachname\n";
	for (int i = 0; i < warteschlange.length; i++) {
	    if (warteschlange[i] != null ) {
		buffer +=  warteschlange[i].toString() + "\n";
	    }
	}
	return buffer;
    }

    /**
     * Returns the size of the queue.
     * @return The size of the queue
     */
    public int getArraySize() {
	return warteschlange.length ;
    }

    /**
     * Sorts the queue so that null elements are at the end.
     */
    public void sort() {
	for (int i = 0; i < warteschlange.length; i++) {
	    if (warteschlange[i] == null) {
		for (int j = i; j < warteschlange.length; j++) {
		    if (warteschlange[j] != null) {
			warteschlange[i] = warteschlange[j];
			warteschlange[j] = null;
			break;
		    }
		}
	    }
	}
    }
}
