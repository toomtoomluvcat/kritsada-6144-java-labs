package lab2.beapthong.kritsada.lab4;

public class NumberGuessingMethodGamesV2 extends NumberGuessingMethodGames {

    static int[] answerArry = new int[10];

    public static void main(String[] args) {
        configure();
        playGame2();
    }

    public static void historyChoose() {
        input.nextLine();
        while (true) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any key to quit: ");
            String wantToshow = input.nextLine();
            if (wantToshow.equalsIgnoreCase("a")) {
                displayComprehensive();
            } else if (wantToshow.equalsIgnoreCase("g")) {
                System.out.print("Enter the guess number: ");
                int count = input.nextInt();
                System.out.println(String.format("Guess %d: %d", count, answerArry[count]));
                input.nextLine();
            } else {
                theGameStartAgain2();
                break;
            }
        }

    }

    public static void theGameStartAgain2() {
        System.out.print("Want to play again (Y or y): ");
        String wantplay = input.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            playGame2();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
            System.exit(0);
        }
    }

    public static void displayComprehensive() {
        int count = 0;
        for (int value : answerArry) {
            count++;
            if (value != 0) {
                System.out.println(String.format("Guess %d: %d", count, value));;
            } else {
                break;
            }
        }
    }

    public static void playGame2() {
        genAnswer();
        System.out.println("Welcome to a number guessing game!");
        for (int i = 0; i < tires; i++) {
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            checkValidGuess();
            answerArry[i] = guessValue;
            if (answer != guessValue && (i + 1) == tires) {
                System.out.println(String.format("you have tired %d", i + 1));
                System.out.println(String.format("The answer is %d", answer));
                historyChoose();
            } else if (answer != guessValue) {
                highLow();
            } else {
                System.out.println("Congratulations!");
                System.out.println(String.format("you have tired %d", i + 1));
                historyChoose();
                break;
            }
        }
    }
}
