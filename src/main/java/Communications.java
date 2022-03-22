import java.util.Scanner;

public class Communications {

    public static int getDateFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date");
        return scanner.nextInt();
    }

    public static String getActorNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of actor (for example Morgan)");
        return scanner.nextLine();
    }

    public static String getActorSurnameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter surname of actor (for example Freeman)");
        return scanner.nextLine();
    }
}

