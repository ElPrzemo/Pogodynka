package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Location;

public class LocationDataFetcher {
    public static Location fetchLocationData(String cityName) {

        String jsonData = "Tutaj podaj JSON z danymi lokalizacji";

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);


        JsonArray locations = jsonObject.getAsJsonArray("locations");
        for (int i = 0; i < locations.size(); i++) {
            JsonObject locationObject = locations.get(i).getAsJsonObject();
            String locationCity = locationObject.get("name").getAsString();

            if (locationCity.equalsIgnoreCase(cityName)) {
                String country = locationObject.get("country").getAsString();
                double latitude = locationObject.getAsJsonObject("coord").get("lat").getAsDouble();
                double longitude = locationObject.getAsJsonObject("coord").get("lon").getAsDouble();

                return new Location(cityName, country, latitude, longitude);
            }
        }

        return null;
    }
}