package rl.prog1.exercises.set12;


public class VectorMathFactory {
	private static boolean efficientModeEnabled = true;
	
	public static void enableEfficientMode(boolean b) {
		efficientModeEnabled = b;
	}
	
	public static Vector createVector(int size) {
		if (efficientModeEnabled && size == 2)
			return new Vector2();
		else
			return new DefaultVector(size);
	}
	
	public static Vector createVector(double... values) {
		Vector result = createVector(values.length);
		result.set(values);
		return result;
	}
	
	public static Matrix createMatrix(int rows, int cols) {
		if (efficientModeEnabled)
			return new EfficientMatrix(rows, cols);
		else
			return new DefaultMatrix(rows, cols);
	}
	
	public static Matrix createRotationMatrix(int deg) {
		double angle = deg * 2.0 * Math.PI / 360.0;
		Matrix result = createMatrix(2, 2);
		result.set(0, 0, Math.cos(angle));
		result.set(0, 1, -Math.sin(angle));
		result.set(1, 0, Math.sin(angle));
		result.set(1, 1, Math.cos(angle));
		return result;
	}
}
