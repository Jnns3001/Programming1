package jm.inheritance;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ResistanceNetwork rges = new ParallelConnection(
                new Resistor(600),
                new ParallelConnection(
                        new SerialConnection(
                                new Resistor(400),
                                new Resistor(500)
                        ),
                        new SerialConnection(
                                new Resistor(200),
                                new ParallelConnection(
                                        new Resistor(100),
                                        new Resistor(300)
                                )
                        )
                )
        );
        System.out.println(rges.getResistance());
        System.out.println(rges.getResistorCount());
        System.out.println(Arrays.toString(rges.getResistors()));
    }
}
