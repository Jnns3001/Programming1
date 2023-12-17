package jm.exercises.set10;

import rl.util.painttool.AbstractController;
import rl.util.painttool.DrawableObject;
import rl.util.painttool.PaintTool;

import java.awt.*;
import java.util.Random;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class FractalPaintController extends AbstractController {
	int deg = 45;
	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Fractal Demo";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "30 Deg", "42 Deg", "45 Deg", "Random Deg", "Simple Fractal1", "Simple Fractal2" ,"Pythagoras Tree"};
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();

		Random random = new Random();

		if (button == 0) deg = 30;
		else if (button == 1) deg = 42;
		else if (button == 2) deg = 45;
		else if (button == 3) deg = random.nextInt(0,90);
        else if (button == 4) {
			Vector2D v1 = new Vector2D(0.3*cWidth, 0.7*cHeight);
			Vector2D v2 = new Vector2D(0.7*cWidth, 0.7*cHeight);
			SimpleFractal1 f1 = new SimpleFractal1(20, -1*deg);
			f1.calcFractal(ptool, 0, v1, v2);
        }
		else if (button == 5) {
			Vector2D v1 = new Vector2D(0.3*cWidth, 0.7*cHeight);
			Vector2D v2 = new Vector2D(0.7*cWidth, 0.7*cHeight);
			SimpleFractal2 f2 = new SimpleFractal2(20, -1*deg);
			f2.calcFractal(ptool, 0, v1, v2);
		}
		else if (button == 6) {
			Vector2D v1 = new Vector2D(0.45*cWidth, 0.7*cHeight);
			Vector2D v2 = new Vector2D(0.55*cWidth, 0.7*cHeight);
			PythagorasTreeFractal f3 = new PythagorasTreeFractal(20, -1*deg);
			f3.calcFractal(ptool, 0, v1, v2);
		}
	}

	/**
	 * Prints a text on the canvas at the point where the click was done. It
	 * describes the state of the mouse.
	 */
	@Override
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
			boolean isShiftDown, boolean isControlDown) {
		return;
	}
}
