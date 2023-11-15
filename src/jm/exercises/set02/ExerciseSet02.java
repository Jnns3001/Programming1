package jm.exercises.set02;

import jm.Terminal;

public class ExerciseSet02 {
    public static void main(String[] args) {
        int num = Terminal.readInt("Provide a number");
        System.out.println(computeSum(num));
        printSequence1(num);
        printSequence2(num);
        printSequence3(num);
        printTriangle(num);
    }
    public static int computeSum(int number) {
        int result = 0;
        int i = 1;
        while (i <= number) {
            result = result + i;
            i = i + 1;
        }
        return result;
    }
    public static void printSequence1(int elements){
        System.out.print("Sequence 1:");
        for (int i = 0; i<elements; i++){
            System.out.print(i*i+ " ");
        }
        System.out.println();
    }
    public static void printSequence2(int elements){
        int n = 1;
        System.out.print("Sequence 2:");
        for (int i = 0; i<elements; i++){
            if(i%2 == 0){
                n = -1;
            }else{
                n = 1;
            }
            System.out.print(i*n + " ");

        }
        System.out.println();
    }
    public static void printSequence3(int elements){
        int n = 0;
        System.out.print("Triangular numbers:");
        for (int i = 0; i<elements; i++){
            n += i;
            System.out.print(n + " ");
        }
        System.out.println();
    }
    public static void printTriangle(int n ){
        System.out.println("Visualizes the "+ n +"-th triangular number:");
        for (int i = 1; i<=n; i++){
            for (int x = n; x>i; x--){
                System.out.print("  ");
            }
            for (int x = 0; x<i; x++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
