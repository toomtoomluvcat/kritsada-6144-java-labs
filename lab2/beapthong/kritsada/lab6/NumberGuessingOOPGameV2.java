package beapthong.kritsada.lab6;

import java.util.Scanner;

/**
 * This program implements an updated version of the Number Guessing Game (V2) 
 * using object-oriented programming. The game allows users to configure the 
 * range of numbers and the maximum number of attempts. It also uses an updated 
 * `GuessGameV2` class for enhanced functionality. Players can replay the game 
 * and reconfigure the settings as desired.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
public class NumberGuessingOOPGameV2 {

    // Scanner object for taking user input
    public static Scanner input = new Scanner(System.in);

    // GuessGameV2 object to manage the game's logic
    private GuessGameV2 game2;

    /**
     * Configures the game by taking user inputs for the minimum and maximum values
     * and the maximum number of attempts. 
     * It also ensures that valid min and max values are used from the GuessGameV2 object.
     */
    public void configure() {
        int defaultMaxTries = 10; // Default number of attempts
        this.game2 = new GuessGameV2(); // Initialize the game object

        // Take user inputs for minimum and maximum values
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // Configure the game with default maximum attempts
        this.game2.configureGame(min, max, defaultMaxTries);

        // Update min and max values based on the game's validation
        min = this.game2.getMin();
        max = this.game2.getMax();

        // Allow user to specify a custom maximum number of attempts
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();
        this.game2.configureGame(min, max, maxTries);
    }

    /**
     * Plays the game in a loop until the user chooses to quit.
     * After each game, the user is informed whether they win or lose.
     */
    public void playGame() {
        boolean playAgain;

        do {
            // Play a single game and display the result
            boolean result = this.game2.playSingleGame();
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
        System.out.println("Thank you for playing the Number Guessing Game V2!");
    }

    /**
     * Main method to start the program.
     * Initializes the game configuration and begins the gameplay loop.
     */
    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();
        program.playGame();
    }
}
