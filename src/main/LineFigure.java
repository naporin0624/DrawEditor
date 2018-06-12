package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineFigure extends Figure {
	public LineFigure(int x, int y, int w, int h, float size, Color c) {
		super(x, y, w, h, size, c);
	}
	//Figureクラスのdrawメソッドをオーバーライドしている.ここではGraphics2Dを用いてFigureクラスで形成した座標データを基に直線の図形データを生成している.
	public void draw(Graphics g) {
		Graphics2D g2d =(Graphics2D)g;
		g2d.setColor(color);
		BasicStroke superwideStroke = new BasicStroke(size);
	    g2d.setStroke(superwideStroke);
		g2d.draw(new Line2D.Double(x, y, width, height));
		
	}
}
