package console;

import commonDB.WeatherDatabase;
import model.Location;
import model.Weather;
import statisticsMenager.StatisticsManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SubMenuThree {
    private StatisticsManager statisticsManager;
    private WeatherDatabase weatherDatabase;
    private Location location;

    public SubMenuThree(StatisticsManager statisticsManager, WeatherDatabase weatherDatabase) {
        this.statisticsManager = statisticsManager;
        this.weatherDatabase = weatherDatabase;
    }

    public void runSubMenuThree() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displaySubMenuThreeOptions();

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        calculateAverageWeather();
                        break;
                    case 2:
                        findHighestAndLowestTemperature();
                        break;
                    case 3:
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
        } while (choice != 3);
    }

    public void displaySubMenuThreeOptions() {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Wybierz opcję: ");
        System.out.println();
        System.out.println("1. Oblicz średnią pogodę.");
        System.out.println("2. Znajdź najwyższą i najniższą temperaturę.");
        System.out.println("3. Powrót do poprzedniego menu.");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println();
    }

    private void calculateAverageWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz miasto:");
        String cityName = scanner.nextLine().toLowerCase();
        System.out.println("Wpisz datę początkową (np. 2023-10-04):");
        String startDateStr = scanner.nextLine();
        System.out.println("Wpisz datę końcową (np. 2023-10-10):");
        String endDateStr = scanner.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);

            if (startDate.isAfter(endDate)) {
                System.out.println("Błędny zakres dat. Data początkowa nie może być późniejsza niż data końcowa.");
                return;
            }

            location = statisticsManager.getLocationByName(cityName);

            if (location != null) {
                Weather averageWeather = statisticsManager.getAverageWeatherStatisticsForCityInTimeRange(location, startDate, endDate);

                if (averageWeather != null) {
                    System.out.println("Średnia pogoda dla miasta: " + cityName);
                    System.out.println("Data początkowa: " + startDateStr);
                    System.out.println("Data końcowa: " + endDateStr);
                    System.out.println("Średnia temperatura: " + averageWeather.getTemperature() + "°C");
                    System.out.println("Średnie ciśnienie: " + averageWeather.getPressure() + "hPa");
                    System.out.println("Średnia wilgotność: " + averageWeather.getHumidity() + "%");
                    System.out.println("Średnia prędkość wiatru: " + averageWeather.getWindSpeed() + " km/h");
                } else {
                    System.out.println("Brak dostępnych danych pogodowych w wybranym okresie.");
                }
            } else {
                System.out.println("Miasto " + cityName + " nie jest dostępne w bazie danych.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Błąd podczas analizy daty. Upewnij się, że używasz formatu yyyy-MM-dd.");
        }
    }

    private void findHighestAndLowestTemperature() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz miasto:");
        String cityName = scanner.nextLine().toLowerCase();
        System.out.println("Wpisz datę początkową (np. 2023-10-04):");
        String startDateStr = scanner.nextLine();
        System.out.println("Wpisz datę końcową (np. 2023-10-10):");
        String endDateStr = scanner.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);

            if (startDate.isAfter(endDate)) {
                System.out.println("Błędny zakres dat. Data początkowa nie może być późniejsza niż data końcowa.");
                return;
            }

            location = statisticsManager.getLocationByName(cityName);

            if (location != null) {
                Weather temperatureStats = statisticsManager.findHighestAndLowestTemperatureForLocationInTimeRange(location, startDate, endDate);

                if (temperatureStats != null) {
                    System.out.println("Najwyższa temperatura dla miasta: " + cityName);
                    System.out.println("Data początkowa: " + startDateStr);
                    System.out.println("Data końcowa: " + endDateStr);
                    System.out.println("Najwyższa temperatura: " + temperatureStats.getTemperature() + "°C");
                    System.out.println("Najniższa temperatura: " + temperatureStats.getHumidity() + "°C");
                } else {
                    System.out.println("Brak dostępnych danych pogodowych w wybranym okresie.");
                }
            } else {
                System.out.println("Miasto " + cityName + " nie jest dostępne w bazie danych.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Błąd podczas analizy daty. Upewnij się, że używasz formatu yyyy-MM-dd.");
        }
    }
}