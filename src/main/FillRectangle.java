package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class FillRectangle extends Figure {

	public FillRectangle(int x, int y, int w, int h, float size, Color c) {
		super(x, y, w, h, size, c);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		BasicStroke superwideStroke = new BasicStroke(size);
		g2d.setStroke(superwideStroke);
		g2d.fill(new Rectangle2D.Double(x, y, width, height));
	}
}
