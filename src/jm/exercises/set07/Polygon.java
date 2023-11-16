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

        for (int i = 0; i < points.length; i++) {
            a += getP(i).getX() * (getP(i+1).getY() - getP(i-1).getY());
        }
        return 0.5*a;
    }
    public void smooth() {
        Point[] newpoints = new Point[points.length*2];

        for (int i = 0; i < points.length; i++) {
            Point vector = new Point(getP(i+1).getX()-getP(i).getX(), getP(i+1).getY()-getP(i).getY()); // P(i+1)-P(i) vector of line
            newpoints[2*i] = new Point(getP(i).getX()+(1.0/3)* vector.getX(),getP(i).getY()+(1.0/3)* vector.getY()); // P(i)+ 1/3*vector
            newpoints[2*i+1] = new Point(getP(i).getX()+(2.0/3)* vector.getX(),getP(i).getY()+(2.0/3)* vector.getY()); // P(i)+ 2/3*vector
        }
        this.points = newpoints;
    }
}
