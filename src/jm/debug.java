package jm;
import jm.exercises.set07.Point;
public class debug {
    static int i;
    public static void main(String[] args) {
        stackoverflow();
    }
    public static void stackoverflow(){
        System.out.println(i++);
        stackoverflow();
    }
}