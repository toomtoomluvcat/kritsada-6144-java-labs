
import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {

    // decleard variable
    static Scanner input = new Scanner(System.in); // user input
    static int min, max, count, answer, number;
    static boolean check;
    static String newStart, key;
    static int[] guessing = new int[10];

    public static void main(String[] args) {
        // called method
        configure();
        playGames();

    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        checkValidvalue(); // called method to check
        System.out.print("Enter the maximum number of tries:");
        count = input.nextInt();
        checkValidcount(); // called method to check
    }

    static void genAnswer() {
        // generate answers
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void checkValidvalue() {
        // Check your input.Display Error messsage if max<min
        while (max < min) {
            System.err.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
    }

    static void checkValidcount() {
        // Check your input.Display Error messsage if count<=0
        while (count <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            count = input.nextInt();
        }
    }

    static void playGame() {
        check = true;
        System.out.println("Welcome to a number guessing game!");
        genAnswer(); // called method
        for (int i = 1; i < count + 1; ++i) {
            int number = 0; // global variable in for loop
            while (true) {
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                number = input.nextInt();
                /*
                 * Check your input number.Display Error messsage if number is not between min
                 * and max value
                 */
                if (number >= min && number <= max) {
                    break; // stop loop
                }
                System.err.println("The number must be between " + min + " and " + max);
            }
            guessing[i - 1] = number;
            // condition check your answer and number
            if (number == answer) {
                System.out.println("Congratulations!");
                if (i == 1) {
                    System.out.println("You have tried 1 time");
                } else {
                    System.out.println("You have tried " + i + " times");
                }
                check = false; // change boolean to false
                break; // Stop loop
            } else if (number < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }

        }
        // if input is incorrect display text and correct answer
        if (check) {
            if (count == 1) {
                System.out.println("You have tried " + count + " time.\nThe answer is " + answer);
            } else {
                System.out.println("You have tried " + count + " times.\nThe answer is " + answer);
            }
        }

    }

    static void displayGuessesLoop() {
        while () {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            input.nextLine();
            key = input.nextLine();

            if (key.equals("a")) {
                for (int i = 0; i < guessing.length; i++) {
                    System.out.println("Guess " + (i + 1) + ":" + guessing[i]);
                }
            }
        }
    }

    static void playGames() {
        do {
            playGame();
            displayGuesses();
            System.out.print("Want to play again (Y or y):");
            newStart = input.nextLine();
            // if user want to close the program
            if (!newStart.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing our games. Bye!");
                break;
            }
        } while (true);
        // close scanner
        input.close();
    }
}
