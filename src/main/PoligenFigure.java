package main;

import java.awt.Color;
import java.awt.Graphics;

public class PoligenFigure extends Figure{

	public PoligenFigure(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	public void draw(Graphics g) {
		g.setColor(color);
		int xPoint[] = {x,x+width,x+width};
		int yPoint[] = {y,y+height,y+height};
		 g.drawPolygon(xPoint, yPoint, 3);
	}
}
