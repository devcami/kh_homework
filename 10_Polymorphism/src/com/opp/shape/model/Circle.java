package com.opp.shape.model;

public class Circle extends Shape {

	private double radius; //반지름
	
	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return (radius * radius) * Math.PI;
	}

	@Override
	public double perimeter() {
		return (radius * 2) * Math.PI;
	}

}
