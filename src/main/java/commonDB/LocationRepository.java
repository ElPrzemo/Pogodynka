package commonDB;

import model.Location;

import java.util.Set;

public interface LocationRepository {
    void addLocation(Location location);
    void deleteLocation(Location location);
    Set<Location> getAllLocations();
}

