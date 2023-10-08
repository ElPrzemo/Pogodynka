package statisticsMenager;

import commonDB.LocationDatabase;
import commonDB.WeatherDatabase;
import model.Location;
import model.Weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatisticsManager {
    private final LocationDatabase locationDatabase;
    private final WeatherDatabase weatherDatabase;

    public StatisticsManager(LocationDatabase locationDatabase, WeatherDatabase weatherDatabase) {
        this.locationDatabase = locationDatabase;
        this.weatherDatabase = weatherDatabase;
    }

    public Weather getAverageWeatherStatisticsForCityInTimeRange(Location location, LocalDate startDate, LocalDate endDate) {
        if (location == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException("location, startDate i endDate nie mogą być null");
        }

        int totalCount = 0;
        double totalTemperature = 0.0;
        double totalPressure = 0.0;
        double totalHumidity = 0.0;
        int totalWindSpeed = 0;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            Weather weather = weatherDatabase.getWeatherByLocationAndDate(location, currentDate);
            if (weather != null) {
                totalCount++;
                totalTemperature += weather.getTemperature();
                totalPressure += weather.getPressure();
                totalHumidity += weather.getHumidity();
                totalWindSpeed += weather.getWindSpeed();
            }
            currentDate = currentDate.plusDays(1);
        }

        if (totalCount == 0) {
            return createNoDataWeather(); // Brak danych, zwróć komunikat o braku dostępnych danych
        }

        // Oblicz średnie wartości
        double averageTemperature = totalTemperature / totalCount;
        double averagePressure = totalPressure / totalCount;
        double averageHumidity = totalHumidity / totalCount;
        int averageWindSpeed = totalWindSpeed / totalCount;

        // Tworzenie obiektu Weather z średnimi wartościami
        Weather averageWeather = new Weather(
                averageTemperature,
                averagePressure,
                averageHumidity,
                averageWindSpeed,
                startDate // Możesz ustawić datę na początku okresu
        );

        return averageWeather;
    }

    private Weather createNoDataWeather() {
        return new Weather(
                0.0, // Brak danych o temperaturze
                0.0, // Brak danych o ciśnieniu
                0.0, // Brak danych o wilgotności
                0,   // Brak danych o prędkości wiatru
                LocalDate.now() // Bieżąca data
        );
    }

    public Weather findHighestAndLowestTemperatureForLocationInTimeRange(Location location, LocalDate startDate, LocalDate endDate) {
        if (location == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException("location, startDate i endDate nie mogą być null");
        }

        double highestTemperature = Double.MIN_VALUE;
        double lowestTemperature = Double.MAX_VALUE;

        LocalDate currentDate = startDate;
        Weather highestTempWeather = null;
        Weather lowestTempWeather = null;

        while (!currentDate.isAfter(endDate)) {
            Weather weather = weatherDatabase.getWeatherByLocationAndDate(location, currentDate);
            if (weather != null) {
                double temperature = weather.getTemperature();
                if (temperature > highestTemperature) {
                    highestTemperature = temperature;
                    highestTempWeather = weather;
                }
                if (temperature < lowestTemperature) {
                    lowestTemperature = temperature;
                    lowestTempWeather = weather;
                }
            }
            currentDate = currentDate.plusDays(1);
        }

        if (highestTempWeather == null || lowestTempWeather == null) {
            return null; // Brak danych, zwróć null
        }

        // Tworzenie obiektu Weather z najwyższą i najniższą temperaturą
        Weather temperatureStats = new Weather(
                highestTempWeather.getTemperature(),
                0.0, // Nie obliczamy średniego ciśnienia, wilgotności itp.
                lowestTempWeather.getTemperature(),
                0,   // Nie obliczamy średniej prędkości wiatru
                startDate // Możesz ustawić datę na początku okresu
        );

        return temperatureStats;
    }

    public Location getLocationByName(String cityName) {
        for (Location location : locationDatabase.getAllLocations()) {
            if (location.getCity().equalsIgnoreCase(cityName)) {
                return location;
            }
        }
        return null;
    }
}