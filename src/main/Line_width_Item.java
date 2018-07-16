package main;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Line_width_Item extends JMenuBar implements ActionListener{
	private static final long serialVersionUID = 1L;
	private ArrayList<JMenuItem> menu_item;
	protected DrawModel model;
	protected Dialog dialog;
	public Line_width_Item(DrawModel model) {
		this.model = model;
		dialog = new Dialog();
		menu_item = new ArrayList<JMenuItem>();
		
		//メニュー内容
		menu_item.add(new JMenuItem("1"));
		menu_item.add(new JMenuItem("2"));
		menu_item.add(new JMenuItem("3"));
		menu_item.add(new JMenuItem("4"));
		menu_item.add(new JMenuItem("5"));
		menu_item.add(new JMenuItem("Other Line Width"));
	}
		
	//メニュー内容を追加するメソッド
	public ArrayList<JMenuItem> Add_Item() {
		for(int i=0;i<menu_item.size();i++) menu_item.get(i).addActionListener(this);
		return menu_item;
	}
	
	
	//メニュークリック時の動作を設定
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "1":
				model.setLine_Width(1.0f);
				break;
			case "2":
				model.setLine_Width(2.0f);
				break;
			case "3":
				model.setLine_Width(3.0f);
				break;
			case "4":
				model.setLine_Width(4.0f);
				break;
			case "5":
				model.setLine_Width(5.0f);
				break;
			case "Other Line Width":
				float num=1;
				String s = dialog.input("図形の太さを入力");
				if(s=="e")return;
				try {
					num = Float.parseFloat(s);
				}catch(NumberFormatException ex){
					dialog.message("数値を入力!","error");
				}
				if(num<1) {
					dialog.message("1以上の数値を入力!", "error");
				}
				model.setLine_Width(num);
				break;
			default:
				model.setLine_Width(1.0f);
				break;
		}
	}
		
}

