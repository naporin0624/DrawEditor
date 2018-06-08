package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DrawMenu extends JFrame implements ActionListener {
	protected ColorPanel Cpanel;
	protected Color c;
	protected DrawModel model;
	protected ViewPanel view;
	protected JMenuBar Menu;
	protected JPanel p;

	public DrawMenu() {
		Cpanel = new ColorPanel();
		Menu = new JMenuBar();
		setJMenuBar(Menu);
		JMenu SMenu = new JMenu("File"), CMenu = new JMenu("Color"), FMenu = new JMenu("Figre"),
				Size = new JMenu("Size"), BGColor = new JMenu("BGColor");

		p = new JPanel();
		JCheckBox Fullcheck = new JCheckBox("Full");
		JButton AllClear = new JButton("Clear"), ReDraw = new JButton("ReDraw");

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

		JMenuItem squarem = new JMenuItem("Square"), linem = new JMenuItem("Line"), circlem = new JMenuItem("Circle"),
				Poligenm = new JMenuItem("Poligen");

		JMenuItem size1 = new JMenuItem("1"), size2 = new JMenuItem("2"), size3 = new JMenuItem("3"),
				size4 = new JMenuItem("4"), size5 = new JMenuItem("5"), othersize = new JMenuItem("other size");
		;
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

		Size.add(size1);
		Size.add(size2);
		Size.add(size3);
		Size.add(size4);
		Size.add(size5);
		Size.add(othersize);

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
		FMenu.add(Poligenm);

		p.add(Fullcheck);
		p.add(AllClear);
		p.add(ReDraw);

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
		Poligenm.addActionListener(this);
		
		size1.addActionListener(this);
		size2.addActionListener(this);
		size3.addActionListener(this);
		size4.addActionListener(this);
		size5.addActionListener(this);

		Fullcheck.addActionListener(this);
		AllClear.addActionListener(this);
		ReDraw.addActionListener(this);
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
		} else if (e.getActionCommand() == "Poligen") {
			model.ChangeShape("poligen");
		}

		else if (e.getActionCommand() == "Full")
			return;

		else if (e.getActionCommand() == "Clear")
			view.AllClear();

		else if (e.getActionCommand() == "ReDraw")
			view.removeFigure();
		
		else if(e.getActionCommand() =="1")
			model.setSize(1.0f);
		else if(e.getActionCommand()=="2")
			model.setSize(2.0f);
		else if(e.getActionCommand()=="3")
			model.setSize(3.0f);
		else if(e.getActionCommand()=="4")
			model.setSize(4.0f);
		else if(e.getActionCommand()=="5")
			model.setSize(5.0f);

	}
}
