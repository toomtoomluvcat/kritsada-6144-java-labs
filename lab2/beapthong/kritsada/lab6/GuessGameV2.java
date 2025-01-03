package beapthong.kritsada.lab6;

public class GuessGameV2 extends GuessGame{
    public GuessGameV2(int min,int max,int maxTries){
        super(min,max,maxTries);
    }
    public GuessGameV2(){
        super();
    }

    @Override
    public void configureGame(int min,int max,int maxTries) {
        int NewMinvalue = min;
        int newMaxValue = max;
        int newMaxTries = maxTries;
        while(newMaxValue<=NewMinvalue){
            System.out.println("Invalid Input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            NewMinvalue =NumberGuessingOOPGameV2.input.nextInt();
            System.out.print("Enter the max value: ");
            newMaxValue= NumberGuessingOOPGameV2.input.nextInt();
        }
        setMin(NewMinvalue);
        setMax(newMaxValue);
        
        while(newMaxTries<=0){
            System.out.println("Invalid input: MaxTires must be greater than 0.");
            System.out.print("Enter the maximum of tires: ");
            newMaxTries = NumberGuessingOOPGame.input.nextInt();
        }
        setMaxTries(newMaxTries);
    }
    @Override
    public boolean playSingleGame() {
        generateAnswer();
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int answer = getAnswer();
        System.out.println(toString());
        System.out.println("Welcome to the Number Guessing GameV2!");
        for (int i = 0; i < maxTries; i++) {
            System.out.print(String.format("Enter an inter between %d and  %d: ", min,max));
            int guesses = NumberGuessingOOPGame.input.nextInt();
            while (guesses < min || guesses > max) {
                System.out.println(String.format(String.format("The number must be between %d and %d ",min, max)));
                System.out.print(String.format("Enter an inter between %d and  %d: ", min, max));
                guesses = NumberGuessingOOPGame.input.nextInt();
            }
            if (guesses != answer && i + 1 == maxTries) {
                System.out.println(String.format("Sorry, you've used all your attempt. the correct. The correct answer was: %d", answer));
                return false;
            } else if (guesses == answer) {
                System.out.print("Congratulations! You've guessed the number in "+(i+1));
                System.err.println(i==0? " attemp." : " attemps.");
                return true;
            } else {
                System.out.println(guesses < answer ? "Try a higher number!" : "Try a lower number!");
            }
        }
        return true; 

    }
    
    public String toString(){
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();

        return "Game Configuration: [Min: "+ min+ 
        ", Max: "+max+
        ", Max Tires: "+maxTries+
        ", Attemp: 0]";
    }
}