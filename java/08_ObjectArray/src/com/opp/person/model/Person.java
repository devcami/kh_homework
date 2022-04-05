package com.opp.person.model;

public class Person {
	
	private String name;
	private int age;
	private double height;
	private double weight;
	private int asset;
	
	public Person() {}
	public Person(String name, int age, double height, double weight, int asset) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.asset = asset;
	}
	
	public String information() {
		return "[이름 : " + name 
		     + ", 나이 : " + age 
			 + ", 키 : " + height 
			 + ", 몸무게 : " + weight 
			 + ", 자산 : " + asset + "]";
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAsset() {
		return asset;
	}
	public void setAsset(int asset) {
		this.asset = asset;
	}
	
	

}
