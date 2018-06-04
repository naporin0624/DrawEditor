package main;
import java.awt.Color;

import javax.swing.JFrame;

public class DrawFrame extends JFrame {
	  DrawModel model;
	  ViewPanel view;
	  DrawController cont;
	   public DrawFrame(){
	      model=new DrawModel();
	      cont =new DrawController(model);
	      view=new ViewPanel(model,cont);
	      this.setBackground(Color.black);
	      this.setTitle("Draw Editor");
	      this.setSize(500,500);
	      this.add(view);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setVisible(true);
	    }
	    public static void main(String argv[]) {
	      new DrawFrame();
	   }
	}