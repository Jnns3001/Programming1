package jm.interfaces.guessnumber;

import java.util.Scanner;

public class AskUserNumberGuesser implements NumberGuesser{
    private final static Scanner scanner = new Scanner(System.in);
    private int min;
    private int max;

    @Override
    public void setRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getGuess() {
        System.out.println("Guess a Number between "+ min +" and "+ max);
        return scanner.nextInt();
    }

    @Override
    public void provideFeedback(String text) {
        System.out.println("My Number "+ text + "!");

    }

    @Override
    public void provideStatistics(int attempts) {
        System.out.println("You needed "+ attempts +" tries");
    }
}
