package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ViewPanel extends JPanel implements Observer {
	protected DrawModel model;
	private Color backcolor = Color.white;
	private ArrayList<Figure> fig,gridfig;
	private BufferedImage img;

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
		fig = model.getFigure();
		gridfig = model.getGrid();
		for (int i = 0; i < gridfig.size(); i++) {
			Figure f = gridfig.get(i);
			f.draw(g);
		}
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g);
		}
	}
	/*
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public void setimg(BufferedImage img) {
		this.img = img;
	}
*/

	public void update(Observable o, Object arg) {
		repaint();
	}
}