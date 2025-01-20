package beapthong.kritsada.lab6;

import java.util.Scanner;

/**
 * This program implements an interactive Number Guessing Game using object-oriented programming.
 * The game allows the user to configure the range of numbers and the maximum number of attempts.
 * Players guess numbers until they win or exhaust the allowed number of tries.
 * The program provides options to replay the game and reconfigure the settings.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
public class NumberGuessingOOPGame {

    // Scanner object for taking user input
    public static Scanner input = new Scanner(System.in);

    // GuessGame object to manage the game's logic
    private GuessGame game;

    /**
     * Configures the game by taking user inputs for the minimum and maximum values
     * and the maximum number of attempts. 
     * If the user does not specify the maximum number of attempts, a default value is used.
     */
    public void configure() {
        int defaultMaxTries = 10; // Default number of attempts
        this.game = new GuessGame(); // Initialize the game object

        // Take user inputs for minimum and maximum values
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // Configure the game with default maximum attempts
        this.game.configureGame(min, max, defaultMaxTries);

        // Allow user to specify a custom maximum number of attempts
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();
        this.game.configureGame(min, max, maxTries);
    }

    /**
     * Plays the game in a loop until the user chooses to quit.
     * The user is informed whether they win or lose after each round.
     */
    public void playGame() {
        boolean playAgain;

        do {
            // Play a single game and display the result
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");

            // Ask the user if they want to play again
            System.out.print("Do you want to play again (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");

            // Reconfigure the game if the user chooses to play again
            if (playAgain) {
                configure();
            }
        } while (playAgain);

        // Display a thank-you message when the game ends
        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    /**
     * Main method to start the program.
     * Initializes the game configuration and begins the gameplay loop.
     */
    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGame();
    }
}
