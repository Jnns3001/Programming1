package jm.exercises.set11;


//https://stackoverflow.com/questions/19654251/random-point-inside-triangle-inside-java
public class Triangle {
    private final Point A;
    private final Point B;
    private final Point C;

    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public Point getRandomPoint(){
        double r1 = Math.random();
        double r2 = Math.random();

        double sqrtR1 = Math.sqrt(r1);

        double x = (1 - sqrtR1) * A.getX() + (sqrtR1 * (1 - r2)) * B.getX() + (sqrtR1 * r2) * C.getX();
        double y = (1 - sqrtR1) * A.getY() + (sqrtR1 * (1 - r2)) * B.getY() + (sqrtR1 * r2) * C.getY();

        return new Point(x, y);
    }
}