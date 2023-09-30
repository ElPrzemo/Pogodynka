package commonDB;

import model.Location;
import model.Weather;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WeatherDatabase implements WeatherDBRepository {
    private static WeatherDatabase instance = new WeatherDatabase();
    private Map<String, Weather> weatherMap = new HashMap<>();

    private WeatherDatabase() {}

    public static WeatherDatabase getInstance() {
        return instance;
    }

    @Override
    public void addToDatabase(Location location, Weather weather) {
        String city = String.valueOf(location.getCity());
        weatherMap.put(city, weather);
    }

    @Override
    public Weather getWeather(Location location) {
        String city = String.valueOf(location.getCity());
        return weatherMap.get(city);
    }

    @Override
    public Weather getWeatherByLocationAndDate(Location location, LocalDate date) {
        String city = String.valueOf(location.getCity());
        Weather weather = weatherMap.get(city);

        if (weather != null && weather.getDate().equals(date)) {
            return weather;
        } else {
            return null;
        }
    }
}