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
        List<Integer> listOfDigits = new ArrayList<>();
        listOfDigits.add(numberToCheck % 10);
        while (numberToCheck / 10 != 0) {
            numberToCheck = numberToCheck / 10;
            listOfDigits.add(0, numberToCheck % 10);
        }
        if (listOfDigits.contains(0) || listOfDigits.contains(5)) {
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
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }
        return number;
    }
}
