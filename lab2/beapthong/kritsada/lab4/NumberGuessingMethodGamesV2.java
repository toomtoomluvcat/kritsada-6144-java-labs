package lab2.beapthong.kritsada.lab4;



 /*
    * the NumberGuessingMethodGamesV2 program :
    * this program will recice 3 input first input is min value 
    seccound input is max value third input is tired player can play this game
    and when the game start program will random value player
    must input integer value between min and max value
    util is max tired or input equals random number  the program will
    end to reciep input when player try to input max of tires guessing or when
    player guess correct answer 
    
    when the game round <n> end  player the program will ask player to show all 
    answer of him when input is 'a' show all answer when input is 'g'
    player can choose index of answer to display if neither not show anything 
    and continue next step

    the program will ask player want to play game again then if player enter Y
    or y the game will start with same min max tires value 
    same before round. if player enter other value  the game will end 
    
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update in 12/12/2567*/

//heriate program before
public class NumberGuessingMethodGamesV2 extends NumberGuessingMethodGames {

    static int[] answerArry = new int[10];

    public static void main(String[] args) {
        //called method
        configure();
        playGame2();
        input.close();
    }

    public static void historyChoose() {
        input.nextLine();
        //loop util player want to stop and if her/him input 'a' display all if else input 'g' they can choose index of answer
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
                playGames2();
                break;
            }
        }
    }

    //ask player want to play again
    public static void playGames2() {
        System.out.print("Want to play again (Y or y): ");
        String wantplay = input.nextLine();
        if (wantplay.equalsIgnoreCase("y")) {
            playGame2();
        } else {
            System.out.println("Thank you for playing our game. Bye!");
        }
    }

    //loop for display all player answer
    public static void displayComprehensive() {
        int count = 0;
        //loop by element of array
        for (int value : answerArry) {
            count++;
            //not display if out out index answer
            if (value != 0) {
                System.out.println(String.format("Guess %d: %d", count, value));;
            } else {
                // stop continue display
                break;
            }
        }
    }

    public static void playGame2() {
        genAnswer();
        System.out.println("Welcome to a number guessing game!");
        for (int i = 0; i < tires; i++) { //loop following max tires
            System.out.print(String.format("Enter integer between %d and %d: ", minValue, maxValue));
            guessValue = input.nextInt();
            checkValidGuess(); //check valid range of answer 
            answerArry[i] = guessValue; //append answer in to array
            if (answer != guessValue && (i + 1) == tires) { //if guessing ture
                System.out.println(String.format("you have tired %d", i + 1));
                System.out.println(String.format("The answer is %d", answer));
            } else if (answer != guessValue) {
                highLow();
            } else { //if guessing false and max of tires
                System.out.println("Congratulations!");
                System.out.println(String.format("you have tired %d", i + 1));
                break;
            }
        }
        historyChoose(); //show history of answer
    }
}
