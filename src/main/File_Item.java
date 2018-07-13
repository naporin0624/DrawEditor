package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class File_Item extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	protected Dialog dialog;
	protected FileIO file;
	private ArrayList<JMenuItem> menu_item;
	public File_Item(DrawModel model) {
		file = new FileIO(model);
		dialog = new Dialog();
		menu_item = new ArrayList<JMenuItem>();
		menu_item.add(new JMenuItem("openImage"));
		menu_item.add(new JMenuItem("openData"));
		menu_item.add(new JMenuItem("saveImage"));
		menu_item.add(new JMenuItem("saveData"));
		menu_item.add(new JMenuItem("close"));
	}
	
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "saveImage":
				file.saveImage();
				break;
			case "saveData":
				file.saveData();
				break;
			case "close":
				System.exit(0);
				break;
			default:
				dialog.message("未実装", "waring");
				break;
		}
	}
	
}
