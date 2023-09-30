package statisticsMenager;

import commonDB.LocationDatabase;
import commonDB.WeatherDatabase;
import model.Location;
import model.Weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


    public class StatisticsMenager {
        private final LocationDatabase locationDatabase;
        private final WeatherDatabase weatherDatabase;

        public StatisticsMenager(LocationDatabase locationDatabase, WeatherDatabase weatherDatabase) {
            this.locationDatabase = locationDatabase;
            this.weatherDatabase = weatherDatabase;
        }

        public List<Weather> getWeatherStatisticsForCityInTimeRange(Location location, LocalDate startDate, LocalDate endDate) {
            List<Weather> weatherStatistics = new ArrayList<>();

            if (location == null || startDate == null || endDate == null) {
                throw new IllegalArgumentException("location, startDate i endDate nie mogą być null");
            }

            LocalDate currentDate = startDate;
            while (!currentDate.isAfter(endDate)) {
                Weather weather = weatherDatabase.getWeatherByLocationAndDate(location, currentDate);
                if (weather != null) {
                    weatherStatistics.add(weather);
                }
                currentDate = currentDate.plusDays(1);
            }

            return weatherStatistics;
        }
    }

