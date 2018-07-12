package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileIO extends JPanel {
	private ArrayList<Figure> fig;
	private DrawModel model;
	private Graphics2D g2d;

	public BufferedImage load() {
		//fig = model.getFigure();
		BufferedImage Fig_Image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_BGR);
		g2d = Fig_Image.createGraphics();
		//paintComponent(g2d);
		g2d.setBackground(Color.white);
		/*for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g2d);
		}*/
		//g2d.dispose();
		return Fig_Image;
	}

	public void saveImage()
	{
		JFileChooser fileDialog = new JFileChooser();
		int state = fileDialog.showSaveDialog(this);
		if (state != JFileChooser.APPROVE_OPTION)
			return;
		/*
		File file = fileDialog.getSelectedFile();
		String fileName = file.getName();
		if (!fileName.endsWith(".png"))
			file = new File(file.getParent(), fileName + ".png");

		try { ImageIO.write(image, "png", file); }
		catch (Exception e) { e.printStackTrace(); }
		*/
	}
}
