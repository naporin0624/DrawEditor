package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawFrame extends JFrame implements ActionListener {
	DrawController cont;
	DrawModel model;
	ViewPanel view;
	JPanel p;
	JMenuBar Menu;
	ColorPanel Cpanel;
	Color c;
	FileIO Image_file;

	public DrawFrame() {
		model = new DrawModel();
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);
		Cpanel = new ColorPanel();
		// 以下描画
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setSize(500, 500);

		Menu = new JMenuBar();
		setJMenuBar(Menu);
		JMenu SMenu = new JMenu("File"), CMenu = new JMenu("Color"), FMenu = new JMenu("Figre"),
				Size = new JMenu("Size"), BGColor = new JMenu("BGColor");

		p = new JPanel();
		JButton AllClear = new JButton("Clear"), ReDraw = new JButton("ReDraw");
		JCheckBox Grid = new JCheckBox("Grid");
		Menu.add(SMenu);
		Menu.add(CMenu);
		Menu.add(FMenu);
		Menu.add(Size);
		Menu.add(BGColor);

		JMenuItem openm = new JMenuItem("Open"), savem = new JMenuItem("Save"),
				closem = new JMenuItem("Close");

		JMenuItem redm = new JMenuItem("Red"), bluem = new JMenuItem("Blue"), greenm = new JMenuItem("Green"),
				yellowm = new JMenuItem("Yellow"), otherm = new JMenuItem("Paint Color other");

		JMenuItem WB = new JMenuItem("White Back"), BlackBack = new JMenuItem("Black Back");

		JMenuItem squarem = new JMenuItem("Square"), linem = new JMenuItem("Line"), circlem = new JMenuItem("Circle"),
				Poligenm = new JMenuItem("Poligen"), squareFull = new JMenuItem("SquareFull"),
				circleFull = new JMenuItem("CircleFull"),
				PoligenFull = new JMenuItem("PoligenFull");

		JMenuItem size1 = new JMenuItem("1"), size2 = new JMenuItem("2"), size3 = new JMenuItem("3"),
				size4 = new JMenuItem("4"), size5 = new JMenuItem("5"), othersize = new JMenuItem("OtherSize");

		// メニューアイテムの追加
		SMenu.add(openm);
		SMenu.add(savem);
		SMenu.add(closem);

		CMenu.add(redm);
		CMenu.add(bluem);
		CMenu.add(greenm);
		CMenu.add(yellowm);
		CMenu.add(otherm);
		redm.setBackground(Color.red);
		bluem.setBackground(Color.blue);
		greenm.setBackground(Color.green);
		yellowm.setBackground(Color.yellow);

		Size.add(size1);
		Size.add(size2);
		Size.add(size3);
		Size.add(size4);
		Size.add(size5);
		Size.add(othersize);

		BGColor.add(WB);
		BGColor.add(BlackBack);
		WB.setBackground(Color.white);
		BlackBack.setBackground(Color.black);
		BlackBack.setForeground(Color.white);

		FMenu.add(squarem);
		FMenu.add(squareFull);
		FMenu.add(linem);
		FMenu.add(circlem);
		FMenu.add(circleFull);
		FMenu.add(Poligenm);
		FMenu.add(PoligenFull);

		p.add(AllClear);
		p.add(ReDraw);
		p.add(Grid);

		// イベントリスクの設定
		openm.addActionListener(this);
		savem.addActionListener(this);
		closem.addActionListener(this);

		redm.addActionListener(this);
		bluem.addActionListener(this);
		greenm.addActionListener(this);
		yellowm.addActionListener(this);
		otherm.addActionListener(this);

		WB.addActionListener(this);
		BlackBack.addActionListener(this);

		squarem.addActionListener(this);
		squareFull.addActionListener(this);
		linem.addActionListener(this);
		circlem.addActionListener(this);
		circleFull.addActionListener(this);
		Poligenm.addActionListener(this);
		PoligenFull.addActionListener(this);

		size1.addActionListener(this);
		size2.addActionListener(this);
		size3.addActionListener(this);
		size4.addActionListener(this);
		size5.addActionListener(this);
		othersize.addActionListener(this);

		AllClear.addActionListener(this);
		ReDraw.addActionListener(this);
		Grid.addActionListener(this);

		this.add(p, BorderLayout.SOUTH);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String argv[]) {
		new DrawFrame();
	}

	public void actionPerformed(ActionEvent e) {
		// Fileの中身
		switch(e.getActionCommand()) {
			case "Open":
				break;
			case "Save":
				BufferedImage Fig_Image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = Fig_Image.createGraphics();
				ArrayList<Figure> fig = model.getFigure();
				for (int i = 0; i < fig.size(); i++) {
					Figure f = fig.get(i);
					f.draw(g2d);
				}
				g2d.dispose();
				JFileChooser fileDialog = new JFileChooser();
				int state = fileDialog.showSaveDialog(this);
				if (state != JFileChooser.APPROVE_OPTION)
					return;
				File file = fileDialog.getSelectedFile();
				String fileName = file.getName();
				if (!fileName.endsWith(".png"))
					file = new File(file.getParent(), fileName + ".jpg");

				try { ImageIO.write(Fig_Image, "jpg", file); }
				catch (Exception e1) { e1.printStackTrace(); }

				break;
			case "Close":
				System.exit(0);
				break;


			case "Red":
				model.setColor(Color.red);
				break;
			case "Blue":
				model.setColor(Color.blue);
				break;
			case "Green":
				model.setColor(Color.green);
				break;
			case "Yellow":
				model.setColor(Color.yellow);
				break;
			case "Paint Color other":
				c = Cpanel.ColorPanelwindow();
				model.setColor(c);
				break;


			case "White Back":
				view.BackPanelColor(Color.white);
				break;
			case "Black Back":
				view.BackPanelColor(Color.black);
				break;


			case "Square":
				model.setShape("square");
				break;
			case "SuquareFull":
				model.setShape("SFull");
				break;
			case "Line":
				model.setShape("line");
				break;
			case "Circle":
				model.setShape("circle");
				break;
			case "Poligen":
				model.setShape("CFull");
				break;
			case "PoligenFull":
				model.setShape("PFull");
				break;


			case "Clear":
				view.AllClear();
				break;
			case "ReDraw":
				view.removeFigure();
				break;
			case "Grid":
				model.Gridline();
				break;


			case "1":
				model.setSize(1.0f);
				break;
			case "2":
				model.setSize(2.0f);
				break;
			case "3":
				model.setSize(3.0f);
				break;
			case "4":
				model.setSize(4.0f);
				break;
			case "5":
				model.setSize(5.0f);
				break;
			case "OtherSize":
				JFrame frame = new JFrame();
				String value = JOptionPane.showInputDialog(frame,"Input Draw Size");
				float size = Float.parseFloat(value);
				if(size<=0 || value==null) {
					break;
				}
				model.setSize(Float.parseFloat(value));
				break;

		}
	}

}