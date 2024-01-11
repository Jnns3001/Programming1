package jm.exercises.set12;

public interface Vector {
    public double[] get();
    public void set(double... coords);

    /**
     * Multiplies the elements of this vector with scalar factor and
     * returns the result. The vector is not changed by this operation!
     */
    public Vector mult(double factor);

    /**
     * Adds this vector and <code>vec</code> and returns the result.
     * Input vectors are not changed.
     */
    public Vector plus(Vector vec);

    /**
     * Subtracts <code>vec</code> from this vector and returns the
     * result. Input vectors are not changed.
     */
    public Vector minus(Vector vec);
}