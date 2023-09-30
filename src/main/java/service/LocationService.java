package service;

import commonDB.LocationRepository;
import model.Location;

import java.util.Set;

public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation(Location location) {
        locationRepository.addLocation(location);
    }

    public void deleteLocation(Location location) {
        locationRepository.deleteLocation(location);
    }

    public Set<Location> getAllLocations() {
        return locationRepository.getAllLocations();
    }
}

