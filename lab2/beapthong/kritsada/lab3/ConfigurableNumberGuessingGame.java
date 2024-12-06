package lab2.beapthong.kritsada.lab3;

import java.util.Scanner;
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

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args){
        //decalre varieble
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the min value: ");
        int minvalue = sc.nextInt();
        int maxvalue;

        //loop util player enter correct maxvalue
        while (true) {
            System.out.print("Enter the max value: ");
            maxvalue = sc.nextInt();
            if (maxvalue<=minvalue){
                System.out.println("The max value must be at least equal to the min value");
            } else {
                break;
            }
        }

        int numofRound = 0;
        int attemp; 

        //loop util player enter correct tires
        while (true) {
            System.out.print("Enter of maximum number of tires: "); 
            attemp =sc.nextInt();
            if (attemp<1){
                System.out.println("The maximum number of tries must be greater than 0");
            }else {
                break;
            }    
        }
        //start game!
        int randomInt = (int) (Math.random()*(maxvalue-minvalue)+1); //make a random number
        System.out.println("welcome to a number guessing game!");
        while(numofRound<attemp){
            System.out.print("Enter an iteger between "+minvalue+" and "+maxvalue+": ");
            int chooseInt = sc.nextInt();
            if(chooseInt<minvalue || chooseInt>maxvalue){
                System.out.println("The number must be between "+minvalue+" and "+maxvalue);
                continue;
            }
         
            numofRound +=1;

            //tell hint to player
            if(chooseInt>randomInt){
                System.out.println("Try lower number!");
            } else if (chooseInt<randomInt){
                System.out.println("Try higher number!");
            } else {
                //if plyer guess correct break loop
                System.out.println("Congratulations!");
                System.out.println("Your have tired "+ numofRound+ " time");
                break;
            }
        }
        //tell play if he/him try to correct more than round they want
        if (attemp == numofRound){
            System.out.println("You have tired 5 times. You ran out of guesses");
            System.out.println("The answer is "+randomInt );
        }
        sc.close();
    }
}
