package main;

import java.awt.Color;
import java.awt.Graphics;

public class Figure {
	protected int x, y, width, height;
	protected float size = 1.0f;
	protected Color color;

	public Figure(int x, int y, int w, int h, float size, Color c) {
		this.x = x;
		this.y = y; // this.x, this.y はインスタンス変数を指します．
		width = w;//newx - x の座標
		height = h;//newy -y の座標
		// ローカル変数で同名の変数がある場合は，this
		color = c; // を付けると，インスタンス変数を指すことになります．
		this.size = size;
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//長方形、楕円図形用の座標形成メソッド
	public void reshape(int x1, int y1, int x2, int y2) {
		int newx = Math.min(x1, x2);
		int newy = Math.min(y1, y2);
		int neww = Math.abs(x1 - x2);
		int newh = Math.abs(y1 - y2);

		setLocation(newx, newy);
		setSize(neww, newh);
	}
	//直線、三角形用の座標取得メソッド.この2つの図形は始点と終点を引数とするので、長方形、楕円のような値の形成は必要としない.
	public void reshapeline(int x1, int y1, int x2, int y2) {
		x = x1;
		y = y1;
		width = x2;
		height = y2;
	}
	//Figureクラスのdrawメソッドをオーバーライドしている.ここではGraphics2Dを用いてFigureクラスで形成した座標データを基に長方形の図形データを生成している.
	public void draw(Graphics g) {
	}
}