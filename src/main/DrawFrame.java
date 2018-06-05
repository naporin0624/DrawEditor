package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DrawFrame extends JFrame implements ActionListener {
	DrawModel model;
	ViewPanel view;
	DrawController cont;

	public DrawFrame() {
		model = new DrawModel();
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);

		JMenuBar Menu = new JMenuBar();
		setJMenuBar(Menu);
		JMenu SMenu = new JMenu("File"), CMenu = new JMenu("Color"), FMenu = new JMenu("Figre"),
				Size = new JMenu("Size");

		Menu.add(SMenu);
		Menu.add(CMenu);
		Menu.add(FMenu);
		Menu.add(Size);
		JMenuItem newm = new JMenuItem("New Edit"), openm = new JMenuItem("Open"), savem = new JMenuItem("Save"),
				closem = new JMenuItem("Close");
		JMenuItem redm = new JMenuItem("Red"), bluem = new JMenuItem("Blue"), greenm = new JMenuItem("Green"),
				yellowm = new JMenuItem("Yellow"), otherm = new JMenuItem("other"),popupm = new JMenuItem("ColorPanel-PopUp");
		// メニューアイテムの追加
		SMenu.add(newm);
		SMenu.add(openm);
		SMenu.add(savem);
		SMenu.add(closem);
		
		CMenu.add(popupm);
		CMenu.add(redm);
		CMenu.add(bluem);
		CMenu.add(greenm);
		CMenu.add(yellowm);
		CMenu.add(otherm);
		redm.setBackground(Color.red);
		bluem.setBackground(Color.blue);
		greenm.setBackground(Color.green);
		yellowm.setBackground(Color.yellow);

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
		popupm.addActionListener(this);

		// 以下描画
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setSize(500, 500);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String argv[]) {
		new DrawFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "New Edit")
			System.out.println("New Edit");
		else if (e.getActionCommand() == "Open")
			System.out.println("Open");
		else if (e.getActionCommand() == "Save")
			System.out.println("Save");
		else if (e.getActionCommand() == "Close")
			System.exit(0);
		else if (e.getActionCommand() == "Red")
			model.ChangeColor(Color.red);
		else if(e.getActionCommand() == "Blue")
			model.ChangeColor(Color.blue);
		else if(e.getActionCommand()=="Green")
			model.ChangeColor(Color.green);
		else if(e.getActionCommand()=="Yellow")
			model.ChangeColor(Color.yellow);
		else if(e.getActionCommand()=="ColorPanel-PopUp")
			new ColorPanel(model);

	}
}