package main;

import java.awt.Color;
import java.awt.Graphics;

public class Figure {
	protected int x, y, width, height, size;
	protected Color color;

	public Figure(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y; // this.x, this.y はインスタンス変数を指します．
		width = w;//newx - x の座標
		height = h;//newy -y の座標 
		// ローカル変数で同名の変数がある場合は，this
		color = c; // を付けると，インスタンス変数を指すことになります．
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
		System.out.print("w = "+w+" , ");
		System.out.println("h = "+h+" , ");
	}
	
	public void getSize(){
		
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.print("x = "+x+" , ");
		System.out.print("y = "+y+" , ");
	}

	public void reshape(int x1, int y1, int x2, int y2) {
		//int newx = Math.min(x1, x2);
		int newx = x1;
		//int newy = Math.min(y1, y2);
		int newy = y1;
		//int neww = Math.abs(x1 - x2);
		//int newh = Math.abs(y1 - y2);
		int neww = x2;
		int newh = y2;
		//size = (int)Math.sqrt(Math.pow(neww, 2)+Math.pow(newh, 2));
		setLocation(newx, newy);
		setSize(neww, newh);
		
	}
	
	

	public void draw(Graphics g) {
	}
	
	public void Circle(Graphics g) {
	}
	public void line(Graphics g) {
	}
}