package controller;

import model.Location;
import model.Weather;
import service.WeatherService;

import java.time.LocalDate;

public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void getWeatherForLocation(String apiKey1, String apiKey2, String apiKey3, Location location, LocalDate date) {

        Weather weather = weatherService.getWeatherByCityAndDate(location, date);


        System.out.println("Pogoda w " + location.getCity() + " (" + location.getCountry() + "):");
        System.out.println("Temperatura: " + weather.getTemperature() + "°C");
        System.out.println("Ciśnienie: " + weather.getPressure() + " hPa");
        System.out.println("Wilgotność: " + weather.getHumidity() + "%");
        System.out.println("Prędkość wiatru: " + weather.getWindSpeed() + " km/h");


    }}