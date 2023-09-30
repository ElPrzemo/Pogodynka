package fileMenager;//package fileMenager;
//
//import model.Location;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//
//public class LocationDataSaveToFile {
//    public void locationSaveToFile(String fileName, Location location) {
//        File file = new File(fileName);
//
//        // sprawdzenie czy plik istnieje jesli nie tworzenie nowego
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
//                writer.write("Kraj: " + location.getCountry() + "\n");
//                writer.write("Miasto: " + location.getCity() + "\n");
//                writer.write("Szerokość geograficzna: " + location.getLatitude() + "\n");
//                writer.write("Długość geograficzna: " + location.getLongitude() + "\n");
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
//
//        }
//    }
//}
