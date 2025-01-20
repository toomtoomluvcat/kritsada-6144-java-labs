/**
 * This class implements the basic functionality for a Number Guessing Game.
 * It handles game configuration, answer generation, and tracks player attempts.
 * The game allows the player to guess a number within a specified range and 
 * provides feedback whether the guess is too high or too low.
 * The game ends either when the player guesses the correct number or exhausts 
 * the allowed number of attempts.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */

 package beapthong.kritsada.lab6;

 public class GuessGame {
 
     private int min;               // Minimum value of the range
     private int max;               // Maximum value of the range
     private int maxTries;          // Maximum number of attempts
     private int answer;            // The correct answer to be guessed
     private int attempts;          // Number of attempts made by the player
 
     /**
      * Default constructor initializing the game with default values.
      * min = 1, max = 100, maxTries = 10, answer = 0, attempts = 0
      */
     public GuessGame() {
         this.min = 1;
         this.max = 100;
         this.maxTries = 10;
         this.answer = 0;
         this.attempts = 0;
     }
 
     /**
      * Constructor initializing the game with user-specified values.
      * 
      * @param min The minimum value of the range
      * @param max The maximum value of the range
      * @param maxTries The maximum number of attempts allowed
      */
     public GuessGame(int min, int max, int maxTries) {
         this.min = min;
         this.max = max;
         this.maxTries = maxTries;
     }
 
     /**
      * Configures the game with the provided minimum, maximum, and maximum 
      * attempts values.
      * 
      * @param min The minimum value of the range
      * @param max The maximum value of the range
      * @param maxTries The maximum number of attempts allowed
      */
     public void configureGame(int min, int max, int maxTries) {
         this.min = min;
         this.max = max;
         this.maxTries = maxTries;
     }
 
     /**
      * Gets the minimum value of the range.
      * 
      * @return The minimum value
      */
     public int getMin() {
         return this.min;
     }
 
     /**
      * Gets the maximum value of the range.
      * 
      * @return The maximum value
      */
     public int getMax() {
         return this.max;
     }
 
     /**
      * Gets the maximum number of attempts allowed.
      * 
      * @return The maximum number of attempts
      */
     public int getMaxTries() {
         return this.maxTries;
     }
 
     /**
      * Sets the maximum number of attempts and returns the updated value.
      * 
      * @param maxTries The new maximum number of attempts
      * @return The updated maximum number of attempts
      */
     public int setMaxTries(int maxTries) {
         this.maxTries = maxTries;
         return this.maxTries;
     }
 
     /**
      * Gets the current answer (the number to be guessed).
      * 
      * @return The correct answer
      */
     public int getAnswer() {
         return this.answer;
     }
 
     /**
      * Sets the correct answer (the number to be guessed).
      * 
      * @param answer The correct answer
      */
     public void setAnswer(int answer) {
         this.answer = answer;
     }
 
     /**
      * Gets the number of attempts made so far.
      * 
      * @return The number of attempts
      */
     public int getAttempt() {
         return this.attempts;
     }
 
     /**
      * Sets the number of attempts made so far.
      * 
      * @param attemps The number of attempts made
      */
     public void setAttemp(int attemps) {
         this.attempts = attemps;
     }
 
     /**
      * Sets the minimum value of the range.
      * 
      * @param min The new minimum value
      */
     public void setMin(int min) {
         this.min = min;
     }
 
     /**
      * Sets the maximum value of the range.
      * 
      * @param max The new maximum value
      */
     public void setMax(int max) {
         this.max = max;
     }
 
     /**
      * Generates a random number between min and max to be guessed.
      */
     public void generateAnswer() {
         this.answer = (int) (Math.random() * (this.max - this.min + 1) + this.min);
     }
 
     /**
      * Runs the game where the player is asked to guess a number.
      * Provides feedback after each guess and ends the game when the correct 
      * answer is guessed or when the maximum attempts are used up.
      * 
      * @return true if the player guessed correctly, false otherwise
      */
     public boolean playSingleGame() {
         generateAnswer(); // Generate the correct answer
         System.out.println("Welcome to the Number Guessing Game!");
         for (int i = 0; i < this.maxTries; i++) {
             // Prompt the player for a guess
             System.out.print(String.format("Enter a number between %d and %d: ", this.min, this.max));
             int guesses = NumberGuessingOOPGame.input.nextInt();
             if (guesses != this.answer && i + 1 == maxTries) { // Max tries reached
                 System.out.println(String.format("Sorry, you've used all your attempts. The correct answer was: %d", this.answer));
                 return false; // Player lost
             } else if (guesses == this.answer) { // Player guessed correctly
                 System.out.println(String.format(i == 0
                         ? ("Congratulations! You've guessed the number in %d attempt.")
                         : ("Congratulations! You've guessed the number in %d attempts."), i + 1));
                 return true; // Player won
             } else {
                 // Provide feedback based on the guess
                 System.out.println(guesses < this.answer ? "Try a higher number!" : "Try a lower number!");
             }
         }
         return true; // The loop ends here if the guess was not correct within the maxTries
     }
 
 }
 