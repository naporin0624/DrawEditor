package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorPanel extends JFrame implements ActionListener{
	DrawModel model; 
	public ColorPanel() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b = new JButton("Red"),
				b1 = new JButton("Blue"),
				b2 = new JButton("Green"),
				b3 = new JButton("Yellow"),
				b4 = new JButton("White"),
				b5 = new JButton("Black"),
				b6 = new JButton("Add Color");
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()=="Red")model.ChangeColor(Color.red);
		if(e.getSource()=="Blue")model.ChangeColor(Color.blue);
		if(e.getSource()=="Green")model.ChangeColor(Color.green);
		if(e.getSource()=="Yellow")model.ChangeColor(Color.yellow);
		if(e.getSource()=="White")model.ChangeColor(Color.white);
		if(e.getSource()=="Black")model.ChangeColor(Color.black);
		if(e.getSource()=="Add Color")System.out.println("OKOK");
	}
}
