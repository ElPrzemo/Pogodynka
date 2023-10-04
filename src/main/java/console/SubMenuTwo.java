package console;

import commonDB.WeatherDBRepository;
import commonDB.WeatherRequestRepository;
import model.Location;
import model.Weather;
import service.WeatherService;
import controller.LocationController;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SubMenuTwo {
    private WeatherService weatherService;
    private LocationController locationController;
    private WeatherRequestRepository weatherRequestRepository;

    public SubMenuTwo(WeatherService weatherService, LocationController locationController, WeatherRequestRepository weatherRequestRepository) {
        this.weatherService = weatherService;
        this.locationController = locationController;
        this.weatherRequestRepository = weatherRequestRepository;
    }

    public void runSubMenuTwo() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displaySubMenuTwoOptions();

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkWeather();
                        break;
                    case 2:
                        displayAllRequests();
                        break;
                    case 3:
                        saveResultsToFile();
                        break;
                    case 4:
                        System.out.println("Powrót do poprzedniego menu.");
                        break;
                    default:
                        System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                }
            } else {
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                scanner.next();
                choice = 0;
            }
        } while (choice != 4);
    }

    public static void displaySubMenuTwoOptions() {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Wybierz opcję: ");
        System.out.println();
        System.out.println("1. Sprawdź pogodę.");
        System.out.println("2. Wyświetl wszystkie pobrane zapytania.");
        System.out.println("3. Zapis wyników do pliku.");
        System.out.println("4. Powrót do poprzedniego menu.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
    }

    private void checkWeather() {
        Scanner scanner = new Scanner(System.in);

        Set<Location> allLocations = locationController.getAllLocations();
        System.out.println("Dostępne miasta:");
        for (Location location : allLocations) {
            System.out.println(location.getCity());
        }

        System.out.println("Wpisz miasto:");
        String cityName = scanner.nextLine().toLowerCase();
        System.out.println("Wpisz datę (np. 2023-10-04):");
        String dateStr = scanner.nextLine();

        Location location = null;
        for (Location loc : allLocations) {
            if (loc.getCity().equalsIgnoreCase(cityName)) {
                location = loc;
                break;
            }
        }

        if (location != null) {
            LocalDate date = LocalDate.parse(dateStr);

            Weather weatherData = weatherService.getWeatherByCityAndDate(location, date);

            if (weatherData != null) {
                System.out.println("Pogoda dla miasta: " + location.getCity());
                System.out.println("Data: " + dateStr);
                System.out.println("Temperatura: " + weatherData.getTemperature() + "°C");
                System.out.println("Ciśnienie: " + weatherData.getPressure() + "hPa");
                System.out.println("Wilgotność: " + weatherData.getHumidity() + "%");
                System.out.println("Prędkość wiatru: " + weatherData.getWindSpeed() + " km/h");

                // Zapisz zapytanie pogodowe do repozytorium
                weatherRequestRepository.addWeatherRequest(weatherData);
            } else {
                System.out.println("Nie udało się pobrać danych pogodowych.");
            }
        } else {
            System.out.println("Miasto " + cityName + " nie jest dostępne w bazie danych.");
        }
    }

    private void displayAllRequests() {
        System.out.println("Wszystkie zapytania pogodowe:");

        List<Weather> allRequests = weatherRequestRepository.getAllWeatherRequests();
        if (allRequests.isEmpty()) {
            System.out.println("Brak zapytań.");
        } else {
            for (Weather weatherRequest : allRequests) {
                System.out.println(weatherRequest);
            }
        }
    }

    private void saveResultsToFile() {
        // Implementacja zapisu wyników do pliku
    }
}