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
	
	public Under_Panel(DrawModel model) {
		//ドローエディタの下に置くボタンやチェックボックスを設置するメソッド
		this.model = model;
		button = new ArrayList<JButton>();
		check = new ArrayList<JCheckBox>();
		
		//ボタンを追加
		button.add(new JButton("Clear"));
		button.add(new JButton("ReDraw"));
		Add_Button(button);
		
		//チェックボックスを追加する
		check.add(new JCheckBox("Grid"));
		Add_Check(check);
		
	}
	
	//パネルにボタンを追加する
	public void Add_Button(ArrayList<JButton> button) {
		for(int i=0;i<button.size();i++) {
			this.add(button.get(i));
			button.get(i).addActionListener(this);
		}
	}
	//パネルにチェックボックスを追加する
	public void Add_Check(ArrayList<JCheckBox> check) {
		for(int i=0;i<check.size();i++) {
			this.add(check.get(i));
			check.get(i).addActionListener(this);
		}
	}
	
	//ボタンやチェックボックスをクリックしたときの動作
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Clear":
				model.AllClear();
				break;
			case "ReDraw":
				model.removeFigure();
				break;
			case "Grid":
				model.Gridline();
				break;
			default:
				break;
		}
	}
}
