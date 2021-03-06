package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	Operation Op;

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

		//配置など
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
		if (e.getActionCommand() == "Open") {
		}

		else if (e.getActionCommand() == "Save") {
		}
		else if (e.getActionCommand() == "Close")
			System.exit(0);

		// Colorの中身
		else if (e.getActionCommand() == "Red")
			Op.setColor(Color.red);
		else if (e.getActionCommand() == "Blue")
			Op.setColor(Color.blue);
		else if (e.getActionCommand() == "Green")
			Op.setColor(Color.green);
		else if (e.getActionCommand() == "Yellow")
			Op.setColor(Color.yellow);
		else if (e.getActionCommand() == "Paint Color other") {
			c = Cpanel.ColorPanelwindow();
			Op.setColor(c);
		}

		// BGColoroの中身
		else if (e.getActionCommand() == "White Back")
			view.BackPanelColor(Color.white);
		else if (e.getActionCommand() == "Black Back")
			view.BackPanelColor(Color.black);

		else if (e.getActionCommand() == "Square")
			Op.setShape("square");
		else if (e.getActionCommand() == "SquareFull")
			Op.setShape("SFull");
		else if (e.getActionCommand() == "Line")
			Op.setShape("line");
		else if (e.getActionCommand() == "Circle")
			Op.setShape("circle");
		else if (e.getActionCommand() == "CircleFull")
			Op.setShape("CFull");
		else if (e.getActionCommand() == "Poligen")
			Op.setShape("poligen");
		else if (e.getActionCommand() == "PoligenFull")
			Op.setShape("PFull");

		else if (e.getActionCommand() == "Clear")
			view.AllClear();

		else if (e.getActionCommand() == "ReDraw")
			view.removeFigure();

		else if (e.getActionCommand() == "Grid")
			model.Gridline();

		else if (e.getActionCommand() == "1")
			Op.setSize(1.0f);
		else if (e.getActionCommand() == "2")
			Op.setSize(2.0f);
		else if (e.getActionCommand() == "3")
			Op.setSize(3.0f);
		else if (e.getActionCommand() == "4")
			Op.setSize(4.0f);
		else if (e.getActionCommand() == "5")
			Op.setSize(5.0f);
		else if (e.getActionCommand() == "OtherSize") {
			JFrame frame = new JFrame();
			String value = JOptionPane.showInputDialog(frame, "Input Draw Size");
			float size = Float.parseFloat(value);
			if (size <= 0 || value == null) {
				return;
			}
			Op.setSize(Float.parseFloat(value));
		}

	}

}