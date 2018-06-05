package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorPanel extends JFrame implements ActionListener {
	DrawModel model;
	JButton b = new JButton("Red"), b1 = new JButton("Blue"), b2 = new JButton("Green"), b3 = new JButton("Yellow"),
			b4 = new JButton("White"), b5 = new JButton("Black"), b6 = new JButton("Add");

	public ColorPanel(DrawModel model) {
		this.model = model;
		this.setSize(300, 300);
		this.setLayout(new GridLayout(3, 2));

		b.setBackground(Color.red);
		b1.setBackground(Color.blue);
		b2.setBackground(Color.green);
		b3.setBackground(Color.yellow);
		b4.setBackground(Color.white);
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		
		this.add(b);
		this.add(b1);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		
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
		if (e.getSource() == b)
			model.ChangeColor(Color.red);
		else if (e.getSource() == b1)
			model.ChangeColor(Color.blue);
		else if (e.getSource() == b2)
			model.ChangeColor(Color.green);
		else if (e.getSource() == b3)
			model.ChangeColor(Color.yellow);
		else if (e.getSource() == b4)
			model.ChangeColor(Color.white);
		else if (e.getSource() == b5)
			model.ChangeColor(Color.black);
		else if (e.getSource() == b6)
			System.out.println("OKOK");
	}
}
