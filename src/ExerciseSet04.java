public class ExerciseSet04 {
    public static void main(String[] args) {
        startByteOverflowDemo();
        demonstrateArithmeticOperations();
        convertToBinary();
        convertHexToDec0();
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
    public static void demonstrateArithmeticOperations() {
        final int a = Terminal.readInt("Please provide a number for the first operand");
        final int b = Terminal.readInt("Please provide a number for the second operand");
        System.out.println(a + " + " + b + " = " + (a+b));
        System.out.println(a + " - " + b + " = " + (a-b));
        System.out.println(a + " * " + b + " = " + (a*b));
        System.out.println(a + " / " + b + " = " + (a/b));
        System.out.println(a + " % " + b + " = " + (a%b));
    }
    public static void convertToBinary() {
        int decimal = Terminal.readInt("Please provide a number");
        System.out.println("Binary representation (from bottom to top!):");
        do {
            System.out.println((decimal%2));
            decimal = decimal / 2;
        }while (decimal != 0);
    }
    /**
     * Template which reads a line of symbols and prints each symbol together
     * with its code number. It can be used as starting point for the
     * implementation of a hex-to-dec converter.
     */
    public static void convertHexToDec0() {
        System.out.print("Please provide a hexadecimal number (e.g. 1f): ");
        int result = 0;
        char ch = Terminal.readChar();
        while (ch != '\n') {
            int hex = convertToNumber(ch);
            result = result * 16 + hex;
            ch = Terminal.readChar();
        }
        System.out.println("Corresponding decimal number: " + result);
    }
    /**
     * Converts a hexadecimal digit into the corresponding
     * number.
     * @return value 0-16 or -1 for wrong digits.
     */
    public static int convertToNumber(char ch) {
        if (ch < 48) {
            return -1;
        } else if (ch < 58) {
            return ch - 48;
        } else if (ch < 97) {
            return -1;
        }else if (ch < 103) {
            return ch - 97 + 10;
        }else {
            return -1;
        }
    }
}