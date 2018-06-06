package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DrawFrame extends JFrame implements ActionListener {
	DrawModel model;
	ViewPanel view;
	DrawController cont;
	ColorPanel Cpanel;
	Color c;

	public DrawFrame() {
		model = new DrawModel();
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);
		Cpanel = new ColorPanel();

		JMenuBar Menu = new JMenuBar();
		setJMenuBar(Menu);
		JMenu SMenu = new JMenu("File"), CMenu = new JMenu("Color"), FMenu = new JMenu("Figre"),
				Size = new JMenu("Size"), BGColor = new JMenu("BGColor");

		JPanel p = new JPanel();
		JCheckBox Fullcheck = new JCheckBox("Full");

		Menu.add(SMenu);
		Menu.add(CMenu);
		Menu.add(FMenu);
		Menu.add(Size);
		Menu.add(BGColor);
		JMenuItem newm = new JMenuItem("New Edit"), openm = new JMenuItem("Open"), savem = new JMenuItem("Save"),
				closem = new JMenuItem("Close");

		JMenuItem redm = new JMenuItem("Red"), bluem = new JMenuItem("Blue"), greenm = new JMenuItem("Green"),
				yellowm = new JMenuItem("Yellow"), otherm = new JMenuItem("Paint Color other");

		JMenuItem RB = new JMenuItem("Red Back"), BB = new JMenuItem("Blue Back"), GB = new JMenuItem("Green Back"),
				YB = new JMenuItem("Yellow Back"), WB = new JMenuItem("White Back"),
				BlackBack = new JMenuItem("Black Back"), otherB = new JMenuItem("BG Color other");

		JMenuItem squarem = new JMenuItem("Square"), linem = new JMenuItem("Line"), circlem = new JMenuItem("Circle");
		// メニューアイテムの追加
		SMenu.add(newm);
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

		BGColor.add(RB);
		BGColor.add(BB);
		BGColor.add(GB);
		BGColor.add(YB);
		BGColor.add(WB);
		BGColor.add(BlackBack);
		BGColor.add(otherB);
		RB.setBackground(Color.red);
		BB.setBackground(Color.blue);
		GB.setBackground(Color.green);
		YB.setBackground(Color.yellow);
		WB.setBackground(Color.white);
		BlackBack.setBackground(Color.black);
		BlackBack.setForeground(Color.white);

		FMenu.add(squarem);
		FMenu.add(linem);
		FMenu.add(circlem);

		p.add(Fullcheck);

		// イベントリスクの設定
		newm.addActionListener(this);
		openm.addActionListener(this);
		savem.addActionListener(this);
		closem.addActionListener(this);

		redm.addActionListener(this);
		bluem.addActionListener(this);
		greenm.addActionListener(this);
		yellowm.addActionListener(this);
		otherm.addActionListener(this);

		RB.addActionListener(this);
		BB.addActionListener(this);
		GB.addActionListener(this);
		YB.addActionListener(this);
		WB.addActionListener(this);
		BlackBack.addActionListener(this);
		otherB.addActionListener(this);

		squarem.addActionListener(this);
		linem.addActionListener(this);
		circlem.addActionListener(this);

		Fullcheck.addActionListener(this);

		// 以下描画
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setSize(500, 500);
		this.add(p, BorderLayout.NORTH);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String argv[]) {
		new DrawFrame();
	}

	public void actionPerformed(ActionEvent e) {
		// Fileの中身
		if (e.getActionCommand() == "New Edit")
			System.out.println("New Edit");
		else if (e.getActionCommand() == "Open")
			System.out.println("Open");
		else if (e.getActionCommand() == "Save")
			System.out.println("Save");
		else if (e.getActionCommand() == "Close")
			System.exit(0);

		// Colorの中身
		else if (e.getActionCommand() == "Red")
			model.ChangeColor(Color.red);
		else if (e.getActionCommand() == "Blue")
			model.ChangeColor(Color.blue);
		else if (e.getActionCommand() == "Green")
			model.ChangeColor(Color.green);
		else if (e.getActionCommand() == "Yellow")
			model.ChangeColor(Color.yellow);
		else if (e.getActionCommand() == "Paint Color other") {
			c = Cpanel.ColorPanelwindow();
			model.ChangeColor(c);
		}

		// BGColoroの中身
		else if (e.getActionCommand() == "Red Back")
			view.BackPanelColor(Color.red);
		else if (e.getActionCommand() == "Blue Back")
			view.BackPanelColor(Color.blue);
		else if (e.getActionCommand() == "Green Back")
			view.BackPanelColor(Color.green);
		else if (e.getActionCommand() == "Yellow Back")
			view.BackPanelColor(Color.yellow);
		else if (e.getActionCommand() == "White Back")
			view.BackPanelColor(Color.white);
		else if (e.getActionCommand() == "Black Back")
			view.BackPanelColor(Color.black);
		else if (e.getActionCommand() == "BG Color other") {
			c = Cpanel.ColorPanelwindow();
			view.BackPanelColor(c);
		}

		else if (e.getActionCommand() == "Square") {
			model.ChangeShape("square");
		} else if (e.getActionCommand() == "Line") {
			model.ChangeShape("line");
		} else if (e.getActionCommand() == "Circle") {
			model.ChangeShape("circle");
		}
	}
}