package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class DrawModel extends Observable {
	protected ArrayList<Figure> fig;
	private ArrayList<Figure> gridfig;
	protected Figure drawingFigure, F;
	protected Color currentColor = Color.red;
	private String s = "square";
	private float size = 1.0f;
	private int Gwidth = 10;

	public DrawModel() {
		fig = new ArrayList<Figure>();
		gridfig = new ArrayList<Figure>();
		drawingFigure = null; // null は定数．C言語のNULLと同じで，何も入っていないという意味．
	}
	//図形の色をセットするメソッド引数をColor cとしてcurrentColorにcを代入する.currentColorは図形生成クラスの引数として用いられる.
	public void setColor(Color c) {
		currentColor = c;
	}
	//図形の変更を受け取るメソッド、createFigureのそれぞれの図形生成クラスを選択する条件分岐に使われる.
	public void setShape(String s) {
		this.s = s;
	}
	//図形の太さの変更を受け取るメソッド、createFigureの引数であるsizeに使われる.
	public void setSize(float size) {
		this.size = size;
	}
	//getFigureは保存している図形データを返すメソッド
	public ArrayList<Figure> getFigure() {
		return fig;
	}
	//getGridはあらかじめ生成しておいたグリッド線のデータを返す.
	public ArrayList<Figure> getGrid() {
		return gridfig;
	}

	public Figure getFigure(int idx) {
		return fig.get(idx);
	}

	public void setGrid(int width) {
		Gwidth = width;
	}
	//選択した図形から実際に図形データを生成するメソッド.グリッド線が引かれているときに限りグリッド線に合わせる処理を行う.(ソースコード2を参照)マウスのクリック時の座標、ドラッグ時の座標を受け取り、各図形生成クラスがが正しく図形を描けるような値に変換する.
	public void createFigure(int x, int y) {
		if (gridfig.size() > 0) {
			x = GridPosition(x);
			y = GridPosition(y);
		}
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
		System.out.println(fig.size());
		drawingFigure = F;
		setChanged();
		notifyObservers();
	}

	public void Gridline() {
		;
		if (gridfig.size() > 0) {
			gridfig.clear();
		} else {
			int line = 500 / Gwidth;
			for (int i = 0; i < line; i++) {
				int linewidth = i * Gwidth;
				F = new LineFigure(linewidth, 0, linewidth, 500, 1.0f, Color.GRAY);
				gridfig.add(F);
				F = new LineFigure(0, linewidth, 500, linewidth, 1.0f, Color.GRAY);
				gridfig.add(F);
			}
		}
		drawingFigure = F;
		setChanged();
		notifyObservers();
	}
	//マウスの動きに合わせた図形の再生成を行う.各図形生成クラスごとに渡す値の扱いが異なるので条件分岐を行う.
	public void reshapeFigure(int x1, int y1, int x2, int y2) {
		if (gridfig.size() > 0) {
			x1 = GridPosition(x1);
			y1 = GridPosition(y1);
			x2 = GridPosition(x2);
			y2 = GridPosition(y2);
		}
		if (drawingFigure != null) {
			if (s == "line" || s == "poligen" || s == "PFull")
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