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
		System.out.println(backcolor);
	//	repaint();
		this.setBackground(backcolor);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Figure> fig = model.getFigures();
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g);
		}
	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}