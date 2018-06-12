package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class FileIO {
	private DrawModel model;
	private ArrayList<Figure> fig;
	private String file;
	BufferedImage writeImage;
	boolean result;

	public FileIO() {
		fig = new ArrayList<Figure>();
		result = false;
	}

	public void ImageOutput() {
		fig = model.getFigure();
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			writeImage = f;
		}
		try {
			result = ImageIO.write(writeImage, "png", new File(file));
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
	}

	public void getFileName(String string) {
		this.file = string;
	}

	public void saveAllFiguresAsImage(File targetFile) throws Exception {
		BufferedImage frame;
		BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		for (Figure figure : fig) {
			figure.draw(g2d);
		}
		ImageIO.write(image, "png", targetFile);

	}

}
