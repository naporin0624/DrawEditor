package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> Sfig, Cfig, Lfig;
	protected Figure drawingFigure;
	protected Color currentColor = Color.red;
	private String s = "square";

	public DrawModel() {
		Sfig = new ArrayList<Figure>();
		Cfig = new ArrayList<Figure>();
		Lfig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}

	public void ChangeColor(Color c) {
		currentColor = c;
	}

	public void ChangeShape(String s) {
		this.s = s;
	}

	public ArrayList<Figure> getSquareF() {
		return Sfig;
	}

	public ArrayList<Figure> getCircleF() {
		return Cfig;
	}

	public ArrayList<Figure> getLineF() {
		return Lfig;
	}

	public Figure getFigureS(int idx) {
		return Sfig.get(idx);
	}

	public Figure getFigureC(int idx) {
		return Cfig.get(idx);
	}

	public Figure getFigureL(int idx) {
		return Lfig.get(idx);
	}

	public void createFigure(int x, int y) {
		if (s == "square") {
			Figure SquareF = new RectangleFigure(x, y, 0, 0, currentColor);
			Sfig.add(SquareF);
			drawingFigure = SquareF;
		}
		if (s == "circle") {
			Figure CircleF = new RectangleFigure(x, y, 0, 0, currentColor);
			Cfig.add(CircleF);
			drawingFigure = CircleF;
		} else if (s == "line") {
			Figure LineF = new RectangleFigure(x, y, 0, 0, currentColor);
			Lfig.add(LineF);
			drawingFigure = LineF;
		}
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			if(s=="line")drawingFigure.reshapeline(x1, y1, x2, y2);
			else drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}