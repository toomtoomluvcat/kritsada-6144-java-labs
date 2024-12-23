package beapthong.kritsada.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV3 {

    /*
 * The Configurable Number Guessing Game program:
 * 
 * This Java program is a customizable number guessing game that allows the user to 
 * specify the range of numbers and the maximum number of attempts. The goal is for the 
 * user to guess a randomly generated number within the specified range (between min and max 
 * values) and within a given number of tries. The game provides feedback after each guess,
 * guiding the user whether to guess a higher or lower number. If the user guesses correctly, 
 * they win the game, and their performance is recorded.
 *
 * The program keeps track of the following:
 * - The total number of games played.
 * - The number of games won.
 * - The high score, which is the lowest number of guesses taken to win a game.
 * 
 * Additionally, the program offers a game log feature, allowing the user to view all guesses made
 * during a game, or display a specific guess, thus providing an in-depth view of the game's progression.
 *
 * The gameplay continues until the user chooses not to play again. At the end of each game, the
 * program displays a summary of all gameplay statistics, including the total number of games played,
 * total wins, win ratio, and the high score.
 *
 * This program demonstrates the use of loops, conditionals, and basic data structures such as arrays 
 * to manage guesses and game states. It also includes several methods that organize the different 
 * functionalities of the game, including input validation, feedback generation, and game logging.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
     */
    static int minValue; // Minimum value for guessing range
    static int maxValue; // Maximum value for guessing range
    static int answer; // The correct answer to guess
    static int guessValue; // The player's current guess
    static int tires; // Maximum number of attempts allowed
    static int gamePlayed = 0; // Total number of games played
    static int gameWin = 0; // Total number of games won
    static int highScore=10; // Best score (lowest number of guesses)
    static int sumOfguess=0; //sum of all round player guess
    static boolean arePlayerWin = true; // Indicates if the player has won
    static Scanner input = new Scanner(System.in); // Scanner for user input
    static int[] answerArray = new int[10]; // Array to store player's guesses

    public static void main(String[] args) {
        configure(); // Set up game configuration
        playGames(); // Start the game
        displayStatic(); // Display game statistics
        input.close(); // Close the scanner
    }

    // Method to configure the game settings
    public static void configure() {
        System.out.print("Enter the min value: ");
        minValue = input.nextInt();
        System.out.print("Enter the max value: ");
        maxValue = input.nextInt();
        checkValidRange(); // Ensure max value is not less than min value
        System.out.print("Enter the maximum number of tires: ");
        tires = input.nextInt();
        checkValidTires(); // Ensure tires is greater than 0
        input.nextLine(); // Clear the buffer after reading integers
    }

    // Method to check if the max value is valid
    public static void checkValidRange() {
        while (maxValue < minValue) {
            System.out.println("The max value must be at least equal to min value");
            System.out.print("Enter the max value: ");
            maxValue = input.nextInt();
        }
    }

    // Method to check if the tires value is valid
    public static void checkValidTires() {
        while (tires < 1) {
            System.out.println("The maximum number of tires must be greater than 0");
            System.out.print("Enter the maximum number of tires: ");
            tires = input.nextInt();
        }
    }

    // Method to validate the player's guess is within the valid range
    public static void checkValidGuess() {
        while (guessValue < minValue || guessValue > maxValue) {
            System.out.println(String.format("The number must be between %d and %d", minValue, maxValue));
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
        }
    }

    // Method to generate a random answer for the guessing game
    public static void genAnswer() {
        answer = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    // Method to give the player a hint to guess higher or lower
    public static void highLow() {
        if (guessValue > answer) {
            System.out.println("Try lower number!");
        } else {
            System.out.println("Try higher number!");
        }
    }

    // Method to log the game details (answer, guesses, win status)
    public static void showGamgeLog(int attemp) {
        System.out.println("Game log:Answer: " + answer + ", Guesses: " + (attemp + 1) + ", Win: " + arePlayerWin);
    }

    // Method to display a loop for showing guesses during the game
    public static void displayGuessesLoop(int attemp) {
        while (displayGuesses(attemp)) {
        }
        if (attemp+1 < highScore) {
            highScore = attemp+1; // Update high score if the current attempt is better
        }
        showGamgeLog(attemp); // Display the game log
        sumOfguess += (attemp+1); //+value 
        playGames(); // Ask the player if they want to play again
    }

    // Method to handle displaying guesses when requested
    public static boolean displayGuesses(int attemp) {
        System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any key to quit: ");
        String wantToShow = input.nextLine();
        if (wantToShow.equalsIgnoreCase("a")) {
            displayComprehensive(attemp); // Display all guesses
        } else if (wantToShow.equalsIgnoreCase("g")) {
            System.out.print("Enter the guess number: ");
            int count = input.nextInt();
            input.nextLine();
            if (count > 0 && count <= answerArray.length && answerArray[count - 1] != 0) {
                System.out.println(String.format("Guess %d: %d", count, answerArray[count - 1])); // Display specific guess
            } else {
                System.out.println("Invalid guess number!"); // Invalid guess number
            }
        } else {
            return false; // Quit the loop
        }
        return true;
    }

    // Method to display all guesses made so far
    public static void displayComprehensive(int attemp) {
        for (int i = 0; i <= attemp; i++) {
            System.out.println(String.format("Guess %d: %d", i + 1, answerArray[i]));
        }
    }

    // Method to handle the main game flow
    public static void playGames() {
        if (gamePlayed != 0) {
            System.out.print("Want to play again (Y or y): ");
            String wantplay = input.nextLine();
            if (wantplay.equalsIgnoreCase("y")) {
                gamePlayed++; // Increment game played count
                playGame(); // Start a new game
            } else {
                System.out.println("Thank you for playing our game. Bye!"); // Exit message
            }
        } else {
            gamePlayed++; // Start the first game
            playGame();
        }
    }

    // Method to handle the actual guessing game
    public static void playGame() {
        genAnswer(); // Generate a new random answer
        System.out.println("Welcome to a number guessing game!");
        for (int i = 0; i < tires; i++) {
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            input.nextLine();
            checkValidGuess(); // Validate the guess
            answerArray[i] = guessValue; // Store the guess
            if (answer != guessValue && (i + 1) == tires) {
                arePlayerWin = false; // Player loses if they've used all attempts
                System.out.println(i == 0
                        ? "You have tried " + (i + 1) + " time."
                        : "You have tried " + (i + 1) + " times.");
                displayGuessesLoop(i); // Display guesses and log
                break;
            } else if (answer != guessValue) {
                highLow(); // Give the player a hint
            } else {
                System.out.println("Congratulations!"); // Player wins
                System.out.println(i == 0
                        ? "You have tried " + (i + 1) + " time."
                        : "You have tried " + (i + 1) + " times.");
                arePlayerWin = true;
                displayGuessesLoop(i); // Display guesses and log
                gameWin++; // Increment game win count
                break;
            }
        }
    }

    // Method to display game statistics at the end
    public static void displayStatic() {
        System.out.println("==== All Game Status ====");
        System.out.println(String.format("Total gameplay: %d", gamePlayed)); // Display total games played
        System.out.println(String.format("Total game wins: %d", gameWin)); // Display total games won
        System.out.println(String.format("Win ratio: %.1f %%" , ((double) gameWin / gamePlayed) * 100)); // Display win ratio
        System.out.println(String.format("Average number of guesses per game: %.1f",((double) sumOfguess/gamePlayed)));
        System.out.println(String.format("High score (the lowest number of guesses): %d", (gameWin != 0 ? highScore : 0))); // Display high score
    }
}
