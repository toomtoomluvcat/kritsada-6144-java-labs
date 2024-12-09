package lab2.beapthong.kritsada.lab4;

public class NumberGuessingMethodGamesV3 extends  NumberGuessingMethodGamesV2 {
    static int gamePlayed =0;
    static int gameWin = 0;
    static int sumOfGuessPergame = 0;
    static int highScore = 10;
    static boolean statusGame;


    public static void main(String[] args) {
        configure();
        playGame3();
        displayStatic();
        input.close();
    }

    public static void displayGameLog(int roundOfguess){
        System.out.println(String.format("Answer is: %s, Guess: %d, win: %b", answer,roundOfguess,statusGame));
    }

    public static void keepStatic(int roundOfguess){
        sumOfGuessPergame += roundOfguess;
        if (roundOfguess<highScore){
            highScore =roundOfguess;
        }
    }

    public static void theGameStartAgain3() {
        gamePlayed++;
        System.out.print("Want to play again (Y or y): ");
        String wantplay = input.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            playGame3();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }
    }

    public static void historyChoose3() {
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
                theGameStartAgain3();
                break;
            }
        }
    }

    public static void playGame3() {
        genAnswer();
        System.out.println("Welcome to a number guessing game!");
        for (int i = 0; i < tires; i++) {
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            answerArry[i] = guessValue;
            checkValidGuess();
            if (answer != guessValue && (i + 1) == tires) {
                System.out.println(String.format("you have tired %d", i + 1));
                System.out.println(String.format("The answer is %d", answer));
                statusGame = false;
                displayGameLog(i+1);
                keepStatic(i+1);
                historyChoose3();
            } else if (answer != guessValue) {
                highLow();
            } else {
                System.out.println("Congratulations!");
                statusGame = true;
                displayGameLog(i+1);
                keepStatic(i+1);
                gameWin++;
                historyChoose3();
                break;
            }
        }
        
    }
    public static void displayStatic(){
        System.out.println("==== All Game Status ====");
        System.out.println(String.format("Totalgameplay: %d",gamePlayed));
        System.out.println(String.format("Total game win %d",gameWin));
        System.out.println(String.format("win ratio: %.1f", ((double) gameWin/gamePlayed)*100));
        System.out.println(String.format("Average number of guessing per game: %.1f",(double)sumOfGuessPergame/gamePlayed));
        System.out.println(String.format("Hight score (the lowest number of guesses): %s", highScore));
    }  
}
