package console;

import commonDB.LocationDatabase;
import controller.LocationController;
import model.Location;
import util.LocationDataFetcher;

import java.util.List;
import java.util.Set;
import java.util.Scanner;


public class SubMenuOne {
    private LocationController locationController = new LocationController();

    public void runSubMenuOne() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displaySubMenuOneOptions();

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Location addedLocation = CityAddMenu.addLocation();
                        break;
                    case 2:
                        deleteLocation();
                        break;
                    case 3:
                        displayAllLocations();
                        break;
                    case 4:
                        displayCityCheatsheet();
                        break;
                    case 5:
                        System.out.println("Powrót do menu głównego.");
                        break;
                    default:
                        System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                }
            } else {
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                scanner.next(); // Pobierz nieprawidłowy token, aby uniknąć zapętlenia
                choice = 0; // Ustaw choice na 0, aby zapobiec kontynuowaniu pętli
            }
        } while (choice != 5);
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
        System.out.println("4. Miasta-ściągawka.");
        System.out.println("5. Powrót do menu głównego.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
    }

    private void displayAllLocations() {
        Set<Location> allLocations = locationController.getAllLocations();
        System.out.println("Wszystkie lokalizacje:");

        for (Location location : allLocations) {
            System.out.println("Miasto: " + location.getCity());
            System.out.println("Kraj: " + location.getCountry());
            System.out.println("Długość geograficzna: " + location.getLongitude());
            System.out.println("Szerokość geograficzna: " + location.getLatitude());
            System.out.println();
        }
    }

    private void deleteLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz miasto lokalizacji do usunięcia:");
        String cityName = scanner.nextLine();

        LocationController locationController = new LocationController();
        Location locationToDelete = locationController.getLocationByName(cityName);

        if (locationToDelete != null) {
            locationController.deleteLocation(locationToDelete);
            System.out.println("Lokalizacja została usunięta.");
        } else {
            System.out.println("Nie znaleziono lokalizacji o podanej nazwie miasta.");
        }
    }

    private void displayCityCheatsheet() {
        System.out.println("Miasta-ściągawka:");
        List<Location> allLocations = LocationDataFetcher.fetchAllLocations("C:\\Users\\przem\\IdeaProjects\\PROJEKT\\WeatherAppTest\\Pogodynka\\src\\main\\resources\\city.list.json");

        for (Location location : allLocations) {
            System.out.println(location.getCity());
        }
    }
}