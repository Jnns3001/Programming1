import java.util.Arrays;
public class ExerciseSet05 {
    public static void main(String[] args) {
        menu();
    }
    public static String pv(double[] v) {
        StringBuilder res = new StringBuilder("( ");
        for (double n : v) {
            res.append(String.format("%.2f", n)).append(" ");
        }
        res.append(")");
        return res.toString();
    }
    public static void calcInterest() {
        double fund = Terminal.readDouble("Geben Sie das Anfangskapital ein [in Euro]");
        double interestRate = Terminal.readDouble("Bitte geben Sie den Zinssatz ein [in %]")/100;
        int years = Terminal.readInt("Geben Sie die Anlagedauer ein [in Jahren]");

        for (int i = 1; i <= years; i++) {
            fund *= 1 + interestRate;
            System.out.printf("Kapital nach %d Jahren: %.2f\n", i, fund);

        }
    }
    public static void calcGrades() {
        int n = Terminal.readInt("Wie viele Zahlen sollen analysiert werden");
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Terminal.readDouble("naechste Zahl");
        }
        System.out.println("OK. Die Zahlen lauten:");
        for (double num : nums) {
            System.out.print(" " + num);
        }
        double min = nums[0];
        double max = nums[0];
        double med = 0;
        for (double num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            med += num;
        }
        System.out.printf("\nMin: %.2f Max: %.2f Durchschnitt: %.2f\n", min, max, med/n);
    }
    /**
     * Multiplies the elements of <code>vec</code> with scalar
     * factor and returns the result. <code>vec</code> is not
     * changed by this operation!
     */
    public static double[] mult(double[] vec, double factor) {
        double[] ovec = new double[vec.length];
        for (int i = 0; i < vec.length; i++) {
             ovec[i] = vec[i] * factor;
        }
        return ovec;
    }

    /**
     * Adds the vectors <code>vec1</code> and <code>vec2</code>
     * and returns the result. Input vectors are not changed.
     */
    public static double[] plus(double[] vec1, double[] vec2) {
        double[] ovec = new double[vec1.length];
        for (int i = 0; i < vec1.length; i++) {
            ovec[i] = vec1[i] + vec2[i];
        }
        return ovec;
    }
    /**
     * Subtracts <code>vec2</code> from <code>vec1</code> and
     * returns the result. Input vectors are not changed.
     */
    public static double[] minus(double[] vec1, double[] vec2) {
        double[] ovec = new double[vec1.length];
        for (int i = 0; i < vec1.length; i++) {
            ovec[i] = vec1[i] - vec2[i];
        }
        return ovec;
    }
    /**
     * Rotates the two-dimensional vector <code>vec</code> by
     * <code>deg</code> degrees and returns the result.
     */
    public static double[] rotate2d(double[] vec, int deg) {
        double[] ovec = new double[2];
        double angle = Math.toRadians(deg);
        ovec[0] = Math.cos(angle) * vec[0] - Math.sin(angle) * vec[1];
        ovec[1] = Math.sin(angle) * vec[0] + Math.cos(angle) * vec[1];
        return ovec;
    }
    /**
     * Returns the Euclidean norm of the vector
     * <code>vec</code>.
     */
    public static double vlength(double[] vec) {
        double length = 0;
        for (double v : vec) {
            length += Math.pow(v, 2);
        }
        return Math.sqrt(length);
    }
    public static double[] nextMoleHill(double[] actual, double[] previous) {
        double[] nextHill;
        nextHill = minus(actual, previous); //get previous dig vector
        nextHill = rotate2d(nextHill, 5); //rotate dv by 5°
        nextHill = mult(nextHill, 0.99*vlength(nextHill)); //shorten the dc by 1%
        nextHill = plus(nextHill, actual); //move previous dv to actual pos
        return nextHill;
    }
    public static double[] after100Hills(double[] actual, double[] previous) {
        double[] lastHill = new double[2];
        for (int i = 0; i < 100; i++) {
            lastHill = nextMoleHill(actual, previous);
        }
        return lastHill;
    }
    public static void menu() {
        while (true) {
            System.out.print(
                    """
                    
                    1 : Zinsberechnung
                    2 : Durchschnittsberechnung
                    3 : Vektor-Test
                    4 : Maulwurfsimulation
                    0 : Beenden
                    """
            );
            switch (Terminal.readInt("Ihre Wahl")) {
                case 0:
                    return;
                case 1:
                    calcInterest();
                    break;
                case 2:
                    calcGrades();
                    break;
                case 3:
                    double[] v1 = {Terminal.readDouble("Vektor 1, x"), Terminal.readDouble("Vektor 1, y")};
                    double[] v2 = {Terminal.readDouble("Vektor 1, x"), Terminal.readDouble("Vektor 1, y")};
                    double faktor = Terminal.readDouble("Faktor");
                    int deg = Terminal.readInt("Winkel (in Grad)");

                    System.out.println("v1 * fact : " + pv(mult(v1, faktor)));
                    System.out.println("v1 + v2 : " + pv(plus(v1, v2)));
                    System.out.println("v1 - v2 : " + pv(minus(v1, v2)));
                    System.out.println("vlength(v1) : " + (vlength(v1)));
                    System.out.println("rot(v1, deg) : " + pv(rotate2d(v1, deg)));
                    System.out.println("next molehill : " + pv(nextMoleHill(v1, v2)));
                    break;
                case 4:
                    double[] vec10 = {1, 0};
                    double[] vec00 = {0, 0};
                    System.out.println(pv(after100Hills(vec10, vec00)));
                    break;
            }
        }
    }
}