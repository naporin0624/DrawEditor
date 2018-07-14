package main;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class All_Frame_Item extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	protected DrawModel model;
	protected ViewPanel view;
	protected File_Item file;
	protected Color_Item color;
	protected Figure_Item figure;
	protected Line_width_Item line;
	protected BGColor_Item BGcolor;
	private ArrayList<JMenu> Menu;
	
	public All_Frame_Item(DrawModel model,ViewPanel view) {
		this.model = model;
		this.view = view;
		file = new File_Item(model, view);
		color = new Color_Item(model);
		figure = new Figure_Item(model);
		line = new Line_width_Item(model);
		BGcolor = new BGColor_Item(view);
		
		Menu = new ArrayList<JMenu>();
		
		//作りたいメニューリストに格納
		Menu.add(new JMenu("File"));
		Menu.add(new JMenu("Color"));
		Menu.add(new JMenu("Figure"));
		Menu.add(new JMenu("Line_width"));
		Menu.add(new JMenu("BGColor"));
		//メニューバーをドローエディタに追加
		Add_Bar(Menu);
		
		//各メニューの内容をリストに格納された順番に記述
		Add_Item(file.Add_Item(),0);
		Add_Item(color.Add_Item(),1);
		Add_Item(figure.Add_Item(),2);
		Add_Item(line.Add_Item(),3);
		Add_Item(BGcolor.Add_Item(),4);
		
	}
	
	public void Add_Bar(ArrayList<JMenu> menu) {
		for(int i=0;i<menu.size();i++) this.add(menu.get(i));
	}
	
	public void Add_Item(ArrayList<JMenuItem> item,int num) {
		for(int i=0;i<item.size();i++) Menu.get(num).add(item.get(i));
	}
}
