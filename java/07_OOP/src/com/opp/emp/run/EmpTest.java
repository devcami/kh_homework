package com.opp.emp.run;

import java.util.Scanner;

import com.opp.emp.model.Employee;

public class EmpTest {
	Scanner sc = new Scanner(System.in);
	Employee e = null;
	
	public static void main(String[] args) {
		EmpTest t = new EmpTest();
		t.mainMenu();
		
	}
	
	/**
	 * 모든 non-static 메소드는 숨은 참조변수 this를 가진다
	 * -this는 현재객체를 가리킨다.
	 */
	public void mainMenu() {
		String menu = "******* 사원 정보 관리 프로그램 *******\n"
				+ "\n"
				+ "	1. 새 사원 정보 입력\n"
				+ "	2. 사원 정보 수정\n"
				+ "	3. 사원 정보 삭제\n"
				+ "	4. 사원정보 출력\n"
				+ "	9. 끝내기\n"
				+ "\n"
				+ "*********************************";
		
		int select = 0;
		
		for(;;) {
			System.out.println(menu);
			System.out.print("번호 선택 >> ");
			select = sc.nextInt();
			switch(select) {
			case 1 :
				e = new Employee();
				e.empInput();
				break;
			case 2 :
				if(e == null) {
					System.out.println("사원정보를 먼저 입력하세요.");
					break;
				}
				//this.modifyMenu가 생략된거고 this 는 EmpTest 객체 t를 가리킨다.
				modifyMenu(e);
				break;
			case 3 :
				e = null;
				break;
			case 4 :
				if(e == null) {
					System.out.println("사원정보를 먼저 입력하세요.");
					break;
				}
				e.empOutput();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default : 
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
		}
	}
	
	public void modifyMenu(Employee e) {
		String modify = "******** 사원 정보 수정 메뉴 ********\n"
				+ "	1. 이름 변경 \n"
				+ "	2. 급여 변경 \n"
				+ "	3. 부서 변경 \n"
				+ "	4. 직급 변경 \n"
				+ "	5. 이전 메뉴로 이동 \n"
				+ "**********************************";
		Scanner sc = new Scanner(System.in);
		int modifySelect = 0;
		for(;;) {
			System.out.println(modify);
			System.out.print("번호 선택 >> ");
			modifySelect = sc.nextInt();
			sc.nextLine();
			
			switch(modifySelect) {
			
			case 1 :
				System.out.print("이름 변경 : ");
				e.setEmpName(sc.next());
				break;
			case 2 : 
				System.out.print("급여 변경 : ");
				e.setSalary(sc.nextInt());
				break;
			case 3 :
				System.out.print("부서 변경 : ");
				e.setDept(sc.next());
				break;
			case 4 :
				System.out.print("직급 변경 : ");
				e.setJob(sc.next());
				break;
			case 5 :
				System.out.println("이전 메뉴로 이동합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
			
		}
	}
	
	
}
