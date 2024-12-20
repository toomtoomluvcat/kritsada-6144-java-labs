package beapthong.kritsada.lab3;

import java.util.Scanner;

public class NumberGuessingGames {

    /*
     * The Configurable Number Guessing Game Program:
     * This program lets the user configure the min value, max value, and
     * maximum number of tries. The user guesses a random number within the range,
     * and the program provides hints. After each game, the user can choose
     * to play again with the same configuration or quit the game.
     *
     * Author: Kritsada Beapthong
     * ID: 673040614-4
     * Section: 2
     * Last Update: 12/06/2567
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Prompt for initial configuration
        int[] range = configureRange();
        int maxTries = configureMaxTries();

        // Start the game loop
        do {
            playGame(range[0], range[1], maxTries);
        } while (wantsToPlayAgain());

        System.out.println("Thank you for playing our games. Bye!");
    }

    /**
     * Configure the range (min and max values).
     */
    public static int[] configureRange() {
        System.out.print("Enter min value: ");
        int minValue = sc.nextInt();
        int maxValue;

        while (true) {
            System.out.print("Enter max value: ");
            maxValue = sc.nextInt();
            if (maxValue >= minValue) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value.");
        }
        return new int[]{minValue, maxValue};
    }

    /**
     * Configure the maximum number of tries.
     */
    public static int configureMaxTries() {
        System.out.print("Enter maximum number of tries: ");
        int maxTries;

        while (true) {
            maxTries = sc.nextInt();
            if (maxTries > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0.");
        }
        return maxTries;
    }

    /**
     * Play the guessing game with the given range and number of tries.
     */
    public static void playGame(int min, int max, int maxTries) {
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println(("Welcome to a number guessing game!"));

        for (int i = 1; i <= maxTries; i++) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = sc.nextInt();

            // Validate range of guess
            while (guess < min || guess > max) {
                System.out.println(String.format("The number must be between %d and %d.", min, max));
                System.out.print("Enter an integer between " + min + " and " + max + ": ");
                guess = sc.nextInt();
            }

            if (guess == randomValue) {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + i + (i == 1 ? " time" : " times"));
                return;
            } else if (i < maxTries) {
                System.out.println(guess > randomValue ? "Try a lower number!" : "Try higher number!");
            } else {
                System.out.println("You have tried " + i + (i == 1 ? " time" : " times"));
                System.out.println(String.format("The answer is %d.", randomValue));
            }
        }
    }

    /**
     * Check if the user wants to play the game again.
     */
    public static boolean wantsToPlayAgain() {
        System.out.print("Want to play again? (Y or y): ");
        sc.nextLine(); // Clear the buffer
        String response = sc.nextLine();
        return response.equalsIgnoreCase("y");
    }
}
