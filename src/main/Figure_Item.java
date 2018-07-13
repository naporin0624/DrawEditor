package main;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Figure_Item extends JMenuBar implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JMenuItem> menu_item;
	private String R= "Rectangle", FR = "FillRectangle",L = "Line", C = "Circle", FC="FillCircle", T = "Triangle", FT = "FillTriangle";
	protected DrawModel model;
	public Figure_Item(DrawModel model) {
		this.model = model;
		menu_item = new ArrayList<JMenuItem>();
		menu_item.add(new JMenuItem(R));
		menu_item.add(new JMenuItem(FR));
		menu_item.add(new JMenuItem(L));
		menu_item.add(new JMenuItem(C));
		menu_item.add(new JMenuItem(FC));
		menu_item.add(new JMenuItem(T));
		menu_item.add(new JMenuItem(FT));
	}
		
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Rectangle":
				model.setShape(R);
				break;
			case "FillRectangle":
				model.setShape(FR);
				break;
			case "Line":
				model.setShape(L);
				break;
			case "Circle":
				model.setShape(C);
				break;
			case "FillCircle":
				model.setShape(FC);
				break;
			case "Triangle":
				model.setShape(T);
				break;
			case "FillTriangle":
				model.setShape(FT);
				break;
			default:
				model.setShape(R);
				break;
		}
	}
		
}
