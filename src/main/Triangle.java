package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends Figure {

	public Triangle(int x, int y, int w, int h, float size, Color c) {
		super(x, y, w, h, size, c);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(color);
		BasicStroke superwideStroke = new BasicStroke(size);
		g2d.setStroke(superwideStroke);
		/*三角形の凸の部分をクリックした地点としてy方向に進んた分だけ三角形を縦に伸ばし,
		x方向に進んだ分だけ三角形を横に伸ばす*/
		int xPoint[] = { x, 2 * x - width, width };
		int yPoint[] = { y, height, height };
		g2d.draw(new Polygon(xPoint, yPoint, 3));
	}
}
