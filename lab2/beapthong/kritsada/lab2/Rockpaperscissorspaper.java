package lab2.beapthong.kritsada.lab2;

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
  
 

public class Rockpaperscissorspaper {

    public static void main(String[] args) {
        // declare variable and change to lowercase
        String Player1 = args[0].toLowerCase();
        String Player2 = args[1].toLowerCase();
        //check correct recive input 
        if ((Player1.equals("rock") || Player1.equals("paper") || Player1.equals("scissors"))
                && (Player2.equals("rock") || Player2.equals("paper") || Player2.equals("scissors"))) {

            //rule of game
            if (Player1.equals(Player2)) {
                System.out.println("it's a tie");
            } else if ((Player1.equals("scissors") && Player2.equals("paper"))
                    || Player1.equals("rock") && Player2.equals("paper")
                    || Player1.equals("paper") && Player2.equals("rock")) {
                System.out.println("Player 1 win!");
            } else {
                System.out.println("Player 2 win!");
            }

        } else{
            //display an error
            System.err.println("Error: Invalid number of argument. Please provide exactly two arguments.");
        }
    }
}
