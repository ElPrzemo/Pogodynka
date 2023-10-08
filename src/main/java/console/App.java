package console;

import commonDB.WeatherDatabase;
import console.SubMenuOne;
import console.SubMenuTwo;
import controller.LocationController;
import service.WeatherService;
import commonDB.WeatherRequestRepository;
import java.util.Scanner;


public class App {
    private static SubMenuOne subMenuOne;
    private static SubMenuTwo subMenuTwo;

    public static void main(String[] args) {
        LocationController locationController = new LocationController();
        WeatherService weatherService = new WeatherService(WeatherDatabase.getInstance());
        WeatherRequestRepository weatherRequestRepository = new WeatherRequestRepository();

        subMenuOne = new SubMenuOne(locationController);
        subMenuTwo = new SubMenuTwo(weatherService, locationController, weatherRequestRepository);

        uruchom();
    }

    public static void uruchom() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            wyswietlMenu();

            if (scanner.hasNextInt()) {
                int wybor = scanner.nextInt();

                if (wybor >= 1 && wybor <= 3) {
                    switch (wybor) {
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
                } else if (wybor == 4) {
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

    public static void wyswietlMenu() {
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