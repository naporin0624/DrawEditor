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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Figure> Sfig = model.getSquareF();
		ArrayList<Figure> Cfig = model.getCircleF();
		ArrayList<Figure> Lfig = model.getLineF();
		Figure f;
		for (int i = 0; i < Sfig.size(); i++) {
			f = Sfig.get(i);
			f.draw(g);
		}
		for (int i = 0; i < Cfig.size(); i++) {
			f = Cfig.get(i);
			f.Circle(g);
		}
		for (int i = 0; i < Lfig.size(); i++) {
			f = Lfig.get(i);
			f.line(g);
		}

	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}