package com.opp.emp.run;

import java.util.Scanner;

import com.opp.emp.model.Employee;

public class EmpTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Employee emp1 = new Employee();
		
		Menu : 
		for(;;) {
			emp1.menu();
			System.out.print("번호를 입력하세요 >> ");
			int num = sc.nextInt();

			switch(num) {
			case 1 : 
				emp1.empInput();
				break;

			case 2 : 
				emp1.setEmpNo(0);
				emp1.setEmpName(null);
				emp1.setDept(null);
				emp1.setJob(null);
				emp1.setAge(0);
				emp1.setGender(' ');
				emp1.setSalary(0);
				emp1.setBonusPoint(0);
				emp1.setPhone(null);
				emp1.setAddress(null);
				break;

			case 3 : 
				emp1.empOutput();
				break;

			case 9 :
				System.out.println("프로그램을 종료합니다.");
				break;

			default :
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			for(;;) {
				System.out.print("종료하시겠습니까? ( y / n ) >> ");
				char yn = sc.next().charAt(0);

				if(yn == 'n') {
					continue Menu;
				}
				else if(yn == 'y') {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					continue;
				}
			}
		}
	}
	
}
