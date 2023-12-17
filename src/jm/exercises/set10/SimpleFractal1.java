package jm.exercises.set10;

import rl.util.painttool.PaintTool;

import java.awt.*;

public class SimpleFractal1 {
    private final int maxDepth;
    private final int deg;
    public SimpleFractal1(int maxDepth, int deg) {
        this.maxDepth = maxDepth;
        this.deg = deg;
    }

    public Vector2D get3rdPoint(Vector2D v1, Vector2D v2, int deg) {
        Vector2D diffvec = v2.minus(v1);
        return diffvec.rotate(deg).mult(Math.cos(Math.toRadians(deg))).plus(v1);
    }

    public void calcFractal(PaintTool ptool, int depth, Vector2D v1, Vector2D v2) {
        if (depth >= maxDepth) return;

        ptool.setColor(new Color(255-5*depth, 10*depth, 10*depth));
        ptool.addLine((int) v1.getX(), (int) v1.getY(), (int) v2.getX(), (int) v2.getY());

        Vector2D v3 = get3rdPoint(v1, v2, deg);

        calcFractal(ptool, depth+1, v1, v3);
        calcFractal(ptool, depth+1, v3, v2);
    }
}
