package console;

import commonDB.LocationDatabase;
import model.Location;
import util.LocationDataFetcher;

import java.util.Scanner;

public class CityAddMenu {
    public static Location addLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*********************");
        System.out.println("Wpisz miasto:");
        String cityName = scanner.nextLine().toLowerCase(); // Konwertuj na małe litery
        System.out.println("*********************");

        Location location = LocationDataFetcher.fetchLocationData(cityName);

        if (location != null) {
            System.out.println();
            System.out.println("Wprowadzone miasto: " + location.getCity());
            System.out.println("Wprowadzony kraj: " + location.getCountry());
            System.out.println("Wprowadzona długość geograficzna: " + location.getLongitude());
            System.out.println("Wprowadzona szerokość geograficzna: " + location.getLatitude());
            System.out.println();

            LocationDatabase locationDatabase = LocationDatabase.getInstance();
            locationDatabase.addLocation(location);
        } else {
            System.out.println("Nie znaleziono lokalizacji o podanej nazwie miasta.");
        }

        return location;
    }
}