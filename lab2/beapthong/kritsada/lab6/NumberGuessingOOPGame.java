package beapthong.kritsada.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {

    public static Scanner input = new Scanner(System.in);
    private  GuessGame game;
    private GuessGameV2 game2;

    public void configure() {
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        System.out.print("Enter the maximum number of: ");
        int maxTries = input.nextInt();
        this.game2 = new GuessGameV2(min, max, maxTries);
    }

    public void playGame() {
        boolean playAgain;
        do {
            boolean result = this.game2.playSingleGame();
            System.out.println(result ? "You win!": "Better luck next time.");
            System.out.print("Do you want to play again (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");
            if (playAgain){
                configure();
            }
        } while(playAgain);
        System.out.println("Thank you for Playing the Number Guessing Game!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGame();
    }
}
