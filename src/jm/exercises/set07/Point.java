package jm.exercises.set07;
public class Point {
    private final double x;
    private final double y;
    public Point(double xcord, double ycord) {
        x = xcord;
        y = ycord;
    }
    public String toString() {
        return "Point("+ x +", "+ y +")";
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
