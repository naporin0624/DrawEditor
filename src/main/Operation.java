package main;

import java.awt.Color;
import java.util.ArrayList;

public class Operation {
	public ArrayList<String> Name_data;
	public ArrayList<Figure> Fig_data;
	public ArrayList<Color> Color_data;
	public ArrayList<String> Shape_data;
	public ArrayList<Float> Size_data;
	
	public Operation() {
		Fig_data = new ArrayList<Figure>();
		Color_data = new ArrayList<Color>();
		Color_data.add(Color.red);
		System.out.println(Color_data.get(0));
		Shape_data = new ArrayList<String>();
		Shape_data.add("square");
		System.out.println(Shape_data.get(0));
		Size_data = new ArrayList<Float>();
		Size_data.add(1.0f);
		System.out.println(Size_data.get(0));
	}
	
	public void setColor(Color c) {
		Name_data.add("color");
		Color_data.add(c);
	}
	
	public Color getColor(){
		return Color_data.get(Color_data.size()-1);
	}
	
	public void setFigure(Figure f) {
		Name_data.add("figure");
		Fig_data.add(f);
	}
	
	public ArrayList<Figure> getFigure(){
		return Fig_data;
	}
	
	public Figure getFigure(int idx) {
		return Fig_data.get(idx);
	}
	
	public void setShape(String s) {
		Name_data.add("shape");
		Shape_data.add(s);
	}
	
	public String getShape(){
		return Shape_data.get(Shape_data.size()-1);
	}
	
	public void setSize(Float size) {
		Name_data.add("size");
		Size_data.add(size);
	}
	
	public Float getSize(){
		return Size_data.get(Size_data.size()-1);
	}
	
	public void remove_data() {
		if(Name_data.size()>1) {
			String name = Name_data.get(Name_data.size()-1);
			Name_data.remove(Name_data.size()-1);
			if(name == "color") Color_data.remove(Color_data.size()-1);
			else if(name =="figure") Fig_data.remove(Fig_data.size()-1);
			else if(name == "shape") Shape_data.remove(Shape_data.size()-1);
			else if(name == "size") Size_data.remove(Size_data.size()-1);
		}
	}
}
