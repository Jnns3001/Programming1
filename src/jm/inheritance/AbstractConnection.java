package jm.inheritance;

public abstract class AbstractConnection implements ResistanceNetwork{
    protected ResistanceNetwork part1;
    protected ResistanceNetwork part2;

    protected AbstractConnection(ResistanceNetwork p1, ResistanceNetwork p2){
        part1 = p1;
        part2 = p2;
    }
    @Override
    public int getResistorCount() {
        return part1.getResistorCount() + part2.getResistorCount();
    }

    @Override
    public Resistor[] getResistors() {
        Resistor[] list = new Resistor[getResistorCount()];
        int i = 0;
        for (Resistor r : part1.getResistors())
            list[i++] = r;
        for (Resistor r : part2.getResistors())
            list[i++] = r;
        return list;
    }
}
