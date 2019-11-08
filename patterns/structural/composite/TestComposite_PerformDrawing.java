package com.san.patterns.structural.composite;


import com.san.patterns.structural.composite.Circle;
import com.san.patterns.structural.composite.Drawing;
import com.san.patterns.structural.composite.Shape;
import com.san.patterns.structural.composite.Triangle;

public class TestComposite_PerformDrawing {

	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();
		
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}

}
