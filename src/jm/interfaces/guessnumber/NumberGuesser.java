package jm.interfaces.guessnumber;

public interface NumberGuesser {
    void setRange(int min, int max);
    int getGuess();
    void provideFeedback(String text); // smaller greater
    void provideStatistics(int attempts);
}
