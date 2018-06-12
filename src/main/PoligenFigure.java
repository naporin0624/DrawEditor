package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class PoligenFigure extends Figure {

	public PoligenFigure(int x, int y, int w, int h, float size, Color c) {
		super(x, y, w, h, size, c);
	}
	//Figureクラスのdrawメソッドをオーバーライドしている.ここではGraphics2Dを用いてFigureクラスで形成した座標データを基に三角形の図形データを生成している.三角形の座標データの引数は3つであるため、はじめにクリックした座標が三角形の凸の座標した.残り2つの座標はマウスがy座標に動いた分だけ三角形を縦に伸ばし、x座標に動いた分だけ三角形を横に伸ばすようにデータを設定した.
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(color);
		BasicStroke superwideStroke = new BasicStroke(size);
		g2d.setStroke(superwideStroke);
		
		int xPoint[] = { x, 2 * x - width, width };
		int yPoint[] = { y, height, height };
		g2d.draw(new Polygon(xPoint, yPoint, 3));
	}
}
