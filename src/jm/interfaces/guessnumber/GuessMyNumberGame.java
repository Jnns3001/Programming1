package jm.interfaces.guessnumber;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumberGame {

    private final static Random random  = new Random();
    private final static Scanner scanner = new Scanner(System.in);
    public final static int min = 1;
    public final static int max = 10;
    private int attempts;
    private int myNumber;

    public void playGame() {
        myNumber = random.nextInt(min,max+1);
        System.out.println("Guess a Number between "+ min +" and "+ max);
        while (attempts<3) {
            System.out.print("Your Guess: ");
            int guess = scanner.nextInt();
            if (guess == myNumber) {
                System.out.println("You guessed it!");
                return;
            } else {
                System.out.println("My Number "+ (myNumber < guess ? "smaller" : "bigger") + "1");
            }
            attempts++;
        }
        System.out.println("You needed to many tries");
    }
    public static void main(String[] args) {
        GuessMyNumberGame game = new GuessMyNumberGame();
        game.playGame();
        System.out.println("The Number was: "+ game.myNumber);
    }
}
