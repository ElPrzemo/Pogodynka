package console;

import java.util.Scanner;


public class App {

    private static SubMenuOne subMenuOne = new SubMenuOne();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        displayMenu();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    subMenuOne.runSubMenuOne();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Wyjście z programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (choice > 0 && choice < 5);

        scanner.close();
    }


    public static void displayMenu() {
        System.out.println("***************************************");
        System.out.println("Witam Cię w naszym programie pogodowym!");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Wybierz opcję: ");
        System.out.println();
        System.out.println("1. Edycja lokalizacji.");
        System.out.println("2. Sprawdź pogodę.");
        System.out.println("3. Statystyki.");
        System.out.println("4. Zapis do pliku.");
        System.out.println("5. Wyłącz program.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("Mam nadzieje że Ci się spodoba :) ");
        System.out.println("***************************************");
        System.out.println();
    }
}




