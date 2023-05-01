/**
 * The QueueDialog class is a class that allows the user, 
 * to interact with a bla  and its bla
 * through a command line interface.
 * It includes functionality to create and remove bla, 
 * blu and blo , change blo of bla, 
 * and retrieve information about the bli and its bla. 
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2023-01-12
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueDialog {
    private Queue queue;
    private int userInput;
    private Scanner scanner = EingabeUtils.scanOpen();
    private static final String FEHLER_PERSON_QUEUE = "Die Queue ist keine PersonQueue";

    private static final int STRING_QUEUE_ANLEGEN_INT = 1;
    private static final int PERSON_QUEUE_ANLEGEN_INT = 2;
    private static final int EXIT_INT = 3;

    private static final String STRING_QUEUE_ANLEGEN_STRING = " : String Queue anlegen";
    private static final String PERSON_QUEUE_ANLEGEN_STRING = " : Person Queue anlegen";
    private static final String EXIT_STRING = " : Programm beenden";

    private static final int ADD_LAST_INT = 1;
    private static final int ADD_FIRST_INT = 2;
    private static final int ADD_AT_INDEX_INT = 3;
    private static final int REMOVE_FIRST_INT = 4;
    private static final int REMOVE_LAST_INT = 5;
    private static final int REMOVE_AT_INDEX_INT = 6;
    private static final int GET_INT = 7;
    private static final int AUSGABE_INT = 8;
    private static final int AUSGABE_PRINT_INT = 9;
    private static final int SMALLEST_INT = 10;
    private static final int CLEAR_QUEUE_INT = 11;
    private static final int REMOVE_QUEUE_INT = 12;

    private static final String ADD_LAST_STRING = " : Element hinten anfügen";
    private static final String ADD_FIRST_STRING = " : Element vorne anfügen";
    private static final String ADD_AT_INDEX_STRING = " : Element an Index anfügen";
    private static final String REMOVE_FIRST_STRING = " : Element vorne entfernen";
    private static final String REMOVE_LAST_STRING = " : Element hinten entfernen";
    private static final String REMOVE_AT_INDEX_STRING = " : Element an Index entfernen";
    private static final String GET_STRING = " : Element an Index abfragen";
    private static final String AUSGABE_STRING = " : Liste ausgeben";
    private static final String AUSGABE_PRINT_STRING = " : Liste ausgeben mit print ( nur fuer PersonQueue )";
    private static final String SMALLEST_STRING = " : Kleinster Vorname ausgeben ( nur fuer PersonQueue )";
    private static final String CLEAR_QUEUE_STRING = " : Liste leeren";
    private static final String REMOVE_QUEUE_STRING = " : Queue entfernen";

    /**
     * The main function starts a new QueueDialog object.
     */
    public static void main( String[] args) {
        new QueueDialog().start();
    }

    /**
     * This method is used to read the user input and return it
     * @return userInput as an Integer
     */
    public int eingabeLesen() {
        int userInput = EingabeUtils.scanInt(scanner);
        return userInput;
    }

    /**
     * The start method is the main loop of the program. It initializes the queue to null and prompts the user for input to interact with the Queue and its Artikel. 
     * The method also includes exception handling for illegal argument, input mismatch, and general exceptions.
     */
    public void start() {

        this.queue = null;
        userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                queueErstellenMenuAusgabe();
                userInput = eingabeLesen();
                queueErstellenEingabeBearbeitung(userInput);
            } catch(QueueException e) {
                System.out.println(e);
            } catch(PersonQueueException e) {
                System.out.println(e);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }

    }

    /**
     * This method is used to toString the different choices for interacting with the Queue and its Artikel.
     * It uses a StringBuilder to append the different menu options and their corresponding int and string values and toStrings them to the console.
     */
    public void queueErstellenMenuAusgabe() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n")
            .append(STRING_QUEUE_ANLEGEN_INT).append(STRING_QUEUE_ANLEGEN_STRING).append("\n")
            .append(PERSON_QUEUE_ANLEGEN_INT).append(PERSON_QUEUE_ANLEGEN_STRING).append("\n")
            .append(EXIT_INT).append(EXIT_STRING).append("\n")
            .append(">>> ");

        System.out.println(sb.toString());
    } 

    public void queueErstellenEingabeBearbeitung(int userInput) {
        switch(userInput) {
            case STRING_QUEUE_ANLEGEN_INT:
                stringQueueAnlegen();
                queueBearbeiten();
                break;
            case PERSON_QUEUE_ANLEGEN_INT:
                personQueueAnlegen();
                queueBearbeiten();
                break;
            case EXIT_INT:
                System.out.println("Programm wird beendet");
                EingabeUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    public void queueBearbeiten(){
        userInput = 0;
        while (userInput != REMOVE_QUEUE_INT) {
            try {
                queueMenuAusgabe();
                userInput = eingabeLesen();
                queueEingabeBearbeitung(userInput);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }
    }


    public void queueMenuAusgabe(){
        StringBuilder sb = new StringBuilder();    

        sb.append("\n")    
            .append(ADD_LAST_INT).append(ADD_LAST_STRING).append("\n")
            .append(ADD_FIRST_INT).append(ADD_FIRST_STRING).append("\n")
            .append(ADD_AT_INDEX_INT).append(ADD_AT_INDEX_STRING).append("\n")
            .append(REMOVE_FIRST_INT).append(REMOVE_FIRST_STRING).append("\n")
            .append(REMOVE_LAST_INT).append(REMOVE_LAST_STRING).append("\n")
            .append(REMOVE_AT_INDEX_INT).append(REMOVE_AT_INDEX_STRING).append("\n")
            .append(GET_INT).append(GET_STRING).append("\n")
            .append(AUSGABE_INT).append(AUSGABE_STRING).append("\n")
            .append(AUSGABE_PRINT_INT).append(AUSGABE_PRINT_STRING).append("\n")
            .append(SMALLEST_INT).append(SMALLEST_STRING).append("\n")
            .append(CLEAR_QUEUE_INT).append(CLEAR_QUEUE_STRING).append("\n")
            .append(REMOVE_QUEUE_INT).append(REMOVE_QUEUE_STRING).append("\n")
            .append(">>> ");    

        System.out.print(sb.toString());    

    }

    /**
     * This method is used to execute the user choice.
     * @param userInput The input from the user
     */
    public void queueEingabeBearbeitung(int userInput) {
        switch (userInput) {
            case ADD_LAST_INT:
                addLast();
                break;
            case ADD_FIRST_INT:
                addFirst();
                break;
            case ADD_AT_INDEX_INT:
                addAtIndex();
                break;
            case REMOVE_FIRST_INT:
                removeFirst();
                break;
            case REMOVE_LAST_INT:
                removeLast();
                break;
            case REMOVE_AT_INDEX_INT:
                removeAtIndex();
                break;
            case GET_INT:
                get();
                break;
            case AUSGABE_INT:
                ausgabe();
                break;
            case AUSGABE_PRINT_INT:
                ausgabePrint();
                break;
            case SMALLEST_INT:
                smallest();
                break;
            case CLEAR_QUEUE_INT:
                clear();
                break;
            case REMOVE_QUEUE_INT:
                System.out.println("Queue wird entfernt, und es wird zurück zum Hauptmenü gewechselt");
                queue = null;
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }


    /**
     * This method is used to create a new StringQueue object and assign it to the queue variable.
     */
    public void stringQueueAnlegen() {
        queue = new StringQueue(10);
        System.out.println("Die StringQueue wurde angelegt");
    }

    /**
     * This method is used to create a new PersonQueue object and assign it to the queue variable.
     */
    public void personQueueAnlegen() {
        queue = new PersonQueue(10);
        System.out.println("Die PersonQueue wurde angelegt");
    }

    /**
     * This method is used to add a new String to the queue.
     */
    public void addLast() {
        if (queue instanceof StringQueue) {
            System.out.println("Bitte geben Sie einen String ein");
            String string = EingabeUtils.scanString(scanner);
            queue.addLast(string);
            System.out.println("String wurde hinzugefügt");
        } else {
            System.out.println("Bitte geben Sie einen Vornamen ein");
            String firstName = EingabeUtils.scanString(scanner);
            System.out.println("Bitte geben Sie einen Nachnamen ein");
            String lastName = EingabeUtils.scanString(scanner);
            queue.addLast(new Person(firstName, lastName));
            System.out.println("Person wurde hinzugefügt");
        }
    }

    /**
     * This method is used to add a new String to the queue.
     */
    public void addFirst() {
        if (queue instanceof StringQueue) {
            System.out.println("Bitte geben Sie einen String ein");
            String string = EingabeUtils.scanString(scanner);
            queue.addFirst(string);
            System.out.println("String wurde hinzugefügt");
        } else {
            System.out.println("Bitte geben Sie einen Vornamen ein");
            String firstName = EingabeUtils.scanString(scanner);
            System.out.println("Bitte geben Sie einen Nachnamen ein");
            String lastName = EingabeUtils.scanString(scanner);
            queue.addFirst(new Person(firstName, lastName));
            System.out.println("Person wurde hinzugefügt");
        }
    }

    /**
     * This method is used to add a new String to the queue at a specific index.
     */
    public void addAtIndex() {
        if (queue instanceof StringQueue) {
            System.out.println("Bitte geben Sie einen String ein");
            String string = EingabeUtils.scanString(scanner);
            System.out.println("Bitte geben Sie einen Index ein");
            int index = EingabeUtils.scanInt(scanner);
            queue.addAtIndex(string, index);
            System.out.println("String wurde hinzugefügt");
        } else {
            System.out.println("Bitte geben Sie einen Vornamen ein");
            String firstName = EingabeUtils.scanString(scanner);
            System.out.println("Bitte geben Sie einen Nachnamen ein");
            String lastName = EingabeUtils.scanString(scanner);
            System.out.println("Bitte geben Sie einen Index ein");
            int index = EingabeUtils.scanInt(scanner);
            queue.addAtIndex(new Person(firstName, lastName), index);
            System.out.println("Person wurde hinzugefügt");
        }
    }

    /**
     * This method is used to remove the first String from the queue.
     */
    public void removeFirst() {
        if (queue instanceof StringQueue) {
            queue.removeFirst();
            System.out.println("String wurde entfernt");
        } else {
            queue.removeFirst();
            System.out.println("Person wurde entfernt");
        }
    }

    /**
     * This method is used to remove the last String from the queue.
     */
    public void removeLast() {
        if (queue instanceof StringQueue) {
            queue.removeLast();
            System.out.println("String wurde entfernt");
        } else {
            queue.removeLast();
            System.out.println("Person wurde entfernt");
        }
    }

    /**
     * This method is used to remove a String from the queue at a specific index.
     */
    public void removeAtIndex() {
        if (queue instanceof StringQueue) {
            System.out.println("Bitte geben Sie einen Index ein");
            int index = EingabeUtils.scanInt(scanner);
            queue.removeAtIndex(index);
            System.out.println("String wurde entfernt");
        } else {
            System.out.println("Bitte geben Sie einen Index ein");
            int index = EingabeUtils.scanInt(scanner);
            queue.removeAtIndex(index);
            System.out.println("Person wurde entfernt");
        }
    }

    /**
     * This method is used to get a String from the queue at a specific index.
     */
    public void get() {
        if (queue instanceof StringQueue) {
            System.out.print("Bitte geben Sie den Index ein: ");
            int index = EingabeUtils.scanInt(scanner);
            System.out.println(queue.get(index));
        } else {
            System.out.print("Bitte geben Sie den Index ein: ");
            int index = EingabeUtils.scanInt(scanner);
            System.out.println(queue.get(index));
        }
    }

    /**
     * This method is used to toString the queue.
     */
    public void ausgabe() {
        System.out.println(queue.toString());
    }

    /**
     * This method is used to print the queue.
     */
    public void ausgabePrint() {
        if (queue instanceof PersonQueue) {
            PersonQueue personQueue = (PersonQueue) queue;
            personQueue.print();
        } else {
            //System.out.println("Die Queue ist keine PersonQueue");
            throw new PersonQueueException(FEHLER_PERSON_QUEUE);
        }
    }

    public void smallest() {
        if (queue instanceof PersonQueue) {
            PersonQueue personQueue = (PersonQueue) queue;
            System.out.println(personQueue.smallest());
        } else {
            //System.out.println("Die Queue ist keine PersonQueue");
            throw new PersonQueueException(FEHLER_PERSON_QUEUE);
        }
    }

    /**
     * This method is used to clear the queue.
     */
    public void clear() {
        queue.clear();
        System.out.println("Queue wurde geleert");
    }
}
