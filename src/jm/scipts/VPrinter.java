package jm.scipts;

import rl.util.terminal.Terminal;

public class VPrinter {
    public static void main(String[] args) {
        printV(Terminal.readInt("Höhe"));
    }
    public static void printV(int height) {
        for (int row = 0; row < height; row++) {
            for (int i = 0; i < row; i++) {
                System.out.print(" ");
            }
            System.out.print("X");
            for (int i = 0; i < 2*(height-row)-1; i++) {
                System.out.print(" ");
            }
            System.out.println("X");
        }
        for (int i = 0; i < height; i++) {
            System.out.print(" ");
        }
        System.out.println("X");

    }
}
