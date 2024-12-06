package lab3;

import java.util.Scanner;

public class NumberGuessingGames {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] range = askuMinMax();
        int triesround = tries();
        gameStart(range[0], range[1], triesround);

    }

    public static int[] askuMinMax() {
        System.out.print("Enter min value: ");
        int minvalue = sc.nextInt();
        int maxvalue;

        while (true) {
            System.out.print("Enetr max value: ");
            maxvalue = sc.nextInt();
            if (maxvalue > minvalue) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
        }
        return new int[]{minvalue, maxvalue};
    }

    public static int tries() {
        System.out.print("Enter of maximum number of tires: ");
        int tries;

        while (true) {
            tries = sc.nextInt();
            if (tries > 0) {
                break;
            } else {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        }

        return tries;
    }

    public static void gameStart(int min, int max, int maxround) {
        System.out.println("Welcome to number guessing game!");
        int randomValue = (int) (Math.random() * (max - min) + 1);
        int choose;
        int attempt = 0;

        while (true) {
            for (attempt = 0; attempt < maxround; attempt++) {
                while (true) {
                    System.out.print("Enter integer between " + min + " and " + max + ": ");
                    choose = sc.nextInt();
                    if (choose <= max && choose >= min) {
                        break;
                    }
                    System.out.println("The number must be between " + min + " and " + max);
                }
                if (choose > randomValue) {
                    System.out.println("Try lower number!");

                } else if (choose < randomValue) {
                    System.out.println("Try higher number!");
                } else {
                    System.out.println("Congratulations!");
                    if (attempt == 1) {
                        System.out.println("Your have tired " + attempt + " time");
                    } else {
                        System.out.println("Your have tired " + attempt + " times");
                    }
                    break;
                }
            }
            if (attempt == maxround) {
                System.out.println("You have tired 5 times. You ran out of guesses");
                System.out.println("The answer is " + randomValue);
            }
            System.out.print("Want to play again (Y or y): ");
            String checknextround = sc.next();
            if (!checknextround.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing games.Bye!");
                break;
            }
        }

    }

    public static void letPlay(int choose, int randomValue, int maxround) {

    }
}
