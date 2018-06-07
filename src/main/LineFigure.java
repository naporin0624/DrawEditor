package main;

import java.awt.Color;
import java.awt.Graphics;

public class LineFigure extends Figure{
	public LineFigure(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, width, height);
	}
}