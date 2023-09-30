package api;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class WeatherApiHandler2 implements WeatherApiClient  {
    private final String apiKey;

    public WeatherApiHandler2(String apiKey) {
        this.apiKey = apiKey;
    }

    public Weather getWeather(String city, LocalDate date) throws IOException {
        String apiUrl = "http://api.weatherstack.com/historical?city=" + city + "&date=" + date + "&apiKey=" + apiKey + "&hourly=0";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            ObjectMapper objectMapper = new ObjectMapper();
            Weather weatherData = objectMapper.readValue(response.toString(), Weather.class);

            return weatherData;
        } else {
            throw new IOException("Błąd zapytania do API pogodowego: " + responseCode);
        }
    }
}