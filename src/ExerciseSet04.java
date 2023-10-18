public class ExerciseSet04 {
    public static void main(String[] args) {
        startByteOverflowDemo();
    }
    public static void demonstrateArithmeticOperations() {

    }
    public static void startByteOverflowDemo() {
        byte num = 0;
        int i = 0;
        while (i < 10) {
            System.out.print(num + " ");
            num+=30;
            i++;
        }
        System.out.println();
    }
}
