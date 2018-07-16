package main;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorPanel extends JFrame {
	
	//JColorChooserを開き選んだ色を返すメソッド
	public Color ColorPanelwindow() {
		Color color = JColorChooser.showDialog(this, "Color Panel", Color.black);
		return color;
	}
}