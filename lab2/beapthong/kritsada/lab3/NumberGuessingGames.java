package beapthong.kritsada.lab3;

import java.util.Scanner;

public class NumberGuessingGames {

    /*
    * the Configurable number guessing game program :
    * this program will recice 3 input first input is min value 
    seccound input is max value third input is tired player can play this game
    and when the game start program will random value player
    must input integer value between min and max value
    util is max tired or input equals random number
    
    and when player correct answer the program will ask
    player want to play game again then if player enter Y
    or y the game will start with same min max tires value 
    same before round. if player enter other value  the game will end 
    
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update in 12/06/2567*/
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] range = askMinMax();
        int triesRound = tries();
        gameStart(range[0], range[1], triesRound); //sent a agrument with min max maxtires

    }

    //function recipe max min value
    public static int[] askMinMax() {
        System.out.print("Enter min value: ");
        int minValue = sc.nextInt();
        int maxValue;

        //try util enter correct format provided
        while (true) {
            System.out.print("Enetr max value: ");
            maxValue = sc.nextInt();
            if (maxValue > minValue) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
        }
        return new int[]{minValue, maxValue};
    }

    //function recipe maxtires
    public static int tries() {
        System.out.print("Enter of maximum number of tires: ");
        int maxtries;

        while (true) {
            maxtries = sc.nextInt();
            if (maxtries > 0) {
                break;
            } else {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        }
        return maxtries;
    }

    //game start with three argument
    public static void gameStart(int min, int max, int maxRound) {
        System.out.println("Welcome to number guessing game!");
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;

        for (int i = 0; i < maxRound; i++) {
            System.out.print(String.format("Enter integer between %d and %d: ", min, max));
            int playerGuess = sc.nextInt();

            //check answer out of range!
            while (playerGuess < min || playerGuess > max) {
                System.out.println(String.format("The number must be between %d and %d ", min,max));
                System.out.print(String.format("Enter integer between %d and %d: ", min, max));
                playerGuess = sc.nextInt();
            }
            sc.nextLine(); //clearbuffer
            if (randomValue != playerGuess && (i + 1) == maxRound) {
                
                //if player guessign max tires and they still false
                System.out.println(String.format(i == 0
                        ? "you have tired 1 time"
                        : "you have tired %d times", i + 1));
                System.out.println(i == 0
                        ? "You have tired " + (i + 1) + " time. You ran out of guesses"
                        : "You have tired " + (i + 1) + " times. You ran out of guesses");
                System.out.println(String.format("The answer is %d", randomValue));
            } else if (randomValue != playerGuess) {
                //give player hint
                if (playerGuess > randomValue) {
                    System.out.println("Try lower number!");
                } else {
                    System.out.println("Try higher number!");
                }
            } else {
                //if player correct answer break loop
                System.out.println("Congratulations!");
                System.out.println(String.format(i == 0
                        ? "you have tired 1 time"
                        : "you have tired %d times", i + 1));
                break;
            }

        }
        //Start game again
        System.out.print("Want to play again (Y or y): ");
        String wantplay = sc.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            gameStart(min, max, maxRound);
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }

    }
}
