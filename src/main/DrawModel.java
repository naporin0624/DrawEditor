package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig, gridfig;
	protected Figure drawingFigure, F;
	protected Color currentColor = Color.red;
	private String s = "Rectangle";
	private float Line_Width = 1.0f;

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

	public void setLine_Width(float Width) {
		Line_Width = Width;
	}

	public void createFigure(int x, int y) {
		if (gridfig.size() > 0) {
			x = GridPosition(x);
			y = GridPosition(y);
		}

		switch (s) {
		case "Rectangle":
			F = new Rectangle(x, y, 0, 0, Line_Width, currentColor);
			break;

		case "FillRectangle":
			F = new FillRectangle(x, y, 0, 0, Line_Width, currentColor);
			break;

		case "Circle":
			F = new Circle(x, y, 0, 0, Line_Width, currentColor);
			break;

		case "FillCircle":
			F = new FillCircle(x, y, 0, 0, Line_Width, currentColor);
			break;

		case "Line":
			F = new Line(x, y, x, y, Line_Width, currentColor);
			break;

		case "Triangle":
			F = new Triangle(x, y, x, y, Line_Width, currentColor);
			break;

		case "FillTriangle":
			F = new FillTriangle(x, y, x, y, Line_Width, currentColor);
			break;
		}

		fig.add(F);
		drawingFigure = F;
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
			drawingFigure.reshape(x1, y1, x2, y2, s);
			setChanged();
			notifyObservers();
		}
	}

	public void AllClear() {
		//図形を保存しているfigリストのデータをすべて削除
		//リストの操作が終了したらViewPanelに通知して再描画を行う
		fig.clear();
		setChanged();
		notifyObservers();
	}

	public void removeFigure() {
		//図形を保存しているfigリストのデータが1より多いときは1つ消す
		//リストの操作が終了したらViewPanelに通知して再描画を行う
		if (fig.size() < 1)
			return;
		fig.remove(fig.size() - 1);
		setChanged();
		notifyObservers();
	}

	public void Gridline() {
		//Gridlineメソッドが呼び出され、線が描画してあれば削除
		if (gridfig.size() > 0) {
			gridfig.clear();
		} else {
			//グリッド線が描画されていないときはグリッド線を描画
			int line = 3000 / 10;
			for (int i = 0; i < line; i++) {
				int linewidth = i * 10;
				F = new Line(linewidth, 0, linewidth, 3000, 1.0f, Color.GRAY);
				gridfig.add(F);
				F = new Line(0, linewidth, 3000, linewidth, 1.0f, Color.GRAY);
				gridfig.add(F);
			}
		}
		//グリッド線の設定が終わればViewPanelに通知してグリッド線の有無を適当する
		setChanged();
		notifyObservers();
	}

	private int GridPosition(int p) {
		//pに与えられた一の位を四捨五入する
		double p1 = (double) (p) / 10;
		p1 = Math.round(p1);
		return (int) (p1 * 10);

	}
}