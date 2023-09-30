package console.consoleByJaro;

import java.util.Scanner;

public class ScannerWithValidationMethods {
    public static boolean isNumberWithinRangeForInts(int min, int max, int userInput) {
        if (userInput >= min && userInput <= max) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumberWithinRangeForDoubles(double min, double max, double userInput) {
        if (userInput >= min && userInput <= max) {
            return true;
        } else {
            return false;
        }
    }

    public static int scannerWithinGivenRangeForInts(Scanner scanner, int min, int max) {

        boolean userInputValidator = false;
        int userChoice = -1;

        while (!userInputValidator) {
            System.out.println("Wybierz opcję od " + min + " do " + max);

            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (isNumberWithinRangeForInts(min, max, userChoice)) {
                    userInputValidator = true;
                } else {
                    System.out.println("Twój wybór jest poza zakresem, wybierz ponownie");
                }
            } else {
                System.out.println("To nie jest cyfra, wybierz ponownie");
                scanner.next();
            }
        }
        System.out.println("Wybrano opcje " + userChoice);
        return userChoice;
    }

    public static double scannerWithinGivenRangeForDoubles(Scanner scanner, double min, double max) {

        boolean userInputValidator = false;
        double userChoice = -1.0;

        while (!userInputValidator) {
            System.out.println("Wybierz opcję od " + min + " do " + max);

            if (scanner.hasNextInt()) {
                userChoice = scanner.nextDouble();
                if (isNumberWithinRangeForDoubles(min, max, userChoice)) {
                    userInputValidator = true;
                } else {
                    System.out.println("Twój wybór jest poza zakresem, wybierz ponownie");
                }
            } else {
                System.out.println("To nie jest cyfra, wybierz ponownie");
                scanner.next();
            }
        }
        System.out.println("Wybrano opcje " + userChoice);
        return userChoice;
    }

// tu bedzie metoda do odczytywania info od uzytkownika i przypisywania enuma country
//    public static Country countryPicker(Scanner scanner) {
//        String userInput = scanner.nextLine();
//    }


}

