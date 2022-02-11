package com.opp.person.controller;

import java.util.Scanner;

import com.opp.person.model.Person;

public class PersonController {
	private Scanner sc = new Scanner(System.in);
	private static final int LENGTH = 5;
	
	Person[] person = new Person[LENGTH];
	
	private double sumAge;
	private double sumHeight;
	private double sumWeight;
	private double sumAsset;
	
	private double avrAge;
	private double avrHeight;
	private double avrWeight;
	private double avrAsset;
	
	public void inputData() {
		
		for(int i = 0; i < LENGTH; i++) {
			
			Person p = new Person();
			
			System.out.println("----" + (i + 1) +"번 정보입력 ----");
			System.out.print("이름 : ");
			p.setName(sc.next());
			System.out.print("나이 : ");
			p.setAge(sc.nextInt());
			System.out.print("키 : ");
			p.setHeight(sc.nextDouble());
			System.out.print("몸무게 : ");
			p.setWeight(sc.nextDouble());
			System.out.print("재산 : ");
			p.setAsset(sc.nextInt());
			
			person[i] = p;
			
			
		}
	}
	
	public void printData() {
		System.out.println("-------------------");
		for(Person p : person) {
			System.out.println(p.information());
		}
	}
	
	public void avrDate() {
		for(Person p : person) {
			sumAge += p.getAge();
			sumHeight += p.getHeight();
			sumWeight += p.getWeight();
			sumAsset += p.getAsset();
			
			avrAge = sumAge / LENGTH;
			avrHeight = sumHeight / LENGTH;
			avrWeight = sumWeight / LENGTH;
			avrAsset = sumAsset / LENGTH;
		}
		
		System.out.println("-------------------");
		System.out.println("입력 내역 평균 안내");
		System.out.println("-------------------");
		System.out.println("평균 나이 : " + avrAge);
		System.out.println("평균 키 : " + avrHeight);
		System.out.println("평균 몸무게 : " + avrWeight);
		System.out.println("평균 자산 : " + avrAsset);
		
	}

}
