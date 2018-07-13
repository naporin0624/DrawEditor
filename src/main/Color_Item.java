package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Color_Item extends JMenuBar implements ActionListener{
	private ArrayList<JMenuItem> menu_item;
	private ColorPanel Cpanel;
	protected DrawModel model;
	
	public Color_Item(DrawModel model) {
		this.model = model;
		Cpanel = new ColorPanel();
		menu_item = new ArrayList<JMenuItem>();
		menu_item.add(new JMenuItem("Red"));
		menu_item.add(new JMenuItem("Blue"));
		menu_item.add(new JMenuItem("Yellow"));
		menu_item.add(new JMenuItem("Green"));
		menu_item.add(new JMenuItem("Other Color"));
	}
	
	public ArrayList<JMenuItem> Add_Item(){
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Red":
				model.setColor(Color.red);
				break;
			case "Blue":
				model.setColor(Color.blue);
				break;
			case "Yellow":
				model.setColor(Color.yellow);
				break;
			case "Green":
				model.setColor(Color.green);
				break;
			case "Other Color":
				Color c = Cpanel.ColorPanelwindow();
				model.setColor(c);
				break;
			default:
				model.setColor(Color.red);
				break;
		}
		
	}
	
}
