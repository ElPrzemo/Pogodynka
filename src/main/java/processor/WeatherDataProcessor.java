package processor;

import api.WeatherApiHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import commonDB.WeatherDatabase;
import model.Weather;

import java.io.IOException;
import java.time.LocalDate;

public class WeatherDataProcessor {

    private WeatherDatabase weatherDatabase = WeatherDatabase.getInstance();
    private final WeatherApiHandler apiRepository1;
    private final WeatherApiHandler apiRepository2;
    private final WeatherApiHandler apiRepository3;

    public WeatherDataProcessor(String apiKey1, String apiKey2, String apiKey3) {
        this.apiRepository1 = new WeatherApiHandler(apiKey1);
        this.apiRepository2 = new WeatherApiHandler(apiKey2);
        this.apiRepository3 = new WeatherApiHandler(apiKey3);
    }

    public Weather getAveragedWeatherData(String city, LocalDate date) throws IOException {
        String jsonDataFromSource1 = String.valueOf(apiRepository1.getWeather(city, date));
        String jsonDataFromSource2 = String.valueOf(apiRepository2.getWeather(city, date));
        String jsonDataFromSource3 = String.valueOf(apiRepository3.getWeather(city, date));
        Weather averagedData = new Weather();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Weather dataFromSource1 = objectMapper.readValue(jsonDataFromSource1, Weather.class);
            Weather dataFromSource2 = objectMapper.readValue(jsonDataFromSource2, Weather.class);
            Weather dataFromSource3 = objectMapper.readValue(jsonDataFromSource3, Weather.class);

            double averagedTemperature = (dataFromSource1.getTemperature() + dataFromSource2.getTemperature() + dataFromSource3.getTemperature()) / 3.0;
            double averagedPressure = (dataFromSource1.getPressure() + dataFromSource2.getPressure() + dataFromSource3.getPressure()) / 3.0;
            int averagedHumidity = (int) ((dataFromSource1.getHumidity() + dataFromSource2.getHumidity() + dataFromSource3.getHumidity()) / 3);
            int averagedWindSpeed = (dataFromSource1.getWindSpeed() + dataFromSource2.getWindSpeed() + dataFromSource3.getWindSpeed()) / 3;

            averagedData.setTemperature(averagedTemperature);
            averagedData.setPressure(averagedPressure);
            averagedData.setHumidity(averagedHumidity);
            averagedData.setWindSpeed(averagedWindSpeed);


            weatherDatabase.addToDatabase(new model.Location(null, null, 0, 0), averagedData);

        } catch (IOException e) {
            throw new IOException("Błąd podczas przetwarzania danych pogodowych", e);
        }

        return averagedData;
    }
}