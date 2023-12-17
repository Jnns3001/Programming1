package jm.exercises.set10;

public class rfac {
    public static int calcFac(int n) {
        if (n <= 1) return 1;
        else return n*calcFac(n-1);
    }

    public static void main(String[] args) {
        System.out.println(calcFac(3));
        // für n=3 wird rfac 3x aufgerufen
    }
}
