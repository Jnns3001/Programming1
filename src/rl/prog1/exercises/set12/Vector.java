package rl.prog1.exercises.set12;

public interface Vector {
	int size();
	double get(int i);
	void set(int i, double value);
	void set(double... values);
	
	/**
	 * Multiplies the elements of this vector with scalar factor and returns the
	 * result. The vector is not changed by this operation!
	 */
	public Vector multiply(double factor);

	/**
	 * Adds this vector and <code>vec</code> and returns the result. Input
	 * vectors are not changed.
	 */
	Vector plus(Vector vec);

	/**
	 * Subtracts <code>vec</code> from this vector and returns the result. Input
	 * vectors are not changed.
	 */
	Vector minus(Vector vec);

	/** Returns the Euclidean norm of this vector. */
	double vlength();
	
}
