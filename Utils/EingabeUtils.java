import java.util.Scanner;

class EingabeUtils {
    public static String sstring(String userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.next();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static int sint(int userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static long slong(long userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextLong();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static double sdouble(double userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextDouble();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static short sshort(short userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextShort();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static Float sFloat(Float userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextFloat();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static Boolean sBoolean(Boolean userinput){
        Scanner scanner = new Scanner(System.in);
        userinput = scanner.nextBoolean();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
}