package beapthong.kritsada.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV2 {

    public static Scanner input = new Scanner(System.in);
    private GuessGameV2 game2;

    public void configure() {
        int defualtMaxTires = 10;
        this.game2 = new GuessGameV2();
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        this.game2.configureGame(min, max, defualtMaxTires);
        min = this.game2.getMin();
        max = this.game2.getMax();
        System.out.print("Enter the maximum number of tires: ");
        int maxTries = input.nextInt();
        this.game2.configureGame(min, max, maxTries);
    }

    public void playGame() {
        boolean playAgain;
        do {
            boolean result = this.game2.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain);
        System.out.println("Thank you for Playing the Number Guessing Game V2!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();
        program.playGame();
    }
    
}
