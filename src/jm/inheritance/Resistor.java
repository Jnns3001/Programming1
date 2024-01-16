package jm.inheritance;

public class Resistor implements ResistanceNetwork{
    private final double resistance;

    public Resistor(double r){
        resistance = r;
    }
    @Override
    public double getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return "R = " +resistance + "Ω}";
    }

    @Override
    public int getResistorCount() {
        return 1;
    }

    @Override
    public Resistor[] getResistors() {
        return new Resistor[]{this};
    }
}
