package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	protected Figure drawingFigure, F;
	protected Color currentColor = Color.red;
	private String s = "square";

	public DrawModel() {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}

	public void ChangeColor(Color c) {
		currentColor = c;
	}

	public void ChangeShape(String s) {
		this.s = s;
	}

	public ArrayList<Figure> getFigure() {
		return fig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void createFigure(int x, int y) {
		if (s == "square")
			F = new RectangleFigure(x, y, 0, 0, currentColor);
		else if (s == "circle")
			F = new CircleFigure(x, y, 0, 0, currentColor);
		else if (s == "circleFull")
			F = new CircleFullFigure(x, y, 0, 0, currentColor);
		else if (s == "line")
			F = new LineFigure(x, y, x, y, currentColor);
		else if (s == "poligen")
			F = new PoligenFigure(x, y, x, y, currentColor);
		fig.add(F);
		drawingFigure = F;
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			if (s == "line" || s == "poligen")
				drawingFigure.reshapeline(x1, y1, x2, y2);
			else
				drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}