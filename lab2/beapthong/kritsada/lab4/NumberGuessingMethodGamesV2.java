/*
 * The Configurable Number Guessing Game program:
 * 
 * This Java program allows the user to play a number guessing game where they must guess a
 * randomly generated number within a specified range (minValue to maxValue). The user has
 * a limited number of attempts (tires) to guess the number correctly. The game provides feedback
 * after each guess, indicating whether the user should guess higher or lower.
 * 
 * Key Features:
 * - The user is prompted to enter a minimum and maximum value for the range of the random number.
 * - The user specifies the maximum number of attempts allowed (tires) to guess the number.
 * - The program validates user input to ensure that the guesses are within the specified range.
 * - After each incorrect guess, the user is given a hint to guess higher or lower.
 * - The user can view all previous guesses or a specific guess at any point during the game.
 * - The game allows multiple rounds. After each round, the user is asked if they want to play again.
 * - After finishing a round, the program will display the number of attempts made and show the correct answer.
 * 
 * The game continues until the user decides not to play any longer, at which point the program
 * exits and thanks the user for playing. The program keeps track of each round and its associated guesses.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 * Last updated: 12/06/2567
 */

 package beapthong.kritsada.lab4;

 import java.util.Scanner;
 
 public class NumberGuessingMethodGamesV2 {
 
     // Variables to store game configuration values and states
     static int minValue;
     static int maxValue;
     static int answer;               // The randomly generated answer
     static int guessValue;           // The user's current guess
     static int tires;                // Maximum number of attempts allowed
     static int roundOfGame = 1;      // Tracks the current round number
     static Scanner input = new Scanner(System.in);
     static int[] answerArray = new int[10];  // Array to store the guesses made by the user
 
     public static void main(String[] args) {
         // Configure the game settings, then start playing the game
         configure();
         playGames();
         input.close();  // Close the scanner when done to avoid resource leak
     }
 
     // Method to configure the game settings: range, tries, etc.
     public static void configure() {
         System.out.print("Enter the min value: ");
         minValue = input.nextInt();  // User input for min value
         System.out.print("Enter the max value: ");
         maxValue = input.nextInt();  // User input for max value
         checkValidRange();           // Check if max value is valid
         System.out.print("Enter the maximum number of tries: ");
         tires = input.nextInt();     // User input for max tries
         checkvalidtries();           // Validate that the number of tries is greater than 0
         input.nextLine();            // Clear the buffer for next line input
     }
 
     // Method to ensure maxValue is greater than or equal to minValue
     public static void checkValidRange() {
         while (maxValue < minValue) {
             System.out.println("The max value must be at least equal min value");
             System.out.print("Enter the max value: ");
             maxValue = input.nextInt();  // Prompt user to re-enter max value if invalid
         }
     }
 
     // Method to ensure that the user enters a valid number of tries (greater than 0)
     public static void checkvalidtries() {
         while (tires < 1) {
             System.out.println("The maximum number of tries must be greater than 0");
             System.out.print("Enter the maximum number of tires: ");
             tires = input.nextInt();  // Prompt user to re-enter tries if invalid
         }
     }
 
     // Method to check if the user's guess is within the valid range
     public static void checkValidGuess() {
         while (guessValue < minValue || guessValue > maxValue) {
             System.out.println(String.format("The number must be between %d and %d ", minValue, maxValue));
             System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
             guessValue = input.nextInt();  // Prompt user for a valid guess
         }
     }
 
     // Method to generate a random number as the answer within the specified range
     public static void genAnswer() {
         answer = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
     }
 
     // Method to give hints if the user's guess is too high or too low
     public static void highLow() {
         if (guessValue > answer) {
             System.out.println("Try lower number!");  // If guess is too high
         } else {
             System.out.println("Try higher number!"); // If guess is too low
         }
     }
 
     // Method to loop and display all guesses or a specific guess based on user input
     public static void displayGuessesLoop() {
         while (displayGuesses()) {
         }
         playGames();  // Allow user to play again after viewing guesses
     }
 
     // Method to prompt user for whether they want to view guesses or quit
     public static boolean displayGuesses() {
         System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any key to quit: ");
         String wantToShow = input.nextLine();  // User input for viewing guesses
         if (wantToShow.equalsIgnoreCase("a")) {
             displayComprehensive();  // Display all previous guesses
         } else if (wantToShow.equalsIgnoreCase("g")) {
             System.out.print("Enter the guess number: ");
             int count = input.nextInt();  // Prompt user for a specific guess
             input.nextLine();
             if (count > 0 && count <= answerArray.length && answerArray[count - 1] != 0) {
                 System.out.println(String.format("Guess %d: %d", count, answerArray[count - 1]));  // Show specific guess
             } else {
                 System.out.println("Invalid guess number!");  // Error handling for invalid guess number
             }
         } else {
             return false;  // Exit the display loop
         }
         return true;
     }
 
     // Method to display all guesses made by the user so far
     public static void displayComprehensive() {
         int count = 0;
         for (int value : answerArray) {
             count++;
             if (value != 0) {
                 System.out.println(String.format("Guess %d: %d", count, value));  // Display each guess
             } else {
                 break;  // Stop if there are no more guesses
             }
         }
     }
 
     // Method to prompt the user if they want to play again after completing a round
     public static void playGames() {
         if (roundOfGame != 1) {
             System.out.print("Want to play again (Y or y): ");
             String wantplay = input.nextLine();  // Ask if the user wants to play again
             if (wantplay.equalsIgnoreCase("y")) {
                 roundOfGame++;  // Increment round number for new round
                 playGame();  // Start new game
             } else {
                 System.out.println("Thank you for playing our game. Bye!");  // Exit if user doesn't want to play again
             }
         } else {
             roundOfGame++;  // Start the first round of the game
             playGame();
         }
     }
 
     // The main game logic: the user guesses the number within the allowed number of tries
     public static void playGame() {
         genAnswer();  // Generate a random answer for this round
         System.out.println("Welcome to a number guessing game!");  // Game start message
         for (int i = 0; i < tires; i++) {
             System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));  // Prompt for guess
             guessValue = input.nextInt();  // User's guess
             input.nextLine();  // Clear the buffer
             checkValidGuess();  // Validate guess range
             answerArray[i] = guessValue;  // Store the guess in the array
 
             if (answer != guessValue && (i + 1) == tires) {
                 // If user fails to guess within the allowed attempts, show the correct answer
                 System.out.println(i == 0
                         ? "You have tried " + (i + 1) + " time."
                         : "You have tried " + (i + 1) + " times.");
                 System.out.println(String.format("The answer is %d", answer));
                 displayGuessesLoop();  // Show guesses and ask if user wants to play again
             } else if (answer != guessValue) {
                 highLow();  // Provide hint to guess higher or lower
             } else {
                 // If user guesses correctly, display a success message
                 System.out.println("Congratulations!");
                 System.out.println(String.format(i == 0
                         ? "You have tried 1 time"
                         : "You have tried %d times", i + 1));
                 displayGuessesLoop();  // Show guesses and ask if user wants to play again
                 break;
             }
         }
     }
 }
 