package beapthong.kritsada.lab6;

public class GuessGameV2 extends GuessGame{
    public GuessGameV2(int min,int max,int maxTries){
        super(min,max,maxTries);
    }

    @Override
    public void configureGame(int min,int max,int maxTries) {
        int newMaxValue = max;
        System.out.println(max);
        while(newMaxValue<=min){
            System.out.println("Invalid Input: max must be greater than or equal to min.");
            newMaxValue= NumberGuessingOOPGame.input.nextInt();
        }
        setMax(newMaxValue);
        int newMaxTries = maxTries;
        while(newMaxTries<0){
            System.out.println("Invalid input: MaxTires must be greater than 0.");
        }
        setMaxTries(newMaxTries);
    }
}