package jm.inheritance;

public class ParallelConnection extends AbstractConnection implements ResistanceNetwork{
    public ParallelConnection(ResistanceNetwork p1, ResistanceNetwork p2) {
        super(p1, p2);
    }

    @Override
    public double getResistance() {
        double r1 = part1.getResistance();
        double r2 = part2.getResistance();
        return r1*r2/(r1+r2);
    }
}
