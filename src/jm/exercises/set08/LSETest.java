package jm.exercises.set08;

import rl.util.painttool.PaintDemoController;
import rl.util.painttool.PaintTool;

public class LSETest {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {
        Point[] points = {new Point(1,1), new Point(2,2)};
        LeastSquaresEstimator lse = new LeastSquaresEstimator(points);
        System.out.println("m: "+ lse.getM());
        System.out.println("b: "+ lse.getB());
        System.out.println("y(3) = "+ lse.getY(3));
    }
    public static void test2() {
        /*
        Verkaeufe in Monat 1: 15
        Verkaeufe in Monat 2: 37
        Verkaeufe in Monat 3: 52
        Verkaeufe in Monat 4: 59
        Verkaeufe in Monat 5: 83
        Verkaeufe in Monat 6: 92
        Geschaetzte Verkaeufe in Monat 7: 109
        Geschaetzte Verkaeufe in Monat 8: 124
        Geschaetzte Verkaeufe in Monat 9: 140
        Geschaetzte Verkaeufe in Monat 10: 155
        Geschaetzte Verkaeufe in Monat 11: 170
        Geschaetzte Verkaeufe in Monat 12: 185
        */
        int[] sells = {15, 37, 52, 59, 83, 92};
        Point[] points = new Point[sells.length];
        for (int i = 0; i < sells.length; i++) {
            points[i] = new Point(i, sells[i]);
            System.out.println("Verkaeufe in Monat "+ i + ": "+ sells[i]);
        }
        LeastSquaresEstimator lse = new LeastSquaresEstimator(points);

        for (int i = sells.length; i < 12; i++) {
            int y = Math.toIntExact(Math.round(lse.getY(i)));
            System.out.println("Geschaetzte Verkaeufe in Monat "+ i + ": "+ y);
        }
    }
}
