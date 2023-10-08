package fileMenager;

import model.Weather;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static void saveWeatherData(List<Weather> weatherData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz, gdzie chcesz zapisać dane pogodowe:");
        System.out.println("1. Zapisz do pliku tekstowego.");
        System.out.println("2. Zapisz do innego pliku.");
        System.out.println("3. Anuluj (nie zapisuj).");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                saveToTextFile(weatherData);
                break;
            case 2:
                System.out.println("Podaj ścieżkę do pliku, do którego chcesz zapisać dane:");
                String filePath = scanner.next();
                saveToCustomFile(weatherData, filePath);
                break;
            case 3:
                System.out.println("Anulowano zapis.");
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Anulowano zapis.");
        }
    }

    private static void saveToTextFile(List<Weather> weatherData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pogoda.txt"))) {
            for (Weather weather : weatherData) {
                writer.write(weather.toString());
                writer.newLine();
            }
            System.out.println("Dane pogodowe zostały zapisane do pliku 'pogoda.txt'.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania danych.");
        }
    }

    private static void saveToCustomFile(List<Weather> weatherData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Weather weather : weatherData) {
                writer.write(weather.toString());
                writer.newLine();
            }
            System.out.println("Dane pogodowe zostały zapisane do pliku '" + filePath + "'.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania danych.");
        }
    }
}