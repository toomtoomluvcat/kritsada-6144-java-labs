package lab2.beapthong.kritsada.lab4;

 /*
    * the NumberGuessingMethodGamesV2 program :
    * this program will recice 3 input first input is min value 
    seccound input is max value third input is tired player can play this game
    and when the game start program will random value player
    must input integer value between min and max value
    util is max tired or input equals random number the program will
    end to reciep input when player try to input max of tires guessing or when
    player guess correct answer 

    and then program will show game log in that round
    
    when the game round <n> end  player the program will ask player to show all 
    answer of him when input is 'a' show all answer when input is 'g'
    player can choose index of answer to display if neither not show anything 
    and continue next step

    the program will ask player want to play game again then if player enter Y
    or y the game will start with same min max tires value 
    same before round. if player enter other value  the game will end and show total game 
    total, game win, win ratio ,averange game play of  guessing per game, and high score
    
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update in 12/12/2567*/
//heriate program before
public class NumberGuessingMethodGamesV3 extends NumberGuessingMethodGamesV2 {

    //declare varieble to keep static of game
    static int gamePlayed = 0;
    static int gameWin = 0;
    static int sumOfGuessPergame = 0;
    static int highScore = 10;
    static boolean statusGame;

    public static void main(String[] args) {
        //called method
        configure();
        playGame3();
        displayStatic();
        input.close();
    }

    //display game log
    public static void displayGameLog(int roundOfguess) {
        System.out.println(String.format("Answer is: %s, Guess: %d, win: %b", answer, roundOfguess, statusGame));
    }

    //Change New High Score!
    public static void keepStatic(int roundOfguess) {
        sumOfGuessPergame += roundOfguess;
        if (roundOfguess < highScore) {
            highScore = roundOfguess;
        }
    }

    //ask player want to play again 
    public static void playGames3() {
        gamePlayed++; //increase num of game play
        System.out.print("Want to play again (Y or y): ");
        String wantplay = input.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            playGame3();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }
    }

    public static void historyChoose3() {
        input.nextLine();  // claer buffer
        while (true) {
            //loop util player want to stop and if her/him input 'a' display all if else input 'g' they can choose index of answer
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
                playGames3(); //start game again!
                break;
            }
        }
    }

    //game start!
    public static void playGame3() {
        genAnswer();
        System.out.println("Welcome to a number guessing game!");
        for (int i = 0; i < tires; i++) {
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            checkValidGuess();//check valid range of answer 
            answerArry[i] = guessValue;
            if (answer != guessValue && (i + 1) == tires) {
                System.out.println(String.format("you have tired %d", i + 1));
                System.out.println(String.format("The answer is %d", answer));
                statusGame = false; //playe lose
                displayGameLog(i + 1);
                keepStatic(i + 1);
            } else if (answer != guessValue) {
                highLow();
            } else {
                System.out.println("Congratulations!");
                statusGame = true;
                displayGameLog(i + 1);
                keepStatic(i + 1);
                gameWin++; //increase game win stack
                break;
            }
        }
        historyChoose3();
    }

    //display static of game
    public static void displayStatic() {
        System.out.println("==== All Game Status ====");
        System.out.println(String.format("Totalgameplay: %d", gamePlayed));
        System.out.println(String.format("Total game win %d", gameWin));
        System.out.println(String.format("win ratio: %.1f", ((double) gameWin / gamePlayed) * 100));
        System.out.println(String.format("Average number of guessing per game: %.1f", (double) sumOfGuessPergame / gamePlayed));
        System.out.println(String.format("Hight score (the lowest number of guesses): %s", highScore));
    }
}
