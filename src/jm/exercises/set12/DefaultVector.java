package jm.exercises.set12;

public class DefaultVector implements Vector{
    private double[] coords;

    public DefaultVector(double... coords){
        this.coords = coords;
    }

    @Override
    public double[] get() {
        return coords.clone();
    }

    @Override
    public void set(double... coords) {
        this.coords = coords;
    }

    @Override
    public Vector mult(double factor) {
        double[] newCoords = coords.clone();
        for (int i = 0; i < newCoords.length; i++) {
            newCoords[i] *= factor;
        }
        return new DefaultVector(newCoords);
    }

    @Override
    public Vector plus(Vector vec) {
        if (coords.length != vec.get().length) {
            System.err.println("Vectors have different Dimensions");
            return null;
        }
        double[] newCoords = coords.clone();
        for (int i = 0; i < newCoords.length; i++) {
            newCoords[i] += vec.get()[i];
        }
        return new DefaultVector(newCoords);
    }

    @Override
    public Vector minus(Vector vec) {
        if (coords.length != vec.get().length) {
            System.err.println("Vectors have different Dimensions");
            return null;
        }
        double[] newCoords = coords.clone();
        for (int i = 0; i < newCoords.length; i++) {
            newCoords[i] -= vec.get()[i];
        }
        return new DefaultVector(newCoords);
    }
}
