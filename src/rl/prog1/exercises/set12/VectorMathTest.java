package rl.prog1.exercises.set12;

import static rl.prog1.exercises.set12.VectorMathFactory.*;

public class VectorMathTest {

	public static void testOperations() {
		Vector v1 = createVector(10, 20);
		Vector v2 = createVector(-10, -20);
		Matrix m = createMatrix(2, 2);
		Matrix rm = createRotationMatrix(180);
		m.set(0, 1, 1);
		m.set(1, 0, 1);
		System.out.println("v1+v2 = " + v1.plus(v2));
		System.out.println("m*v1 = " + m.multiply(v1));
		System.out.println("rm*v1 = " + rm.multiply(v1));
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		System.out.println("m = " + m);
	}
	
	public static void startPerformanceTest() {
		long t1 = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			Vector v1 = createVector(10, 20);
			Vector v2 = createVector(20, 20);
			Matrix rm = createRotationMatrix(90);
			rm.multiply(v1.plus(v2));
		}
		long t2 = System.nanoTime();
		System.out.println("Time: " + ((t2-t1) / 1000000) + " sec");
	}
	
	public static void main(String[] args) {
		VectorMathFactory.enableEfficientMode(false);
		System.out.println("Default implementation:");
		testOperations();
		startPerformanceTest();
		VectorMathFactory.enableEfficientMode(true);
		System.out.println("Efficient implementation:");
		testOperations();
		startPerformanceTest();
	}
}
