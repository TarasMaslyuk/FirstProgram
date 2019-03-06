package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Taras Maslyuk
 *
 */

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter: 1 - Calculator,  2 - The longest word,  3 - Exit:");
        enterGame();
    }


    public static void enterGame() {
        int game = scan.next().charAt(0);
        switch (game) {
            case '1':
                int firstNumber = enterNumber("first"), secondNumber = enterNumber("second");
                System.out.printf("%010.4f", calc(firstNumber, secondNumber, enterOperation()));
                break;
            case '2':
                maxWord();
                break;
            case '3':
                System.out.println("Thank you, bye!");
                System.exit(0);

            default:
                System.out.println("try again!");
                enterGame();
        }
        System.out.println("");
        System.out.println("Enter: 1 - Calculator,  2 - The longest word, 3 - Exit:");
        enterGame();
    }


    public static void maxWord() {
        scan.nextLine();
        System.out.println("Enter the string:");
        String str = scan.nextLine();
        String[] words = str.split(" ");
        int indMax = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[indMax].length() < words[i].length()) {
                indMax = i;
            }
        }
        System.out.println("The longest word in string - " + words[indMax]);
    }

    public static int enterNumber(String arg) {
        int number;
        try {
            System.out.println("Enter " + arg + " number:");
            number = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.next();
            System.out.println("Error while entering number try again!:");
            return enterNumber(arg);
        }
        return number;
    }

    public static char enterOperation() {
        System.out.println("Enter operation (+,-,*,/):");
        char operation = scan.next().charAt(0);
        switch (operation) {
            case '+':
                return operation;
            case '-':
                return operation;
            case '*':
                return operation;
            case '/':
                return operation;
            default:
                System.out.println("Error while entering operation try again!:");
                return enterOperation();
        }
    }

    public static float calc(int num1, int num2, char operation) {
        /**
         *
         */
        float result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = calc(num1, num2, operation);
        }
        return result;
    }
}

