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
    }

    private static class CityComparator implements Comparator<Location> {
        @Override
        public int compare(Location location1, Location location2) {
            return location1.getCity().compareTo(location2.getCity());
        }
    }
}