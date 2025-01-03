package beapthong.kritsada.lab6;


public class GuessGame {

    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;

    public GuessGame() {
        this.min = 0;
        this.max = 100;
        this.maxTries = 10;
        this.answer = 0;
        this.attempts = 0;
    }
    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
    }
    public void configureGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public int getMaxTries() {
        return this.maxTries;
    }
    public int setMaxTries(int maxTries){
        this.maxTries = maxTries;
        return this.maxTries;
    }
    public int getAnswer(){
        return  this.answer;
    }
    public int getAttempt(){
        return  this.attempts;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setAttemp(int attemps){
        this.attempts = attemps;
    }
    public void generateAnswer() {
        this.answer = (int) (Math.random() * (this.max - this.min + 1) + this.min);
    }

    public boolean playSingleGame() {
        generateAnswer();
        System.out.println("Welcome to the Number Guessing Game!");
        for (int i = 0; i < this.maxTries; i++) {
            System.out.print(String.format("Enter an inter between %d and  %d: ", this.min, this.max));
            int guesses = NumberGuessingOOPGame.input.nextInt();
            if (guesses != this.answer && i + 1 == maxTries) {
                System.out.println(String.format("Sorry, you've used all your attempt. the correct. The correct answer was: %d", this.answer));
                return false;
            } else if (guesses == this.answer) {
                System.out.println(String.format("Congratulations! You've guessed the number in %d attemps.", i + 1));
                return true;
            } else {
                System.out.println(guesses < this.answer ? "Try a higher number!" : "Try a lower number!");
            }
        }
        return true; 

    }
    
}
