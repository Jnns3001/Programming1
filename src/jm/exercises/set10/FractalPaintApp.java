package jm.exercises.set10;

import jm.exercises.set08.LSEPaintController;
import rl.util.painttool.PaintDemoController;
import rl.util.painttool.PaintTool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class FractalPaintApp {
	/**
	 * Starts the application by creating a {@link PaintDemoController},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new FractalPaintController());
		ptool.setVisible(true);
	}
}
