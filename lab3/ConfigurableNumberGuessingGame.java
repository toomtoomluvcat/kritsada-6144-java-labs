package lab3;

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the min value: ");
        int minvalue = sc.nextInt();
        int maxvalue;

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

        while (true) {
            System.out.print("Enter of maximum number of tires: "); 
            attemp =sc.nextInt();
            if (attemp<1){
                System.out.println("The maximum number of tries must be greater than 0");
            }else {
                break;
            }    
        }
        
        int randomInt = (int) (Math.random()*maxvalue)+minvalue;
        System.out.println("welcome to a number guessing game!");
        while(numofRound<attemp){
            System.out.print("Enter an iteger between "+minvalue+" and "+maxvalue+": ");
            int chooseInt = sc.nextInt();
            if(chooseInt<minvalue || chooseInt>maxvalue){
                System.out.println("The number must be between "+minvalue+" and "+maxvalue);
                continue;
            }
         
            numofRound +=1;

            if(chooseInt>randomInt){
                System.out.println("Try lower number!");
            } else if (chooseInt<randomInt){
                System.out.println("Try higher number!");
            } else {
                System.out.println("Congratulations!");
                System.out.println("Your have tired "+ numofRound+ " time");
                break;
            }
        }
        if (attemp == numofRound){
            System.out.println("You have tired 5 times. You ran out of guesses");
            System.out.println("The answer is "+randomInt );
        }
    }
}
