package main;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;

public class Figure_Item extends JMenuBar implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JMenuItem> menu_item;
	protected DrawModel model;
	public Figure_Item(DrawModel model) {
		this.model = model;
		menu_item = new ArrayList<JMenuItem>();
		menu_item.add(new JMenuItem("Square"));
		menu_item.add(new JMenuItem("Fill Square"));
		menu_item.add(new JMenuItem("Line"));
		menu_item.add(new JMenuItem("Circle"));
		menu_item.add(new JMenuItem("Fill Circle"));
		menu_item.add(new JMenuItem("Triangle"));
		menu_item.add(new JMenuItem("Fill Triangle"));
	}
		
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Square":
				model.setShape("square");
				break;
			case "Fill Square":
				model.setShape("SFull");
				break;
			case "Line":
				model.setShape("line");
				break;
			case "Circle":
				model.setShape("circle");
				break;
			case "Fill Circle":
				model.setShape("CFull");
				break;
			case "Triangle":
				model.setShape("poligen");
				break;
			case "Fill Triangle":
				model.setShape("PFull");
				break;
			default:
				model.setShape("square");
				break;
		}
	}
		
}
