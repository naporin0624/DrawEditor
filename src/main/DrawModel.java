package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	protected Figure drawingFigure, F;
	protected Color currentColor = Color.red;
	protected double angle;
	private String s = "square";
	private float size = 1.0f;

	public DrawModel() {
		fig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}

	public void setColor(Color c) {
		currentColor = c;
	}

	public void setShape(String s) {
		this.s = s;
	}
	public String getShape() {
		return s;
	}

	public ArrayList<Figure> getFigure() {
		return fig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void createFigure(int x, int y) {
		System.out.println(s);
		if (s == "square")
			F = new RectangleFigure(x, y, 0, 0, size, currentColor);
		else if (s == "SFull")
			F = new RectangleFigureFull(x, y, 0, 0, size, currentColor);
		else if (s == "circle")
			F = new CircleFigure(x, y, 0, 0, size, currentColor);
		else if (s == "CFull")
			F = new CircleFullFigure(x, y, 0, 0, size, currentColor);
		else if (s == "line")
			F = new LineFigure(x, y, x, y, size, currentColor);
		else if (s == "poligen")
			F = new PoligenFigure(x, y, x, y, size, currentColor);
		else if (s == "PFull")
			F = new PoligenFigureFull(x, y, x, y, size, currentColor);
		fig.add(F);
		drawingFigure = F;
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (drawingFigure != null) {
			if (s == "line" || s == "poligen" || s == "PFull")
				drawingFigure.reshapeline(x1, y1, x2, y2);
			else
				drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}
}