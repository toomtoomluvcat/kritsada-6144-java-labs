package lab2.beapthong.kritsada.lab3;

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
        int[] range = askuMinMax();
        int triesround = tries();
        gameStart(range[0], range[1], triesround); //sent a agrument with min max maxtires

    }
    //function recipe max min value
    public static int[] askuMinMax() {
        System.out.print("Enter min value: ");
        int minvalue = sc.nextInt();
        int maxvalue;

        //try util enter correct format provided
        while (true) {
            System.out.print("Enetr max value: ");
            maxvalue = sc.nextInt();
            if (maxvalue > minvalue) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
        }
        return new int[]{minvalue, maxvalue};
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
    public static void gameStart(int min, int max, int maxround) {
        System.out.println("Welcome to number guessing game!");
        int randomValue = (int) (Math.random() * (max - min) + 1);
        int choose;
        int attempt = 0;

        while (attempt<maxround) {
            for (attempt = 0; attempt < maxround; attempt++) {
                while (true) {
                    System.out.print("Enter integer between " + min + " and " + max + ": ");
                    choose = sc.nextInt();
                    if (choose <= max && choose >= min) {
                        break;
                    }
                    System.out.println("The number must be between " + min + " and " + max);
                }
                //tell hint
                if (choose > randomValue) {
                    System.out.println("Try lower number!");

                } else if (choose < randomValue) {
                    System.out.println("Try higher number!");
                } else {
                    System.out.println("Congratulations!");
                    
                    //correct gramma
                    if (attempt == 1) {
                        System.out.println("Your have tired " + attempt + " time");
                    } else {
                        System.out.println("Your have tired " + attempt + " times");
                    }
                    break;
                }
            }
            if (attempt > maxround) {
                System.out.println("You have tired 5 times. You ran out of guesses");
                System.out.println("The answer is " + randomValue);
            }
            
            //ask player wannt to play again
            System.out.print("Want to play again (Y or y): ");
            String checknextround = sc.next();
            if (!checknextround.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing games.Bye!");
                break;
            }
        }

    }

    
}
