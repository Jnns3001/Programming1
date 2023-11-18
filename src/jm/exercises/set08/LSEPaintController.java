package jm.exercises.set08;

import rl.util.painttool.AbstractController;
import rl.util.painttool.DrawableObject;
import rl.util.painttool.PaintTool;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class LSEPaintController extends AbstractController {
	DrawableObject o1;
	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Linear Regression Paint Demo";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "„Perform Linear Regression" };
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();

        if (button == 0) {

			ptool.removeObject(o1);
            ptool.setColor(Color.RED);

            int pnum = ptool.getDrawableObjects().size();
            Point[] points = new Point[pnum];
            for (int i = 0; i < pnum; i++) {
                DrawableObject p = ptool.getDrawableObjects().get(i);
                points[i] = new Point(p.getX(), p.getY());
            }

            LeastSquaresEstimator lse = new LeastSquaresEstimator(points);
            int x0 = 20;
            int y0 = (int) lse.getY(x0);
            int x1 = cWidth - 20;
            int y1 = (int) lse.getY(x1);
            o1 = ptool.addLine(x0, y0, x1, y1);
        }
	}

	/**
	 * Prints a text on the canvas at the point where the click was done. It
	 * describes the state of the mouse.
	 */
	@Override
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
			boolean isShiftDown, boolean isControlDown) {
		ptool.setColor(Color.RED);
		ptool.addCircle(x, y, 5, true);
	}
}
