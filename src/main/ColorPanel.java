package main;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorPanel extends JFrame {
	//JColorChooserを用いて色選択、選択して色を返す
	public Color ColorPanelwindow() {
		Color color = JColorChooser.showDialog(this, "Color Panel", Color.white);
		return color;

	}

}