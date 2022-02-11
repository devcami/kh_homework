package com.oop.coffee.controller;

import java.util.Scanner;

import com.oop.coffee.model.dto.Coffee;

public class CoffeeManager {
	
	private Scanner sc = new Scanner(System.in);
	private static final int LENGTH = 3;
	int index = 0;
	Coffee[] coffee = new Coffee[LENGTH];
	
	public void inputData() {
		System.out.println("<커피 정보 입력>");
		
		for(int i = 0; i < LENGTH; i++) {
			System.out.println("-----"+(i + 1)+"번 커피-----");
			System.out.print("원산지 입력 > ");
			String origin = sc.next();
			System.out.print("커피명 입력 > ");
			String coffeeName = sc.next();
			
			coffee[i] = new Coffee(origin, coffeeName);
			
		}
		System.out.println("> > > 입력 완료 !");
	}
	
	public void printCoffee() {
		System.out.println("<세계 3대 커피>");
		System.out.println("---------------------------");
		System.out.println("원산지\t\t커피명" );
		System.out.println("---------------------------");
		
		for(Coffee c : coffee) {
			System.out.println(c.coffeeInfo());
		}

		System.out.println("---------------------------");
	}
	

}
