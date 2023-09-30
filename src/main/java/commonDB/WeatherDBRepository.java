package commonDB;

import model.Location;
import model.Weather;

import java.time.LocalDate;

public interface WeatherDBRepository {
    void addToDatabase(Location location, Weather weather);
    Weather getWeather(Location location);
    Weather getWeatherByLocationAndDate(Location location, LocalDate date);
}