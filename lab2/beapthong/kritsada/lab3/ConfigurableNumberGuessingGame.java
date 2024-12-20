package beapthong.kritsada.lab3;

import java.util.Scanner;

/*
    * The Configurable Number Guessing Game program:
    * This program asks the user to enter the min value, max value, and maximum number of tries.
    * The user must guess a randomly generated number between the min and max values
    * within the specified number of tries.
    * 
    * Author: Kritsada Beapthong
    * ID: 673040614-4
    * Sec: 2
    * Last updated: 12/06/2567
*/

public class ConfigurableNumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the minimum value
        System.out.print("Enter the min value: ");
        int minValue = sc.nextInt();
        int maxValue;

        // Get the maximum value (must be greater than or equal to min value)
        while (true) {
            System.out.print("Enter the max value: ");
            maxValue = sc.nextInt();
            if (maxValue < minValue) {
                System.out.println("The max value must be at least equal to the min value.");
            } else {
                break;
            }
        }

        int maxAttempts;

        // Get the maximum number of tries (must be greater than 0)
        while (true) {
            System.out.print("Enter the maximum number of tries: ");
            maxAttempts = sc.nextInt();
            if (maxAttempts <= 0) {
                System.out.println("The maximum number of tries must be greater than 0.");
            } else {
                break;
            }
        }

        // Generate a random number between minValue and maxValue
        int randomInt = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;

        System.out.println("Welcome to the Number Guessing Game!");
        int attemptsUsed = 0;

        // Game loop
        while (attemptsUsed < maxAttempts) {
            System.out.print("Enter an integer between " + minValue + " and " + maxValue + ": ");
            int guessedNumber = sc.nextInt();

            // Check if the guess is out of range
            if (guessedNumber < minValue || guessedNumber > maxValue) {
                System.out.println("The number must be between " + minValue + " and " + maxValue + ".");
                continue; // Do not count this as an attempt
            }

            // Increment the number of attempts
            attemptsUsed++;

            // Check the guessed number
            if (guessedNumber > randomInt) {
                System.out.println("Try a lower number!");
            } else if (guessedNumber < randomInt) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + attemptsUsed + (attemptsUsed == 1 ? " time" : " times"));
                attemptsUsed=0;
                break; // Exit the loop if guessed correctly
            }
        }

        // If the user ran out of attempts
        if (attemptsUsed == maxAttempts) {
            System.out.println("You ran out of guesses.");
            System.out.println("The answer is " + randomInt);
        }

        sc.close();
    }
}
