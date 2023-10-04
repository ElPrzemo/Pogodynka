package controller;

import commonDB.LocationDatabase;
import model.Location;
import service.LocationService;

import java.util.Set;

public class LocationController {
    private final LocationService locationService;

    public LocationController() {
        this.locationService = new LocationService(LocationDatabase.getInstance());
    }

    public void addLocation(Location location) {
        locationService.addLocation(location);
    }

    public void deleteLocation(Location location) {
        locationService.deleteLocation(location);
    }

    public Set<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    public Location getLocationByName(String cityName) {
        return locationService.getLocationByName(cityName);
    }
}