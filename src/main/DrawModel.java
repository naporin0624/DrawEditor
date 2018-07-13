package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig,gridfig;
	protected Figure drawingFigure, F;
	protected Color currentColor = Color.red;
	private String s = "Rectangle";
	private float size = 1.0f;

	public DrawModel() {
		fig = new ArrayList<Figure>();
		gridfig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}

	public void setColor(Color c) {
		currentColor = c;
	}

	public void setShape(String s) {
		this.s = s;
	}

	public ArrayList<Figure> getFigure() {
		return fig;
	}

	public ArrayList<Figure> getGrid() {
		return gridfig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void setLine_Width(float size) {
		this.size = size;
	}

	public void createFigure(int x, int y) {
		if (gridfig.size() > 0) {
			x = GridPosition(x);
			y = GridPosition(y);
		}

		switch (s) {
			case "Rectangle":
				F = new Rectangle(x, y, 0, 0, size, currentColor);
				break;

			case "FillRectangle":
				F = new FillRectangle(x, y, 0, 0, size, currentColor);
				break;

			case "Circle":
				F = new Circle(x, y, 0, 0, size, currentColor);
				break;

			case "FillCircle":
				F = new FillCircle(x, y, 0, 0, size, currentColor);
				break;

			case "Line":
				F = new Line(x, y, x, y, size, currentColor);
				break;

			case "Triangle":
				F = new Triangle(x, y, x, y, size, currentColor);
				break;

			case "FillTriangle":
				F = new FillTriangle(x, y, x, y, size, currentColor);
				break;
		}
		
		fig.add(F);
		drawingFigure = F;
		setChanged();
		notifyObservers();
	}

	public void Gridline() {
		if (gridfig.size() > 0) {
			gridfig.clear();
		} else {
			int line = 500 / 10;
			for (int i = 0; i < line; i++) {
				int linewidth = i * 10;
				F = new Line(linewidth, 0, linewidth, 500, 1.0f, Color.GRAY);
				gridfig.add(F);
				F = new Line(0, linewidth, 500, linewidth, 1.0f, Color.GRAY);
				gridfig.add(F);
			}
		}
		setChanged();
		notifyObservers();
	}

	public void reshapeFigure(int x1, int y1, int x2, int y2) {

		if (gridfig.size() > 0) {
			x1 = GridPosition(x1);
			y1 = GridPosition(y1);
			x2 = GridPosition(x2);
			y2 = GridPosition(y2);
		}
		if (drawingFigure != null) {
			if (s == "Line" || s == "Triangle" || s == "FillTriangle")
				drawingFigure.reshapeline(x1, y1, x2, y2);
			else
				drawingFigure.reshape(x1, y1, x2, y2);
			setChanged();
			notifyObservers();
		}
	}

	private int GridPosition(int p) {
		double p1 = (double) (p) / 10;
		p1 = Math.round(p1);
		return (int) (p1 * 10);

	}
}