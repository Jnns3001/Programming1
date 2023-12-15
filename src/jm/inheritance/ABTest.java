package jm.inheritance;

public class ABTest {

    public static String using(A a) {
        return "Using A";
    }
    public static String using(B b) {
        return "Using B";
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A b1 = new B();

        System.out.println(b.m1());
        System.out.println(b1.m1());


        System.out.println(using(a));
        System.out.println(using((A) b));
        System.out.println(using(b1));

        System.out.println(b1.a);
    }
}
