


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Exercitii.sumaPrimelor100Cifre();

//        int limit = 10000000;
//
//        System.out.println("Numere prime " + limit + ":");
//        for (int number = 2; number < limit; number++) {
//            if (isPrime(number)) {
//                System.out.println(number);
//            }
//        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year (between 1900 and 2016): ");
        int year = scanner.nextInt();

        if (year >= 1900 && year <= 2016) {
            int daysInFebruary = getDaysInFebruary(year);
            System.out.println("Number of days in February " + year + ": " + daysInFebruary);
        } else {
            System.out.println("Invalid year entered. Please try again.");
        }
    }
    private static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    private static int getDaysInFebruary(int year) {
        if (isLeapYear(year)) {
            return 29; // Leap year, February has 29 days
        } else {
            return 28; // Non-leap year, February has 28 days
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
