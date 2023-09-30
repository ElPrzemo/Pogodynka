package fileMenager;//package fileMenager;
//
//
//import processor.WeatherDataProcessor;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//
//
//public class WeatherDataSaveToFile {
//    public void weatherSaveToFile(String fileName, WeatherDataProcessor weatherDataProcessor) {
//        File file = new File(fileName);
//
//        // sprawdzenie czy plik istnieje, jesli nie tworzenie nowego
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                return;
//            }
//        }
//        // zapisywanie danych do pliku z funkcją dopisywania bez usuwania poprzednich
//        if (file.canWrite()) {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
//
//          //     writer.write("Temperatura: " +  +"°C\n");
//          //     writer.write("Ciśnienie: " + +"hPa\n");
//          //     writer.write("Wilgotność: " + +"%\n");
//          //     writer.write("Kierunek wiatru: " + +"\n");
//          //     writer.write("Prędkość wiatru: " + +"km/h\n");
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
//
//        }
//    }
//}
