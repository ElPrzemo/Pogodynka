package commonDB;


import model.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherRequestRepository {
    private List<Weather> weatherRequests = new ArrayList<>();

    public void addWeatherRequest(Weather weatherRequest) {
        weatherRequests.add(weatherRequest);
    }

    public List<Weather> getAllWeatherRequests() {
        return weatherRequests;
    }

    // Dodaj inne metody, które mogą być potrzebne do zarządzania danymi zapytań pogodowych
}