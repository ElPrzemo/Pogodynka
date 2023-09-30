package console.consoleByJaro;//package console;
//
//import model.City;
//import model.Country;
//
//import java.util.Scanner;
//
//public class Menu {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        mainMenu(scanner);
//
//
//    }
//
//    public static void mainMenu(Scanner scanner) {
//        System.out.println("------------------------------");
//        System.out.println("Program do sprawdzania pogody");
//        System.out.println("------------------------------");
//        System.out.println("Wybierz opcje: \n 1. Edytor lokalizacji \n 2. Wyświetl pogodę \n 3. Statystyki");
//
//        int nextStep = ScannerWithValidationMethods.scannerWithinGivenRangeForInts(scanner, 1, 3);
//
//        if (nextStep == 1) {
//            localizationSubMenu(scanner);
//        } else if (nextStep == 2) {
//            weatherSubMenu(scanner);
//        } else if (nextStep == 3) {
//            statisticsSubMenu(scanner);
//        }
//    }
//
//    public static void localizationSubMenu(Scanner scanner) {
//        System.out.println("Edytor lokalizacji");
//        System.out.println("------------------------------");
//        System.out.println("1. Dodaj lokalizację \n2. Usuń lokalizację \n3. Powrót do menu głównego");
//
//        int nextStep = ScannerWithValidationMethods.scannerWithinGivenRangeForInts(scanner, 1, 3);
//
//        if (nextStep == 1) {
//            // dodanie lokacji, pozniej bedzie wrzucone do osobnej metody
//            double latitude;
//            double longitude;
//            Country country;
//            City city;
//
//            System.out.println("podaj szerokość geograficzną");
//            latitude = ScannerWithValidationMethods.scannerWithinGivenRangeForDoubles(scanner,-90.0,90.0);
//            System.out.println("podaj długośc geograficzną");
//            longitude = ScannerWithValidationMethods.scannerWithinGivenRangeForDoubles(scanner, -180.0, 180.0);
//            System.out.println("podaj kraj");
//
//
//            // Location location = new Location(latitude,longitude,country,city);
//            // LocationDatabase.addLocation(location);
//
//
//        } else if (nextStep == 2) {
//            // usuwa lokalizacje
//        } else if (nextStep == 3) {
//            mainMenu(scanner);
//        }
//    }
//
//    public static void weatherSubMenu(Scanner scanner) {
//        System.out.println("podaj nazwe miasta");
//        String userInput = scanner.nextLine();
//
//        //sprawdzenie czy miasto jest zawarte w bazie danych
//        // if userInput.toUpperCase().equals()
//        //sdfsd
//        ///sdfsdf
//
//    }
//
//    public static void statisticsSubMenu(Scanner scanner) {
//
//    }}
//
//
//
//
