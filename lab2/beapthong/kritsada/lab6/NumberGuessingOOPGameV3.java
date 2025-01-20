package beapthong.kritsada.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    /**
     * This program implements an updated version of the Number Guessing Game
     * (V3) using object-oriented programming. The game allows users to
     * configure the range of numbers, the maximum number of attempts, and keeps
     * track of game records. It utilizes the `GuessGameV3` class for extended
     * functionality including record-keeping and logging. Players can replay
     * the game, view records, and reconfigure the settings as desired.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */

    // Scanner object to read user input
    public static Scanner input = new Scanner(System.in);

    // Instance of GuessGameV3 to handle the game logic
    private GuessGameV3 game;

    /**
     * Configures the game by prompting the user to input the minimum and
     * maximum range, and the maximum number of tries. Initializes the game with
     * the configured values.
     */
    public void configure() {
        int defualtMaxTires = 10; // Default maximum tries
        this.game = new GuessGameV3();
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        this.game.configureGame(min, max, defualtMaxTires);
        min = this.game.getMin();
        max = this.game.getMax();
        System.out.print("Enter the maximum number of tires: ");
        int maxTries = input.nextInt();
        this.game.configureGame(min, max, maxTries);
    }

    /**
     * Runs the main gameplay loop. Allows users to play the game, view game
     * records, or quit the application.
     */
    public void playGame() {
        this.game.playSingleGame(); // Starts the game
        GuessGameV3.addGameRecord(game); // Adds the completed game to records
        while (true) {
            // Menu options for the user
            System.out.println("Do you want to:");
            System.out.println("1.Play again\n2.view game record\n3.quit");
            int options = input.nextInt();

            switch (options) {
                case 1 -> { // Play again
                    configure();
                    playGame();
                    break;
                }
                case 2 -> { // View game records
                    GuessGameV3.getGameLog();
                    continue;
                }
                case 3 -> { // Quit the game
                    System.out.println("Thank you for Playing the Number Guessing Game 3!");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * The entry point of the program. Initializes and starts the game.
     */
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure(); // Configure the game settings
        program.playGame();  // Start the game
    }
}
