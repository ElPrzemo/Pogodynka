package util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import model.Location;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationDataFetcher {
    public static Location fetchLocationData(String cityName) {
        String jsonDataFilePath = "src/main/resources/city.list.json"; // Ścieżka do pliku JSON

        try {
            JsonFactory jsonFactory = new JsonFactory();
            try (JsonParser jsonParser = jsonFactory.createParser(new File(jsonDataFilePath))) {
                while (jsonParser.nextToken() != null) {
                    if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                        Location location = parseLocation(jsonParser);
                        if (location != null && location.getCity().equalsIgnoreCase(cityName)) {
                            return location;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Location parseLocation(JsonParser jsonParser) throws IOException {
        String city = null;
        String country = null;
        double latitude = 0.0;
        double longitude = 0.0;

        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            jsonParser.nextToken(); // Przejdź do wartości pola

            switch (fieldName) {
                case "name":
                    city = jsonParser.getValueAsString();
                    break;
                case "country":
                    country = jsonParser.getValueAsString();
                    break;
                case "coord":
                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                        String coordFieldName = jsonParser.getCurrentName();
                        jsonParser.nextToken(); // Przejdź do wartości pola

                        switch (coordFieldName) {
                            case "lat":
                                latitude = jsonParser.getValueAsDouble();
                                break;
                            case "lon":
                                longitude = jsonParser.getValueAsDouble();
                                break;
                            default:
                                // Ignoruj inne pola
                                break;
                        }
                    }
                    break;
                default:
                    // Ignoruj inne pola
                    break;
            }
        }

        if (city != null && country != null) {
            return new Location(city, country, latitude, longitude);
        }

        return null;
    }

    public static List<Location> fetchAllLocations(String jsonFilePath) {
        List<Location> cities = new ArrayList<>();
        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonParser jsonParser = jsonFactory.createParser(new File(jsonFilePath));

            while (jsonParser.nextToken() != null) {
                if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                    Location location = parseLocation(jsonParser);
                    if (location != null) {
                        cities.add(location);
                    }
                }
            }

            jsonParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
}