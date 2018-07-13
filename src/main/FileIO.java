package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileIO extends JPanel {
	private ArrayList<Figure> fig;
	private DrawModel model;
	private Graphics2D g2d;
	private JFileChooser fileDialog;
	private BufferedImage image;

	public FileIO(DrawModel model) {
		this.model = model;
		fileDialog = new JFileChooser();
	}
	
	public void saveImage() {
		fig = model.getFigure();
		image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g2d);
		}
		g2d.dispose();

		int state = fileDialog.showSaveDialog(this);
		if (state != JFileChooser.APPROVE_OPTION)
			return;
		File file = fileDialog.getSelectedFile();
		String fileName = file.getName();
		if (!fileName.endsWith(".png"))
			file = new File(file.getParent(), fileName + ".png");

		try { ImageIO.write(image, "png", file); }
		catch (Exception e) { e.printStackTrace(); }
	}
}
