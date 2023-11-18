package jm.exercises.set08;

public class LeastSquaresEstimator {
    private final double m;
    private final double b;
    public LeastSquaresEstimator(Point[] points) {
        double meanX = 0;
        double meanY = 0;
        for (Point p : points) {
            meanX += p.getX();
            meanY += p.getY();
        }
        meanX /= points.length;
        meanY /= points.length;

        double numerator = 0;
        double denominator = 0;
        for (Point p : points) {
            numerator += (p.getX() - meanX) * (p.getY() - meanY);
            denominator += (p.getX() - meanX) * (p.getX() - meanX);
        }

        this.m = numerator / denominator;
        this.b = meanY - this.m * meanX;
     }
    public double getM() {
        return m;
    }
    public double getB() {
        return b;
    }
    public double getY(double x) {
        return m * x + b;
    }
}
