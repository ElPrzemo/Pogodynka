package commonDB;

import model.Location;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LocationDatabase implements LocationRepository {
    private static LocationDatabase instance;
    private Set<Location> locationSet;

    private LocationDatabase() {
        locationSet = new TreeSet<>(new CityComparator());
    }

    public static LocationDatabase getInstance() {
        if (instance == null) {
            instance = new LocationDatabase();
        }
        return instance;
    }

    @Override
    public void addLocation(Location location) {
        locationSet.add(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationSet.remove(location);
    }

    @Override
    public Set<Location> getAllLocations() {
        return locationSet;
    }@Override
    public Location getLocationByName(String cityName) {
        for (Location location : locationSet) {
            if (location.getCity().equalsIgnoreCase(cityName)) {
                return location;
            }
        }
        return new Location(); // Zwracaj pusty obiekt Location lub obsłuż to w inny sposób, który uważasz za odpowiedni
    }


    private static class CityComparator implements Comparator<Location> {
        @Override
        public int compare(Location location1, Location location2) {
            String city1 = location1.getCity();
            String city2 = location2.getCity();

            if (city1 == null && city2 == null) {
                return 0; // Jeśli obie nazwy miast są null, uważamy, że są równe.
            } else if (city1 == null) {
                return -1; // Jeśli tylko city1 jest null, uważamy, że city2 jest większe.
            } else if (city2 == null) {
                return 1; // Jeśli tylko city2 jest null, uważamy, że city1 jest większe.
            } else {
                return city1.compareTo(city2); // Porównujemy normalnie, gdy obie nazwy miast są dostępne.
            }
        }
    }
}