package lab3;

import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int randomint = (int) (Math.random()*10)+1;
        int attemp =0;
        while(attemp<6){
            System.out.print("Enter an iteger between 1 and 10: ");
            int chooseint = sc.nextInt();
            attemp +=1;
            if(chooseint>randomint){
                System.out.println("Try lower number!");
            } else if (chooseint<randomint){
                System.out.println("Try higher number!");
            } else {
                System.out.println("Congratulations!");
                System.out.println("Your have tired "+ attemp+ " time");
                break;
            }
        }
        if (attemp == 6){
            System.out.println("You have tired 5 times. You ran out of guesses");
            System.out.println("The answer is "+randomint );
        }
    }
}