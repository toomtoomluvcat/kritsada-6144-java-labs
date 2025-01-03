package beapthong.kritsada.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    public static Scanner input = new Scanner(System.in);
    private GuessGameV3 game;

    public void configure() {
        int defualtMaxTires = 10;
        this.game = new GuessGameV3();
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        this.game.configureGame(min, max, defualtMaxTires);
        min = this.game.getMin();
        max = this.game.getMax();
        System.out.print("Enter the maximum number of tires: ");
        int maxTries = input.nextInt();
        this.game.configureGame(min, max, maxTries);
    }

    public void playGame() {
        this.game.playSingleGame();
        GuessGameV3.addGameRecord(game);
        while (true) {
            System.out.println("Do you want to:");
            System.out.println("1.Play again\n2.view game record\n3.quit");
            int options = input.nextInt();

            switch (options) {
                case 1 -> {
                    configure();
                    playGame();
                    break;
                }
                case 2 -> {
                    GuessGameV3.getGameLog();
                    continue;
                }
                case 3 -> {
                    System.out.println("Thank you for Playing the Number Guessing Game 3!");
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();
        program.playGame();
    }
}
