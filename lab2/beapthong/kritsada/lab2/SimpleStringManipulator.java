package beapthong.kritsada.lab2;

public class SimpleStringManipulator {

    /* The simple String manipulator 
     * program recive input two argrument
     and process 
     if one first letter of  argrument is vowel 
     replace it with uppercase vowel
     if two last letter of arrrument is't vowel
     replace it with lowercase 
     
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update on 11/30/2024 7:57*/
    
    public static void main(String[] args) {

        //check an error and display
        if (args.length != 2) {
            System.out.println("Invalid number of argument. Please provide exactly two Strings as arguments");
        } else {
            //recice argument
            String word1 = args[0];
            String word2 = args[1];
            char firstLetter = word1.charAt(0);
            char lastLetter = word2.charAt(args[1].length() - 1);

            System.out.println("First String: " + word1);
            System.out.println("Secound String: " + word2);
            
            //process and merg argumemt
            if (firstLetter == 'a' || firstLetter == 'e'
                    || firstLetter == 'i' || firstLetter == 'o'
                    || firstLetter == 'u') {
                word1 = word1.substring(0, 1).toUpperCase() + word1.substring(1);
            }

            if (!(lastLetter == 'a' || lastLetter == 'e'
                    || lastLetter == 'i' || lastLetter == 'o'
                    || lastLetter == 'u')) {
                word2 = word2.substring(0, word2.length() - 1) + word2.substring(word2.length() - 1).toUpperCase();
            }

            System.out.println("Resulting String: "+word1 + word2);
        }
    }
}
