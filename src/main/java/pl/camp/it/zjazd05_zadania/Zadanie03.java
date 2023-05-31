package pl.camp.it.zjazd05_zadania;

import java.util.*;

/**
 * https://www.codechef.com/problems/DIGARR
 */
public class Zadanie03 {
    public static void main(String[] args) {

        int[] arrayOfCases = new int[inputNumber()];

        for (int i = 0; i < arrayOfCases.length; i++) {
            arrayOfCases[i] = inputNumber();
        }

        for (int number : arrayOfCases) {
            rearrangingDigitsToGetAMultipleOf5(number);
        }
    }

    public static void rearrangingDigitsToGetAMultipleOf5(int numberToCheck) {
        String stringNumberToCheck = String.valueOf(numberToCheck);

        if (stringNumberToCheck.contains("0") || stringNumberToCheck.contains("5")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number > 0) {
                    break;
                } else System.out.println("Wrong input");
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
        return number;
    }
}
