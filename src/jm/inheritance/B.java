package jm.inheritance;

public class B extends A{
    public int a = 2;

    public B(int a) {
        super(a);
    }

    public String m1() {
        return "Result of B.m1";
    }
    public String m2() {
        return "Result of B.m2";
    }
}
