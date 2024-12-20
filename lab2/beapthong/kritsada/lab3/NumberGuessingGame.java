package beapthong.kritsada.lab3;

/*
    * The Number Guessing Game Program
    * The game will randomly generate a number between a given minimum and maximum value.
    * The player has 5 chances to guess the number. 
    * The program will give feedback whether the guessed number is too high, too low, or correct.
    * The game ends when the player guesses correctly or exhausts their attempts.

    Author: Kritsada Beapthong
    ID: 673040614-4
    Sec: 2
    Last updated: 12/06/2567
*/

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        // Declare variables
        Scanner sc = new Scanner(System.in);
        int minValue = 1;
        int maxValue = 10;
        int randomInt = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        int maxTries = 5;  // Number of attempts the player has
        int attempts = 0;

        // Start the game!
        System.out.println("Welcome to a number guessing game!");

        while (attempts < maxTries) {
            System.out.print("Enter an integer between " + minValue + " and " + maxValue + ": ");
            int guess = sc.nextInt();
            attempts++;

            // Provide hints
            if (guess > randomInt) {
                System.out.println("Try a lower number!");
            } else if (guess < randomInt) {
                System.out.println("Try a higher number!");
            } else {
                // If the guess is correct
                System.out.println("Congratulations!");
                System.out.println("You have tried " + attempts + (attempts == 1 ? " time" : " times"));
                attempts=0;
                break;
            }
        }

        // If the player runs out of attempts
        if (attempts == maxTries) {
            System.out.println("You have tried " + maxTries + " times. You ran out of guesses.");
            System.out.println("The answer is " + randomInt);
        }

        sc.close();
    }
}
