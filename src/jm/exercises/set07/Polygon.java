package jm.exercises.set07;

public class Polygon {
    private Point[] points;
    // inspired by Moritz Huckle
    public Polygon(double ... cords) {
        points = new Point[cords.length / 2];

        for (int i = 0; i < cords.length; i += 2) {
            this.points[i / 2] = new Point(cords[i], cords[i + 1]);
        }
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (Point p : points) {
            s.append(" ").append(p.toString());
        }
        s.append("}");
        return s.toString();
    }
    //again concept from Moritz Huckle
    public Point getP(int i) {
        return i >= 0 ? points[i % points.length] : points[points.length + i % points.length];
    }
    public double computeArea1() {
        double a = 0;
        for (int i = 0; i < points.length; i++) {
            a += getP(i).getX() * (getP(i + 1).getY() - getP(i - 1).getY());
        }
        return 0.5*a;
    }
    public double computeArea2() {
        double a = 0;
        for (int i = 1; i < points.length-2; i++) {
            a += getP(i).getX()*(getP(i+1).getY()-getP(i-1).getY());
        }
        return 0.5*a;
    }
}
