package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	protected Figure drawingFigure;
	protected Color currentColor = Color.red;
	private int[] ftype = new int[3];

	public DrawModel() {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}

	public void ChangeColor(Color c) {
		currentColor = c;
	}

	public ArrayList<Figure> getFigures() {
		return fig;
	}
	
	
	public void setsize(String type,ArrayList<Figure> fig){
		switch (type) {
		case "square":
			ftype[0] = fig.size();
			break;
		case "circle":
			ftype[1] = fig.size();
			break;
		case "line":
			ftype[2] = fig.size();
			break;
		default:
			break;
		}
	}
	
	public int[] getsize() {
		return ftype;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void createFigure(int x, int y) {
		Figure f = new CircleFigure(x, y, 0, 0, currentColor);
		Figure f = new RectangleFigure(x, y, 0, 0, currentColor);
		fig.add(f);
		drawingFigure = f;
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}