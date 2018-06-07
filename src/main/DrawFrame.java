package main;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


public class DrawFrame extends DrawMenu{
DrawController cont;
	public DrawFrame() {
		model = new DrawModel();
		cont = new DrawController(model);
		view = new ViewPanel(model, cont);
		// 以下描画
		this.setBackground(Color.black);
		this.setTitle("Draw Editor");
		this.setSize(500, 500);
		this.add(p, BorderLayout.SOUTH);
		this.add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String argv[]) {
		new DrawFrame();
	}

}