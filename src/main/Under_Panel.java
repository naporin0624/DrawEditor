package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class Under_Panel extends JPanel implements ActionListener{
	
	protected ViewPanel view;
	protected DrawModel model;
	
	private ArrayList<JButton> button;
	private ArrayList<JCheckBox> check;
	
	public Under_Panel(DrawModel model,ViewPanel view) {
		this.view = view;
		this.model = model;
		button = new ArrayList<JButton>();
		check = new ArrayList<JCheckBox>();
		button.add(new JButton("Clear"));
		button.add(new JButton("ReDraw"));
		check.add(new JCheckBox("Grid"));
		Add_Button(button);
		Add_Check(check);
	}
	
	public void Add_Button(ArrayList<JButton> button) {
		for(int i=0;i<button.size();i++) {
			this.add(button.get(i));
			button.get(i).addActionListener(this);
		}
	}
	public void Add_Check(ArrayList<JCheckBox> check) {
		for(int i=0;i<check.size();i++) {
			this.add(check.get(i));
			check.get(i).addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Clear":
				view.AllClear();
				break;
			case "ReDraw":
				view.removeFigure();
				break;
			case "Grid":
				model.Gridline();
				break;
			default:
				break;
		}
	}
}
