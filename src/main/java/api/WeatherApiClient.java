package api;

import model.Weather;

import java.io.IOException;
import java.time.LocalDate;

public interface WeatherApiClient {


    Weather getWeather(String city, LocalDate date) throws IOException;
}
