package console;

import commonDB.LocationDatabase;
import model.Location;

import java.util.Scanner;

public class SubMenuOne {
    public void runSubMenuOne() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        LocationDatabase locationDatabase = LocationDatabase.getInstance();

        do {
            displaySubMenuOneOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Location addedLocation = CityAddMenu.addLocation();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Powrót do menu głównego.");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void displaySubMenuOneOptions() {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Wybierz opcję: ");
        System.out.println();
        System.out.println("1. Dodaj lokację.");
        System.out.println("2. Skasuj lokalizację.");
        System.out.println("3. Wyświetl wszystkie lokalizacje.");
        System.out.println("4. Powrót do menu głównego.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
    }
}