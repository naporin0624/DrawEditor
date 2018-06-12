package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ViewPanel extends JPanel implements Observer {
	protected DrawModel model;
	private Color backcolor = Color.white;
	private ArrayList<Figure> fig,gridfig;

	public ViewPanel(DrawModel m, DrawController c) {
		this.setBackground(backcolor);
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
		model = m;
		model.addObserver(this);
	}
	//ドローエディタの背景色をセットするメソッド、DrawFrameのメニューボタンで呼ばれる.
	public void BackPanelColor(Color c) {
		backcolor = c;
		this.setBackground(backcolor);
	}
	//repaint()が処理されるたびに実行されるメソッド.図形の描画よりも先にグリッド線の描画を先に行うことで図形がグリッド線の下に隠れないようにしている
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//DrawModelクラスから図形の描画データを受け取る
		fig = model.getFigure();
		//DrawModelクラスからグリッド線のデータを受け取る
		gridfig = model.getGrid();
		//for文で格納された順に描画していく.fが持っている図形データがdrawに渡されそれぞれの図形の描画を行う
		for (int i = 0; i < gridfig.size(); i++) {
			Figure f = gridfig.get(i);
			f.draw(g);
		}
		for (int i = 0; i < fig.size(); i++) {
			Figure f = fig.get(i);
			f.draw(g);
		}
	}
	//図形データが格納されているリストであるfigをclearメソッドを用いて全削除し、repaint()を実行することでパネルに描画された図形の全削除を行う.
	public void AllClear() {
		fig.clear();
		repaint();
	}
	//一番新しく追加された図形を消すメソッド.removeメソッドを用い、fig.size()-1の場所にある図形データを削除することで1つ前の図形の削除を行う.
	public void removeFigure() {
		if (fig.size() < 1)
			return;
		fig.remove(fig.size() - 1);
		repaint();
	}
	//DrawModelのcreatFigure,Gridline,reshapeFigure,が実行されるたびに呼び出され、repaint()により図形の再描画を行う.
	public void update(Observable o, Object arg) {
		repaint();
	}
}