package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ViewPanel extends JPanel implements Observer {
	protected DrawModel model;
	private Color backcolor = Color.white;
	private ArrayList<Figure> fig;

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
		Graphics2D g2d = (Graphics2D) g;
		fig = model.getFigure();
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			int FS[] = f.getSize();
			/*AffineTransform af = new AffineTransform();
			af.setToRotation(45 * Math.PI/180, (int)(FS[0]+FS[2]/2),(int)(FS[1]+FS[3]/2));
			g2d.setTransform(af);*/
			f.draw(g);
		}
	}

	public void AllClear() {
		fig.clear();
		repaint();
	}

	public void removeFigure() {
		if (fig.size() < 1)
			return;
		fig.remove(fig.size() - 1);
		repaint();
	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}