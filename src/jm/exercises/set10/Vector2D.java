package jm.exercises.set10;

public class Vector2D {
    private final double x;
    private final double y;

    public Vector2D (double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Multiplies the elements of this vector with scalar factor and
     * returns the result. The vector is not changed by this operation!
     */
    public Vector2D mult(double factor) {
        return new Vector2D(factor*x, factor*y);
    }

    /**
     * Adds this vector and <code>vec</code> and returns the result.
     * Input vectors are not changed.
     */
    public Vector2D plus(Vector2D vec) {
        return new Vector2D(x+vec.getX(), y+ vec.y);
    }

    /**
     * Subtracts <code>vec</code> from this vector and returns the
     * result. Input vectors are not changed.
     */
    public Vector2D minus(Vector2D vec) {
        return new Vector2D(x-vec.getX(), y-vec.y);
    }

    /**
     * Rotates this vector by <code>deg</code> degrees and returns the
     * result.
     */
    public Vector2D rotate(int deg) {
        double angle = Math.toRadians(deg);
        double newX = Math.cos(angle) * x - Math.sin(angle) * y;
        double newY = Math.sin(angle) * x + Math.cos(angle) * y;
        return new Vector2D(newX,newY);
    }

    /** Returns the Euclidean norm of this vector. */
    public double vlength() {
        return Math.sqrt(x*x + y*y);
    }
}
