package jm.exercises.set10;

import rl.util.painttool.PaintTool;

import java.awt.*;

public class PythagorasTreeFractal {
    private final int maxDepth;
    private final int deg;
    public PythagorasTreeFractal(int maxDepth, int deg) {
        this.maxDepth = maxDepth;
        this.deg = deg;
    }

    public Vector2D get3rdPoint(Vector2D v1, Vector2D v2, int deg) {
        Vector2D diffvec = v2.minus(v1);
        return diffvec.rotate(deg).mult(Math.cos(Math.toRadians(deg))).plus(v1);
    }

    public void calcFractal(PaintTool ptool, int depth, Vector2D v1, Vector2D v2) {
        if (depth >= maxDepth) return;

        Vector2D v3 = v2.minus(v1).rotate(-90).plus(v1); //vector that points to the top left corner of the ractangle on the baseline
        Vector2D v4 = v2.minus(v1).rotate(-90).plus(v2); //vector that points to the top right corner of the ractangle on the baseline

        Vector2D v5 = get3rdPoint(v3, v4, deg);

        //rgb(92, 64, 51) Brown
        //rgb(50, 205, 50) Lime Green
        ptool.setColor(new Color(92-2*depth, 64+7*depth, 50));

        int[] x = {(int) v1.getX(), (int) v2.getX(), (int) v4.getX(), (int) v3.getX()};
        int[] y = {(int) v1.getY(), (int) v2.getY(), (int) v4.getY(), (int) v3.getY()};
        ptool.addPolygon(x, y, true);

        calcFractal(ptool, depth+1, v3, v5);
        calcFractal(ptool, depth+1, v5, v4);
    }
}
