package lab2.beapthong.kritsada.lab4;

import java.util.Scanner;

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
    last update in 12/13/2567*/

public class NumberGuessingMethodGames {
    //decalre varieble
    static int minValue;
    static int maxValue;
    static int answer;
    static int guessValue;
    static int tires;
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        //called method
        configure();
        playGame();

    }

    //recipt range of min max value
    public static void configure() {
        System.out.print("Enter the min value: ");
        minValue = input.nextInt();
        System.out.print("Enter the max value: ");
        maxValue = input.nextInt();
        checkValidRange();
        System.out.print("Enter the maximum number of tires: ");
        tires = input.nextInt();
        checkvalidtries();
    }

    //check correct range max value must more than min value 
    public static void checkValidRange() {
        //not ask player if max value is correct input
        while (maxValue < minValue) {
            System.out.println("The max value must be at least equal min value");
            System.out.print("Enter the max value: ");
            maxValue = input.nextInt();
        }
    }

    //check correct tries round
    public static void checkvalidtries() {
        while (tires < 1) {
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tires: ");
            tires = input.nextInt();
        }
    }

    //check correct range between min and max
    public static void checkValidGuess() {
        while (guessValue < minValue || guessValue > maxValue) {
            System.out.println(String.format("The number must be between %d and %d ", minValue, maxValue));
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
        }
    }
    //generate new answer in range of max and min number
    public static void genAnswer() {
        answer = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    //tell hint to player
    public static void highLow() {
        if (guessValue > answer) {
            System.out.println("Try lower number!");
        } else {
            System.out.println("Try higher number!");
        }
    }
    //ask player want to play again
    public static void playGames() {
        System.out.print("Want to play again (Y or y): ");
        input.nextLine();
        String wantplay = input.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            playGame();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
            System.exit(0);
        }
    }

    //game start!
    public static void playGame() {
        genAnswer();
        System.out.println("Welcoem to a number guessing game!");
        for (int i = 0; i < tires; i++) { //loop fowlowing max of tires
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            checkValidGuess();
            if (answer != guessValue && (i + 1) == tires) {
                System.out.println(String.format("you have tired %d", i + 1));
                System.out.println(String.format("The answer is %d", answer));
                return;
            } else if (answer != guessValue) {
                highLow();
            } else {
                System.out.println("Congratulations!");
                System.out.println(String.format("you have tired %d", i + 1));
                break;
            }
        }
        //called method to start again
        playGames();
    }
    
}
