package jm.inheritance;

public class SerialConnection extends AbstractConnection implements ResistanceNetwork{
    public SerialConnection(ResistanceNetwork p1, ResistanceNetwork p2) {
        super(p1, p2);
    }

    @Override
    public double getResistance() {
        return part1.getResistance() + part2.getResistance();
    }
}
