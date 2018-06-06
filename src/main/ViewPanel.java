package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ViewPanel extends JPanel implements Observer {
	protected DrawModel model;
	private Color backcolor = Color.white;
	private String drawshape = "square";

	public ViewPanel(DrawModel m, DrawController c) {
		this.setBackground(backcolor);
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
		model = m;
		model.addObserver(this);
	}

	public void BackPanelColor(Color c) {
		backcolor = c;
		this.setBackground(backcolor);
	}

	public void ChangeShape(String shape) {
		drawshape = shape;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Figure> fig = model.getFigures();
		Figure f;
		int [] size = new int[3];
		int i;
		
		switch(drawshape) {
		case "square":
			model.setsize("square", fig);
			break;
		case "circle":
			model.setsize("circle", fig);
			break;
		case "line":
			model.setsize("line", fig);
			break;
		default:
			break;
		}
		size = model.getsize();
		for(i=0;i<size[0];i++) {
			f = fig.get(i);
			f.draw(g);
		}
		for (i = 0; i < size[1]; i++) {
			f = fig.get(i);
			f.Circle(g);
		}
		for(i=0;i<size[i];i++) {
			f=fig.get(i);
			f.line(g);
		}
	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}