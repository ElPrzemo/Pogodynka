package service;

import commonDB.WeatherDBRepository;
import model.Location;
import model.Weather;

import java.time.LocalDate;

public class WeatherService {

    private final WeatherDBRepository weatherDBRepository;

    public WeatherService(WeatherDBRepository weatherDBRepository) {
        this.weatherDBRepository = weatherDBRepository;
    }

    public Weather getWeatherByCityAndDate(Location location, LocalDate localDate) {

        if (location == null || localDate == null) {
            throw new IllegalArgumentException("location i localDate nie mogą być null");
        }

        Weather weather = weatherDBRepository.getWeatherByLocationAndDate(location, localDate);

        if (weather == null) {
            throw new IllegalArgumentException("Brak danych pogodowych dla podanej lokalizacji i daty.");
        }

        return weather;
    }
}