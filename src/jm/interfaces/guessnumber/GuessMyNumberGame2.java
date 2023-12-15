package jm.interfaces.guessnumber;

import java.util.Random;

public class GuessMyNumberGame2 {

    private final static Random random  = new Random();

    public final static int min = 1;
    public final static int max = 10000;
    private int attempts;
    private int myNumber;

    public void playGame(NumberGuesser guesser) {
        guesser.setRange(min, max);
        myNumber = random.nextInt(max-min+1) + min;
        while (true) {
            int guess = guesser.getGuess();
            attempts++;
            if (guess == myNumber) {
                break;
            }
            guesser.provideFeedback(myNumber < guess ? "smaller" : "bigger");
        }
        guesser.provideStatistics(attempts);
    }
    public static void main(String[] args) {
        GuessMyNumberGame2 game = new GuessMyNumberGame2();
        //game.playGame(new AskUserNumberGuesser());
        game.playGame(new BinarySearchNumberGuesser());
    }
}
