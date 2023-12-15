package jm.interfaces.guessnumber;

public class BinarySearchNumberGuesser implements NumberGuesser{
    private int min;
    private int max;
    private int currGuess;
    @Override
    public void setRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getGuess() {
        currGuess = (min + max)/2;
        //System.out.println(currGuess);
        return currGuess;
    }

    @Override
    public void provideFeedback(String text) {
        if (text.equals("smaller"))
            max = currGuess - 1;
        else if (text.equals("bigger"))
            min = currGuess + 1;

        //System.out.println("My Number is "+ text + "!");
    }

    @Override
    public void provideStatistics(int attempts) {
        System.out.println("You needed "+ attempts +" tries");
    }
}
