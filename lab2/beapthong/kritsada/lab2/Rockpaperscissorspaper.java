package lab2.beapthong.kritsada.lab2;

/*
  * The Rock paperscisorspaperprogram 
  this program  will accepts argrument of two user 
  than will process follow system
  paper win rock
  rock win scissors
  scirssors win papar
  and display user who win
  
  
  Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2*/
public class Rockpaperscissorspaper {

    public static void main(String[] args) {
        boolean checkRockPlayer1 = args[0].equalsIgnoreCase("rock");
        boolean checkScissorsPlayer1 = args[0].equalsIgnoreCase("scissors");
        if (args[0].equalsIgnoreCase("rock")) {
            if (checkRockPlayer1) {
                System.out.println("2 Player draw!");
            } else if (checkScissorsPlayer1) {
                System.out.println("Player 2 win!");
            } else {
                System.out.println("Player 1 win!");
            }
        }if (args[1].equalsIgnoreCase("paper")){
            if (checkRockPlayer1){
                System.out.println("Player 2 win!");
            } else if (checkScissorsPlayer1){
                System.out.println("Player 1 win!");
            } else {
                System.out.println("2 Player draw");
            }
        } else{
            if (checkRockPlayer1){
                System.out.println("Player 1 win!");
            
            } else if (checkScissorsPlayer1){
                System.err.println("2 Player draw");
            } else {
                System.out.println("Player 2 win!");
            }
        }

    }
}
