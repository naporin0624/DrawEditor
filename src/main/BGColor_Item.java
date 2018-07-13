package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BGColor_Item extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	protected Dialog dialog;
	protected ViewPanel view;
	private ArrayList<JMenuItem> menu_item;
	public BGColor_Item(ViewPanel view) {
		this.view = view;
		dialog = new Dialog();
		menu_item = new ArrayList<JMenuItem>();
		menu_item.add(new JMenuItem("white"));
		menu_item.add(new JMenuItem("black"));
	}
	
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "white":
				view.BackPanelColor(Color.white);
				break;
			case "black":
				view.BackPanelColor(Color.black);
				break;
			default:
				dialog.message("想定外の操作", "waring");
				break;
		}
	}
	
}
