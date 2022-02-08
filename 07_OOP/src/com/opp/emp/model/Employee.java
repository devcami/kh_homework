package com.opp.emp.model;

import java.util.Scanner;

public class Employee {
	
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	

	
	
	
	public void empInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***** 새 사원 정보 입력 *****");
		System.out.print("사번 : ");
		setEmpNo(sc.nextInt());
		System.out.print("이름 : ");
		setEmpName(sc.next());
		System.out.print("소속부서 : ");
		setDept(sc.next());
		System.out.print("직급 : ");
		setJob(sc.next());
		System.out.print("나이 : ");
		setAge(sc.nextInt());
		System.out.print("성별 : ");
		setGender(sc.next().charAt(0));
		System.out.print("급여 : ");
		setSalary(sc.nextInt());
		System.out.print("보너스포인트 : ");
		setBonusPoint(sc.nextDouble());
		System.out.print("핸드폰 : ");
		setPhone(sc.next());
		
		sc.nextLine();
		System.out.print("주소 : ");
		setAddress(sc.nextLine());
		
	}
	
	public void empOutput() {
		
		System.out.println("***** 사원 정보 출력 *****");
		System.out.printf("사번 : %d%n", getEmpNo());
		System.out.printf("이름 : %s%n", getEmpName());
		System.out.printf("소속부서 : %s부서%n", getDept());
		System.out.printf("직급 : %s%n", getJob());
		System.out.printf("나이 : %d세%n", getAge());
		System.out.printf("성별 : %c자%n", getGender());
		System.out.printf("급여 : %d원%n", getSalary());
		System.out.printf("보너스포인트 : %.1f%n", getBonusPoint());
		System.out.printf("핸드폰 : %s%n", getPhone());
		System.out.printf("주소 : %s%n", getAddress());

	}
	
	
	//setter
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	//getter
	public int getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public String getDept() {
		return dept;
	}
	public String getJob() {
		return job;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}




	


}
