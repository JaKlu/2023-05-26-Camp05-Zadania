package pl.camp.it.zjazd05_zadania;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie04_KingQueen {
    private static final int boardSize = 8;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] board = new String[][]{
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
                {"-", "-", "-", "-", "-", "-", "-", "-",},
        };
        printBoard(board);


        boolean[] arrayOfCases = new boolean[inputNumber()];

        for (int i = 0; i < arrayOfCases.length; i++) {
            String input = input();
            if (isValidInput(input)) {
                arrayOfCases[i] = isKingEaten(input);
            } else {
                System.out.println("Wrong input");
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean input : arrayOfCases) {
            if (input) {
                sb.append("Y ");
            } else sb.append("N ");
        }
        System.out.println(sb.toString().trim());
    }

    public static String input() {
        return scanner.nextLine();
    }

    public static boolean isValidInput(String input) {
        if ((input.toLowerCase().matches("[a-h][1-8][' '][a-h][1-8]"))
                && !(input.substring(0, 2).equals(input.substring(3)))) {
            return true;
        }
        return false;
    }

    public static boolean isKingEaten(String figuresPlacement) {
        int kingRow = getFigureRow(figuresPlacement.substring(0, 2));
        int kingColumn = getFigureColumn(figuresPlacement.substring(0, 2));

        int queenRow = getFigureRow(figuresPlacement.substring(3));
        int queenColumn = getFigureColumn(figuresPlacement.substring(3));

        //horizontally && vertically
        if ((kingRow == queenRow) || (kingColumn == queenColumn)) {
            return true;
        }

        int checkingRow = kingRow;
        int checkingColumn = kingColumn;

        //diagonally
        for (int i = 0; i < boardSize; i++) {
            checkingRow++;
            checkingColumn++;

            if (checkingRow >= boardSize) {
                checkingRow = boardSize - checkingColumn;
                checkingColumn = 0;
            } else if (checkingColumn >= boardSize) {
                checkingColumn = boardSize - checkingRow;
                checkingRow = 0;
            }

            if (checkingRow == queenRow && checkingColumn == queenColumn) {
                return true;
            }

            if (checkingRow == kingRow && checkingColumn == kingColumn) {
                for (int j = 0; j < boardSize; j++) {
                    checkingRow--;
                    checkingColumn++;

                    if (checkingRow < 0) {
                        checkingRow = checkingRow + checkingColumn;
                        checkingColumn = 0;
                    } else if (checkingColumn >= boardSize) {
                        checkingColumn = boardSize - checkingRow;
                        checkingRow = 0;
                    }

                    if (checkingRow == queenRow && checkingColumn == queenColumn) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static int getFigureRow(String alphanumericPosition) {
        return Math.abs(Integer.parseInt(alphanumericPosition.substring(1)) - boardSize);
    }

    public static int getFigureColumn(String alphanumericPosition) {
        switch (alphanumericPosition.substring(0, 1)) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            default:
                return -1;
        }
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < boardSize; i++) {
            System.out.print(boardSize - i + "  ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("   a b c d e f g h");
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
