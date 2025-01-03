package beapthong.kritsada.lab6;


public class GuessGameV3 extends GuessGameV2 {

    private static int MAX_GAME = 100;
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAME];
    private static int recordIndex = 0;
    private int[] guesses;
    private int guessCount;
    private boolean win;

    public GuessGameV3() {
        super();
        this.guessCount = 0;
        this.win = false;
        guesses = new int[getMaxTries()];
    }

    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries);
        this.guessCount = 0;
        this.win = false;
        guesses = new int[maxTries];
    }

    @Override
    public void configureGame(int min, int max, int maxTries) {
        int NewMinvalue = min;
        int newMaxValue = max;
        int newMaxTries = maxTries;
        while (newMaxValue <= NewMinvalue) {
            System.out.println("Invalid Input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            NewMinvalue = NumberGuessingOOPGame.input.nextInt();
            System.out.print("Enter the max value: ");
            newMaxValue = NumberGuessingOOPGame.input.nextInt();
        }

        setMin(NewMinvalue);
        setMax(newMaxValue);
        while (newMaxTries < 0) {
            System.out.println("Invalid input: MaxTires must be greater than 0.");
            System.out.print("Enter the maximum of tires: ");
            newMaxTries = NumberGuessingOOPGame.input.nextInt();
        }

        setMaxTries(newMaxTries);
        this.guessCount = 0;
        this.win = false;
        guesses = new int[getMaxTries()];
    }

    @Override
    public boolean playSingleGame() {
        generateAnswer();
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int answer = getAnswer();
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
        setAttemp(0);
        for (int i = 0; i < maxTries; i++) {
            this.guessCount++;
            System.out.print(String.format("Enter an inter between %d and  %d: ", min, max));
            int playerGuesses = NumberGuessingOOPGameV3.input.nextInt();
            while (playerGuesses < min || playerGuesses > max) {
                System.out.println(String.format(String.format("The number must be between %d and %d ", min, max)));
                System.out.print(String.format("Enter an inter between %d and  %d: ", min, max));
                playerGuesses = NumberGuessingOOPGame.input.nextInt();
            }
            guesses[i]=playerGuesses;
            if (playerGuesses != answer && i + 1 == maxTries) {
                System.out.println(String.format("Sorry, you've used all your attempt. the correct. The correct answer was: %d", answer));
                win = false;
                break;
            } else if (playerGuesses == answer) {
                System.out.println(String.format("Congratulations! You've guessed the number in %d attemps.", i + 1));
                win = true;
                break;
            } else {
                System.out.println(playerGuesses < answer ? "Try a higher number!" : "Try a lower number!");
            }
        }
        return this.win;
    }

    public static void addGameRecord(GuessGameV3 game) {
        GuessGameV3 newGame = new GuessGameV3(game.getMin(),game.getMax(),game.getMaxTries());
        newGame.guesses =game.guesses.clone();
        newGame.guessCount = game.guessCount;
        newGame.win=game.win;
        gameRecords[recordIndex] =newGame;
        recordIndex++;
    }

    public static void getGameLog() {
        System.out.println("view:");
        System.out.println("1.Complete Records");
        System.out.println("2.Specific Game Records");
        int options = NumberGuessingOOPGameV3.input.nextInt();
        if (options == 1){
            for (int i = 0; i < recordIndex; i++) {
                System.out.println("GAME "+(i+1)+(gameRecords[i].toString()));
            }
        } else if(options ==2){
            System.out.print("Enter Records to show:");
            int roundOfRecord = NumberGuessingOOPGameV3.input.nextInt();
            System.out.println("GAME "+(roundOfRecord)+(gameRecords[roundOfRecord-1].toString()));
        }
        
        
    }
    
    @Override
    public String toString() {
        StringBuilder valueOfGuesses =new StringBuilder();
        for(int i =0;i<this.guessCount;i++){
           valueOfGuesses.append(guesses[i]);
           if(i<guessCount-1){
            valueOfGuesses.append(", ");
           }
        }
        return ": Range: ["+getMin()+"-"+getMax()+
                "], Max Tries:"+getMaxTries()+", Attempts: "+(guessCount+1)+
                ", Result: "+(this.win? "win":"Lose")+", Guesses: "+valueOfGuesses;
    }

}
