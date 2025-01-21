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

        while (true) {
            // Menu options for the user
            System.out.println("Do you want to:");
            System.out.println("1.Play again\n2.view game record\n3.quit");
            int options = input.nextInt();

            switch (options) {
                case 1 -> {
                    configure();
                    game.playSingleGame();
                }
                case 2 -> {
                    viewRecords();
                }
                case 3 -> {
                    System.out.println("Thank you for playing the Number Guessing Game 3!");
                    System.exit(0);
                }
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Displays game records base d on user choice: - Option 1: Shows all
     * recorded games. - Option 2: Prompts the user for a specific game number
     * and displays its details. Validates user input and handles invalid
     * choices gracefully.
     */

    public void viewRecords() {
        GuessGameV3[] records = GuessGameV3.getGameRecords();

        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Records");

        int recordOption = input.nextInt();

        if (recordOption == 1) {
            for (int i = 0; i < GuessGameV3.getRecordCount(); i++) {
                System.out.println("GAME " + (i + 1) + ": " + records[i].getGameLog());
            }
        } else if (recordOption == 2) {

            System.out.print("Enter the game number to view: ");
            int recordNumber = input.nextInt();

            if (recordNumber > 0 && recordNumber <= GuessGameV3.getRecordCount()) {
                System.out.println("GAME " + (recordNumber) + ": " + records[recordNumber - 1].getGameLog());
            } else {
                System.out.println("No record found for the selected game number.");

            }
        } else {
            System.out.println("Invalid option. Returning to the main menu.");

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
