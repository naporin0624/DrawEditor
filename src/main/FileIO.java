package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIO extends JPanel{
	private ArrayList<Figure> fig;
	private DrawModel model;
	private Graphics2D g2d;
	private JFileChooser fileDialog;
	private BufferedImage image;
	private ArrayList<String> open_ex_type;
	private String s;
	private String fileName;
	private File file;

	public FileIO(DrawModel model) {
		this.model = model;
		fileDialog = new JFileChooser();
		open_ex_type = new ArrayList<String>();
		open_ex_type.add("png");
		open_ex_type.add("jpg");
		open_ex_type.add("gif");
		open_ex_type.add("dtxt");
	}

	public void saveImage() {
		fig = model.getFigure();
		image = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
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

		try {
			s = fileName.substring(fileName.length() - 4, fileName.length());
		} catch (Exception IndexOutOfBoundsException) {
			fileName += ".png";
			s = "png";
		}

		file = new File(file.getParent(), fileName);

		try {
			ImageIO.write(image, s, file);
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

	private void setup_extension(JFileChooser file, ArrayList<String> ex_type) {
		for (int i = 0; i < ex_type.size(); i++) {
			String s = "*." + ex_type.get(i);
			file.setFileFilter(new FileNameExtensionFilter(s, ex_type.get(i)));
		}
	}
}
