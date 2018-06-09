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
import javax.swing.JPanel;


public class DrawFrame extends JFrame implements ActionListener{
DrawController cont;
DrawModel model;
ViewPanel view;
JPanel p;
JMenuBar Menu;
ColorPanel Cpanel;
Color c;

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
		JCheckBox Fullcheck = new JCheckBox("Full");
		JButton AllClear = new JButton("Clear"), ReDraw = new JButton("ReDraw"),lotate = new JButton("Lotate Figure");

		Menu.add(SMenu);Menu.add(CMenu);Menu.add(FMenu);Menu.add(Size);Menu.add(BGColor);
		
		JMenuItem newm = new JMenuItem("New Edit"), openm = new JMenuItem("Open"), savem = new JMenuItem("Save"),
				closem = new JMenuItem("Close");

		JMenuItem redm = new JMenuItem("Red"), bluem = new JMenuItem("Blue"), greenm = new JMenuItem("Green"),
				yellowm = new JMenuItem("Yellow"), otherm = new JMenuItem("Paint Color other");

		JMenuItem WB = new JMenuItem("White Back"),BlackBack = new JMenuItem("Black Back");

		JMenuItem squarem = new JMenuItem("Square"), linem = new JMenuItem("Line"), circlem = new JMenuItem("Circle"),
				Poligenm = new JMenuItem("Poligen");

		JMenuItem size1 = new JMenuItem("1"), size2 = new JMenuItem("2"), size3 = new JMenuItem("3"),
				size4 = new JMenuItem("4"), size5 = new JMenuItem("5"), othersize = new JMenuItem("other size");
		
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

		BGColor.add(WB);
		BGColor.add(BlackBack);
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
		p.add(lotate);

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

		WB.addActionListener(this);
		BlackBack.addActionListener(this);;

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
		lotate.addActionListener(this);
		
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
			model.setColor(Color.red);
		else if (e.getActionCommand() == "Blue")
			model.setColor(Color.blue);
		else if (e.getActionCommand() == "Green")
			model.setColor(Color.green);
		else if (e.getActionCommand() == "Yellow")
			model.setColor(Color.yellow);
		else if (e.getActionCommand() == "Paint Color other") {
			c = Cpanel.ColorPanelwindow();
			model.setColor(c);
		}

		// BGColoroの中身
		else if (e.getActionCommand() == "White Back")
			view.BackPanelColor(Color.white);
		else if (e.getActionCommand() == "Black Back")
			view.BackPanelColor(Color.black);

		else if (e.getActionCommand() == "Square") {
			model.setShape("square");
		} else if (e.getActionCommand() == "Line") {
			model.setShape("line");
		} else if (e.getActionCommand() == "Circle") {
			model.setShape("circle");
		} else if (e.getActionCommand() == "Poligen") {
			model.setShape("poligen");
		}

		else if (e.getActionCommand() == "Full")
			return;

		else if (e.getActionCommand() == "Clear")
			view.AllClear();

		else if (e.getActionCommand() == "ReDraw")
			view.removeFigure();
		else if(e.getActionCommand() == "Lotate Figure") {
		}
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