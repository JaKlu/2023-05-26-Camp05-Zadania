package pl.camp.it.zjazd05_zadania;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/PAIREQ
 */
public class Zadanie02 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        makeAllEqualUsingPairs(inputNumber());
    }

    public static void makeAllEqualUsingPairs(int numberOfCases) {
        int[][] array = new int[numberOfCases][];
        for (int i = 0; i < numberOfCases; i++) {
            int stringArraySize;
            String[] stringArray;

            do {
                stringArraySize = inputNumber();

                String string = scanner.nextLine();
                stringArray = string.trim().split(" ");
                if (stringArraySize != stringArray.length) {
                    System.out.println("Wrong array size: given " + stringArray.length
                            + ", but required " + stringArraySize);
                }
            } while (stringArraySize != stringArray.length);


            int[] intArray = new int[stringArraySize];

            array[i] = intArray;

            for (int j = 0; j < intArray.length; j++) {
                array[i][j] = Integer.parseInt(stringArray[j]);
            }
        }
        for (int[] oneArray : array) {
            System.out.println(makeAllEqualUsingPairs(oneArray));
        }
    }

    public static int makeAllEqualUsingPairs(int[] array) {
        int min = array.length;

        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue;
                if (array[i] != array[j]) {
                    counter++;
                }
            }
            if (counter < min) {
                min = counter;
            }
        }
        return min;
    }

    public static int inputNumber() {
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
