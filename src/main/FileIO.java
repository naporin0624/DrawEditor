package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileIO extends JPanel{
	private ArrayList<Figure> fig;
	private DrawModel model;
	private Graphics2D g2d;
	private JFileChooser fileDialog;
	private BufferedImage image;
	private String s;
	private String fileName;
	private File file;
	private BufferedImage bufferedImage;
	protected ViewPanel view;

	public FileIO(DrawModel model,ViewPanel view) {
		this.model = model;
		this.view = view;
		fileDialog = new JFileChooser();
	}

	public BufferedImage openImage() {
		int state = fileDialog.showOpenDialog(this);
		if (state != JFileChooser.APPROVE_OPTION)
			return null;
		file = fileDialog.getSelectedFile();

		fileName = file.getName();
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}

	public void saveImage() {
		fig = model.getFigure();
		Dimension d = view.get_window_size();
		image = new BufferedImage(d.width,d.height,BufferedImage.TYPE_3BYTE_BGR);
		g2d = image.createGraphics();
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

		file = fileDialog.getSelectedFile();

		fileName = file.getName();

		

		if (!fileName.endsWith(".png"))
			file = new File(file.getParent(), fileName + ".png");
		
		try {
			ImageIO.write(image, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveData() {
		s = "";
		fig = model.getFigure();
		for (int i = 0; i < fig.size(); i++) {
			s += String.valueOf(fig.get(i)) + "\n";
		}

		int state = fileDialog.showSaveDialog(this);
		if (state != JFileChooser.APPROVE_OPTION)
			return;

		file = fileDialog.getSelectedFile();

		fileName = file.getName();

		if (!fileName.endsWith(".dtxt"))
			file = new File(file.getParent(), fileName + ".dtxt");

		try {
			FileWriter filewriter = new FileWriter(file);
			filewriter.write(s);
			filewriter.close();
			System.out.println(s);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
