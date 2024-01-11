package jm.exercises.set11;

import rl.util.painttool.AbstractController;
import rl.util.painttool.PaintTool;

import javax.swing.*;
import java.awt.*;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class XmasController extends AbstractController {

	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Xmas App";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "Print Tree", "?" };
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();
		int width = (int) (0.05*cWidth);
		Point left = new Point(cWidth /4, cHeight-width*1.5);
		Point right = new Point(cWidth*3/4, cHeight-width*1.5);
		Point top = new Point(cWidth/2, width);
		switch (button) {
		case 0:
			Triangle tree = new Triangle(left, right, top);
			ptool.setColor(Color.BLACK);
			ptool.addRectangle((cWidth-width)/2, (int) (cHeight-width*1.5), width, width,true);
			ptool.setColor(Color.GREEN);
			int[] x = {(int) left.getX(), (int) right.getX(), (int) top.getX()};
			int[] y = {(int) left.getY(), (int) right.getY(), (int) top.getY()};
			ptool.addPolygon(x, y, true);

			for (int i = 0; i < 15; i++) {
				Point p = tree.getRandomPoint();
				drawCandle(ptool ,(int) p.getX(), (int) p.getY());
			}

			break;
		case 1:
			JOptionPane.showMessageDialog(ptool.getCanvas(),
					"This Paint Demo Draws a Tree",
					"About Paint Demo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	public void drawCandle(PaintTool ptool ,int x, int y){
		ptool.setColor(Color.RED);
		ptool.addRectangle(x,y,20,32,true);
		ptool.setColor(Color.YELLOW);
		ptool.addCircle(x+10,y-10,10,true);
	}



}
