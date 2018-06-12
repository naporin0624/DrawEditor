package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircleFullFigure extends Figure {
	public CircleFullFigure(int x, int y, int w, int h, float size, Color c) {
		super(x, y, w, h, size, c);
	}
	//CircleFigureクラスの塗りつぶしバージョン
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		BasicStroke supersideStroke = new BasicStroke(size);
		g2d.setStroke(supersideStroke);
		g2d.fill(new Ellipse2D.Double(x,y,width,height));
	}

}
