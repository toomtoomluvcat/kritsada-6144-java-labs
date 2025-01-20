/**
 * This class extends the GuessGame class and provides an enhanced version of the 
 * number guessing game with additional validation for inputs and improved 
 * game configuration. It allows players to specify the min and max values 
 * for the guessing range, as well as the maximum number of attempts. 
 * The game ensures the input values are valid before proceeding.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */

 package beapthong.kritsada.lab6;

 public class GuessGameV2 extends GuessGame {
     
     /**
      * Default constructor that initializes the game with default values.
      */
     public GuessGameV2() {
         super();
     }
     
     /**
      * Constructor initializing the game with user-specified values.
      * 
      * @param min The minimum value of the range
      * @param max The maximum value of the range
      * @param maxTries The maximum number of attempts allowed
      */
     public GuessGameV2(int min, int max, int maxTries) {
         super(min, max, maxTries);
     }
 
     /**
      * Configures the game with validated minimum, maximum, and maximum attempts values.
      * It ensures the max value is greater than or equal to the min value,
      * and that the maxTries is greater than 0.
      * 
      * @param min The minimum value of the range
      * @param max The maximum value of the range
      * @param maxTries The maximum number of attempts allowed
      */
     @Override
     public void configureGame(int min, int max, int maxTries) {
         int NewMinvalue = min;
         int newMaxValue = max;
         int newMaxTries = maxTries;
         
         // Ensure max is greater than or equal to min
         while (newMaxValue <= NewMinvalue) {
             System.out.println("Invalid Input: max must be greater than or equal to min.");
             System.out.print("Enter the min value: ");
             NewMinvalue = NumberGuessingOOPGameV2.input.nextInt();
             System.out.print("Enter the max value: ");
             newMaxValue = NumberGuessingOOPGameV2.input.nextInt();
         }
         setMin(NewMinvalue);
         setMax(newMaxValue);
         
         // Ensure maxTries is greater than 0
         while (newMaxTries <= 0) {
             System.out.println("Invalid input: MaxTries must be greater than 0.");
             System.out.print("Enter the maximum number of tries: ");
             newMaxTries = NumberGuessingOOPGame.input.nextInt();
         }
         setMaxTries(newMaxTries);
     }
 
     /**
      * Runs the game where the player is asked to guess a number, with validation 
      * for the guess being within the specified range. Provides feedback after each guess 
      * and ends the game when the correct answer is guessed or the maximum attempts 
      * are used up.
      * 
      * @return true if the player guessed correctly, false otherwise
      */
     @Override
     public boolean playSingleGame() {
         generateAnswer(); // Generate the correct answer
         int min = getMin();
         int max = getMax();
         int maxTries = getMaxTries();
         int answer = getAnswer();
         System.out.println(toString()); // Display game configuration
         System.out.println("Welcome to the Number Guessing GameV2!");
         
         for (int i = 0; i < maxTries; i++) {
             // Prompt the player for a guess and validate the input
             System.out.print(String.format("Enter a number between %d and %d: ", min, max));
             int guesses = NumberGuessingOOPGame.input.nextInt();
             while (guesses < min || guesses > max) {
                 System.out.println(String.format("The number must be between %d and %d.", min, max));
                 System.out.print(String.format("Enter a number between %d and %d: ", min, max));
                 guesses = NumberGuessingOOPGame.input.nextInt();
             }
             
             // Check if the guess is correct or if the max attempts are reached
             if (guesses != answer && i + 1 == maxTries) {
                 System.out.println(String.format("Sorry, you've used all your attempts. The correct answer was: %d", answer));
                 return false; // Player lost
             } else if (guesses == answer) {
                 System.out.print("Congratulations! You've guessed the number in " + (i + 1));
                 System.err.println(i == 0 ? " attempt." : " attempts.");
                 return true; // Player won
             } else {
                 // Provide feedback based on the guess
                 System.out.println(guesses < answer ? "Try a higher number!" : "Try a lower number!");
             }
         }
         return true; // The loop ends here if the guess was not correct within the maxTries
     }
 
     /**
      * Provides a string representation of the current game configuration.
      **/
     public String toString() {
         int min = getMin();
         int max = getMax();
         int maxTries = getMaxTries();
         
         return "Game Configuration: [Min: " + min + 
                ", Max: " + max + 
                ", Max Tries: " + maxTries + 
                ", Attempt: 0]";
     }
 }
 