/**
 * This class extends GuessGameV2 and adds functionality for keeping track of
 * game records. It allows for storing multiple games, displaying complete
 * records, and viewing specific game details. The class also introduces a
 * new feature to limit the maximum number of games that can be played.
 *
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
package beapthong.kritsada.lab6;

public class GuessGameV3 extends GuessGameV2 {

    // Maximum number of games allowed to be played
    private static final int MAX_GAME = 100;

    // Array to store game records
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAME];

    // Index to track the current position in the gameRecords array
    private static int recordIndex = 0;

    // Array to store the guesses made by the player
    private int[] guesses;

    // The count of guesses made by the player
    private int guessCount;

    // Boolean to track if the player won the game
    private boolean win;

    /**
     * Default constructor initializing the game with default values.
     */
    public GuessGameV3() {
        super();
        this.guessCount = 0;
        this.win = false;
        guesses = new int[getMaxTries()];
    }

    /**
     * Constructor initializing the game with user-specified values.
     *
     * @param min The minimum value of the range
     * @param max The maximum value of the range
     * @param maxTries The maximum number of attempts allowed
     */
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries);
        this.guessCount = 0;
        this.win = false;
        guesses = new int[maxTries];
    }

    /**
     * Configures the game with validated minimum, maximum, and maximum attempts
     * values. Ensures the max value is greater than or equal to the min value,
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
            NewMinvalue = NumberGuessingOOPGame.input.nextInt();
            System.out.print("Enter the max value: ");
            newMaxValue = NumberGuessingOOPGame.input.nextInt();
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
        this.guessCount = 0;
        this.win = false;
        guesses = new int[getMaxTries()];
    }

    /**
     * Runs the game where the player is asked to guess a number, with
     * validation for the guess being within the specified range. Provides
     * feedback after each guess and ends the game when the correct answer is
     * guessed or the maximum attempts are used up. If the game exceeds the
     * maximum number of games, it stops the game.
     */
    @Override
    public boolean playSingleGame() {

        generateAnswer(); // Generate the correct answer
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int answer = getAnswer();
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
        setAttemp(0);

        // Loop for the player's guesses within the allowed number of attempts
        for (int i = 0; i < maxTries; i++) {
            this.guessCount++;
            System.out.print(String.format("Enter a number between %d and %d: ", min, max));
            int playerGuesses = NumberGuessingOOPGameV3.input.nextInt();

            // Validate if the guess is within the specified range
            while (playerGuesses < min || playerGuesses > max) {
                System.out.println(String.format("The number must be between %d and %d", min, max));
                System.out.print(String.format("Enter a number between %d and %d: ", min, max));
                playerGuesses = NumberGuessingOOPGame.input.nextInt();
            }

            // Store the guess in the guesses array
            guesses[i] = playerGuesses;

            // Check if the guess is correct or if the max attempts are reached
            if (playerGuesses != answer && i + 1 == maxTries) {
                System.out.println(String.format("Sorry, you've used all your attempts. The correct answer was: %d", answer));
                win = false;
                break;
            } else if (playerGuesses == answer) {
                System.out.println(String.format(i == 0
                        ? ("Congratulations! You've guessed the number in %d attempt.")
                        : ("Congratulations! You've guessed the number in %d attempts."), i + 1));
                win = true;
                break;
            } else {
                System.out.println(playerGuesses < answer ? "Try a higher number!" : "Try a lower number!");
            }
        }
        addGameRecord(this);
        return this.win;
    }

    /**
     * Returns the array of all stored game records.
     *
     */
    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    /**
     * Returns the number of games recorded so far.
     *
     *
     */
    public static int getRecordCount() {
        return recordIndex;
    }

    /**
     * Adds a game record to the array of game records.
     *
     */
    public void addGameRecord(GuessGameV3 game) {
        if (getRecordCount() < 100) {
            GuessGameV3 newGame = new GuessGameV3(game.getMin(), game.getMax(), game.getMaxTries());
            newGame.guesses = game.guesses.clone();
            newGame.guessCount = game.guessCount;
            newGame.win = game.win;
            gameRecords[recordIndex] = newGame;
            recordIndex++;
        } else {
            System.out.println("You have reached the maximum limit of game plays.");
        }
    }

    /**
     * Generates a detailed game log summarizing the game configuration and
     * results. This method includes information about the range of numbers,
     * maximum attempts allowed, the total attempts made, whether the player won
     * or lost, and all guesses made during the game.
     *
     * @return A formatted string that provides: - The range of the numbers used
     * in the game. - The maximum number of tries allowed. - The total number of
     * games recorded so far. - The result of the current game (win or lose). -
     * A comma-separated list of the player's guesses.
     */
    public String getGameLog() {
        StringBuilder valueOfGuesses = new StringBuilder();
        for (int i = 0; i < this.guessCount; i++) {
            valueOfGuesses.append(guesses[i]);
            if (i < guesses.length - 1) {
                valueOfGuesses.append(", ");
            }
        }
        return ": Range: [" + getMin() + "-" + getMax()
                + "], Max Tries: " + getMaxTries() + ", Attempts: " + (this.guessCount)
                + ", Result: " + (this.win ? "win" : "Lose") + ", Guesses: " + valueOfGuesses;

    }
}
