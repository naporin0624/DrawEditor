package main;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorPanel extends JFrame {
	public Color ColorPanelwindow() {
		JColorChooser colorchooser = new JColorChooser();
		Color color = colorchooser.showDialog(this, "Color Panel", Color.white);
		return color;

	}

}