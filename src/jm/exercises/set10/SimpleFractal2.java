package jm.exercises.set10;

import rl.util.painttool.PaintTool;

import java.awt.*;

public class SimpleFractal2 {
    private final int maxDepth;
    private final int deg;
    public SimpleFractal2(int maxDepth, int deg) {
        this.maxDepth = maxDepth;
        this.deg = deg;
    }

    public Vector2D get3rdPoint(Vector2D v1, Vector2D v2, int deg) {
        Vector2D diffvec = v2.minus(v1);
        return diffvec.rotate(deg).mult(Math.cos(Math.toRadians(deg))).plus(v1);
    }

    public void calcFractal(PaintTool ptool, int depth, Vector2D v1, Vector2D v2) {
        if (depth >= maxDepth) return;

        Vector2D v3 = get3rdPoint(v1, v2, deg);

        if (depth%2 == 0) ptool.setColor(Color.RED);
        else ptool.setColor(Color.BLUE);

        int[] x = {(int) v1.getX(), (int) v2.getX(), (int) v3.getX()};
        int[] y = {(int) v1.getY(), (int) v2.getY(), (int) v3.getY()};
        ptool.addPolygon(x, y, true);

        calcFractal(ptool, depth+1, v1, v3);
        calcFractal(ptool, depth+1, v3, v2);
    }
}
