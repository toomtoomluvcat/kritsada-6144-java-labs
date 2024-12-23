package beapthong.kritsada.lab3;

/*
    * the Configurable number guessing game program :
    * this program will recice 3 input first input is min value 
    seccound input is max value third input is tired player can play this game
    and when the game start program will random value player
    must input integer value between min and max value
    util is max tired or input equals random number
    
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update in 12/06/2567*/

import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args){

        //declare varieble
        Scanner sc = new Scanner(System.in);
        int minValue = 1;
        int maxValue = 10;
        int randomInt = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        int maxtires = 6;
        int attemp =0;
        System.out.println("Welcome to number guessing game!");
        //start game!
        while(attemp<maxtires){
            System.out.print("Enter an iteger between "+minValue+" and "+maxValue+": ");
            int chooseint = sc.nextInt();
            attemp +=1;

            //tell hint
            if(chooseint>randomInt){
                System.out.println("Try lower number!");
            } else if (chooseint<randomInt){
                System.out.println("Try higher number!");
            } else {
                //amazing! player correct answer -0-)b
                System.out.println("Congratulations!");
                System.out.println("You have tried " + attemp + (attemp == 1 ? " time." : " times."));
                attemp=0;
                break;
            }
        }
        //tell if player can't guess number 
        if (attemp == maxtires){
            System.out.println("You have tired 5 times. You ran out of guesses");
            System.out.println("The answer is "+randomInt );
        }
      sc.close();
    }
}