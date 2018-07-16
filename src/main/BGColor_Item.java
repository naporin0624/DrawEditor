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
	protected ColorPanel CPanel;
	private ArrayList<JMenuItem> menu_item;
	public BGColor_Item(ViewPanel view) {
		this.view = view;
		dialog = new Dialog();
		CPanel = new ColorPanel();
		menu_item = new ArrayList<JMenuItem>();
		
		//メニュー内容
		menu_item.add(new JMenuItem("white"));
		menu_item.add(new JMenuItem("black"));
		menu_item.add(new JMenuItem("Ohter Color"));
	}
	
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//メニュー内容をクリックしたときの動作
		switch(e.getActionCommand()) {
			case "white":
				view.BackPanelColor(Color.white);
				break;
			case "black":
				view.BackPanelColor(Color.black);
				break;
			case "Ohter Color":
				Color c = CPanel.ColorPanelwindow();
				view.BackPanelColor(c);
				break;
			default:
				dialog.message("想定外の操作", "waring");
				break;
		}
	}
	
}
