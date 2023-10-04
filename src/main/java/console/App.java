package console;

import commonDB.WeatherRequestRepository;
import controller.LocationController;
import service.WeatherService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LocationController locationController = new LocationController();
        WeatherService weatherService = new WeatherService(WeatherDBRepository.getInstance()); // Przekazanie odpowiedniego argumentu
        WeatherRequestRepository weatherRequestRepository = new WeatherRequestRepository();

        SubMenuOne subMenuOne = new SubMenuOne(locationController);
        SubMenuTwo subMenuTwo = new SubMenuTwo(weatherService, locationController, weatherRequestRepository);

        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 3) {
                    switch (choice) {
                        case 1:
                            subMenuOne.runSubMenuOne();
                            break;
                        case 2:
                            subMenuTwo.runSubMenuTwo();
                            break;
                        case 3:
                            // Obsługa wyboru 3 (Statystyki)
                            break;
                    }
                } else if (choice == 4) {
                    System.out.println("Wyjście z programu.");
                    return; // Zakończ program po obsłudze opcji 4
                } else {
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                }
            } else {
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                scanner.next(); // Pobierz nieprawidłowy token, aby uniknąć zapętlenia
            }
        }
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
        System.out.println("4. Wyjście z programu.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("Mam nadzieje że Ci się spodoba :) ");
        System.out.println("***************************************");
        System.out.println();
    }
}