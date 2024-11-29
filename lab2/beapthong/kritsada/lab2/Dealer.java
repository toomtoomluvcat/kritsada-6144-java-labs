    package beapthong.kritsada.lab2;
        /*
        * the Dealer program :
        * this program accepts three argument then process
        and display information the out put should be
        Dealer's name <delaer name>
        Number of client:<number client>
        Gender : <dealer_gender>
        
        Auther:Kritsada beapthong
        ID:673040614-4
        Sec:2*/

    public class Dealer { 
        public static void main(String[] args) {
            if (args.length != 3) {
                System.out.println("Error Invalid number of arguments. Please provide exactly three arguments");
            }else {
            int money = Integer.parseInt(args[1]);
            System.out.println("Dealer's name: "+ args[0]);
            System.out.println("Number of client: "+money);
            System.out.println("Gender: "+args[2]);}}

        }
