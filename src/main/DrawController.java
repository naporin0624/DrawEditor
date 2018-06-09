package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawController implements MouseListener, MouseMotionListener {
	protected DrawModel model;
	protected int dragStartX, dragStartY;
	protected Figure drawingFigure;
	protected double angle;
	protected int flag = 0, releaseX, releaseY;

	public DrawController(DrawModel a) {
		model = a;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		dragStartX = e.getX();
		dragStartY = e.getY();
		model.createFigure(dragStartX, dragStartY);
		flag = 0;
	}

	public void mouseDragged(MouseEvent e) {
		model.reshapeFigure(dragStartX, dragStartY, e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e) {
		releaseX = e.getX();
		releaseY = e.getY();
		flag = 1;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		double centerX = (dragStartX + releaseX) / 2;
		double centerY = (dragStartY + releaseY) / 2;
		if (flag == 1) {
			angle = -Math.atan((e.getY() - centerY) / (e.getX() - centerX));
			/*int x1 = NewX((int)(centerX-dragStartX),(int)(centerY-dragStartY),angle);
			int y1 = NewY((int)(centerX-dragStartX),(int)(centerY-dragStartY),angle);
			int x2 = NewX((int)(releaseX-centerX),(int)(releaseY-centerY),angle);
			int y2 = NewY((int)(releaseX-centerX),(int)(releaseY-centerY),angle);*/
			//model.reshapeFigure((int)(centerX-x1),(int)(centerY-y1),(int)( x2+centerX),(int)( y2+centerY));
		}
	}
	/*
	int NewX(int x,int y,double angle) {
		return (int)(Math.cos(angle)*x-Math.sin(angle)*y);
	}
	int NewY(int x,int y,double angle) {
		return (int)(Math.sin(angle)*x+Math.cos(angle)*y);
	}
	*/

}