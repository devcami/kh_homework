package com.opp.shape.controller;

import com.opp.shape.model.Circle;
import com.opp.shape.model.Rectangle;
import com.opp.shape.model.Shape;

public class TestShape {

	public static void main(String[] args) {
		Shape s;
		s = new Circle(15.5);
		System.out.println("원 면적 : " + s.area());
		System.out.println("원 둘레 : " + s.perimeter());
		
		s = new Rectangle(34.5, 42.7);
		System.out.println("사각형 면적 : " + s.area());
		System.out.println("사각형 둘레 : " + s.perimeter());
		
		
	}

}
