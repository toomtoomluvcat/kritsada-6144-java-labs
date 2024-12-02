package lab2.beapthong.kritsada.lab2;

import lab2.beapthong.kritsada.lab2.Rockpaperscissorspaper.Choice;

/*
  * The Rock paperscisorspaperprogram 
  * this program  will accepts argrument of two user 
  than will process follow system
  * paper win rock
  * rock win scissors
  * scirssors win papar
  * and display user who win 
  * if program recive input other above data 
  program would display an error 
 */
public class Rockpaperscissorspaper {

    public enum Choice {
        rock, paper, scissors;
    }

    public static void main(String[] args) {
        // declare variable and change to lowercase
        String Player1 = args[0].toLowerCase();
        String Player2 = args[1].toLowerCase();
        //check correct recive input 
        try {
            Choice enumPlayer1 = Choice.valueOf(Player1);
            Choice enumPlayer2 = Choice.valueOf(Player2);
            //rule of game
            if (Player1.equals(Player2)) {
                System.out.println("it's a tie");
            } else if ((Player1.equals("scissors") && Player2.equals("paper"))
                    || Player1.equals("rock") && Player2.equals("scissors")
                    || Player1.equals("paper") && Player2.equals("rock")) {
                System.out.println("Player 1 win!");
            } else {
                System.out.println("Player 2 win!");
            }
            //display an error
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid number of argument. Please provide exactly two arguments.");
        }
    }
}
