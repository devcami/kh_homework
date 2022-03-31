package member.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

/**
 * View 단 클래스
 * - Menu 노출, 사용자 입력값 처리, 결과값 출력
 *
 */
public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	
	public void mainMenu() {
		String menu = "===== 회원관리 =====\n"
	                + "1. 회원 전체 조회\n"
	                + "2. 회원 아이디 조회\n"
	                + "3. 회원 이름 검색\n"
	                + "4. 회원 가입\n"
	                + "5. 회원 정보 변경\n"
	                + "6. 회원 탈퇴\n"
	                + "0. 프로그램 종료\n"
	                + "------------------\n"
	                + "선택 : ";
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			
			Member member = null;
			int result = 0;
			String name = null;
			String id = null;
			List<Member> list = null;
			
			switch (choice) {
			case "1" : 
				list = memberController.selectAll();
				printMemberList(list);
				break;
			case "2" : 
				id = inputId();
				member = memberController.selectOne(id);
				printMember(member);				
				break;
			case "3" : 
				name = inputMemberName();
				list = memberController.findMemberByName(name);
				printMemberList(list);
				break;
			case "4" : 
				member = inputMember();
				result = memberController.insertMember(member);
				printResultMsg(result, "회원가입 성공!", "회원가입 실패!");
				break;
			case "5" : 
				id = inputId();
				member = memberController.selectOne(id);
				if(member != null) {
					printMember(member);
					updateMenu(member);
				} else printMember(member);					
				break;
			case "6" : 
				id = inputId();
				member = memberController.selectOne(id);
				if(deleteCheck()) {
					result = memberController.deleteMember(member);
					printResultMsg(result, "회원 삭제 성공!", "회원 삭제 실패!");
				} else {
					System.out.println("취소하셨습니다.");
					continue;
				}
			case "0" : return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
	}
	
	/**
	 * 회원탈퇴 확인 체크
	 */
	private boolean deleteCheck() {
		while(true) {
			System.err.println("확인 시 회원 정보가 사라집니다.");
			System.err.println("> 정말 삭제하시겠습니까? (Y | N) : ");
			char yn = sc.next().toUpperCase().charAt(0);
			if(yn == 'Y') return true;
			else if (yn == 'N') return false;
			else {
				System.out.println("올바른 문자를 입력해주세요.");
				continue;
			}
		}
	}

	/**
	 * 회원 정보 변경 서브메뉴
	 */
	public void updateMenu(Member member) {
		String menu = "****** 회원 정보 변경 메뉴 ******\n"
	                + "1. 이름 변경\n"
	                + "2. 생일 변경\n"
	                + "3. 이메일 변경\n"
	                + "4. 주소 변경\n"
	                + "9. 메인 메뉴 돌아가기\n"
	                + "-----------------------------\n"
	                + "선택 : ";
		int result = 0;
		
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			
			switch (choice) {
			case "1":
				System.out.print("> 수정할 이름 입력 : ");
				member.setName(sc.next());
				result = memberController.updateName(member);
				if(result > 0) {
					printResultMsg(result, "회원 수정 성공!", "회원 수정 실패!");
					printMember(member);
				}
				continue;
			case "2":
				System.out.print("> 수정할 생일 입력 (예 19990314) : ");
				String _birthday = sc.next();
				Date birthday = null;
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					birthday = new Date(sdf.parse(_birthday).getTime());
				} catch (Exception e) {
					e.printStackTrace();
				}
				member.setBirthday(birthday);
				result = memberController.updateBirthDay(member);
				if(result > 0) {
					printResultMsg(result, "회원 수정 성공!", "회원 수정 실패!");
					printMember(member);
				}
				continue;
			case "3":
				System.out.print("> 수정할 이메일 입력 : ");
				member.setEmail(sc.next());
				result = memberController.updateEmail(member);
				if(result > 0) {
					printResultMsg(result, "회원 수정 성공!", "회원 수정 실패!");
					printMember(member);
				}
				continue;
			case "4":
				System.out.print("> 수정할 주소 입력 : ");
				sc.nextLine();
				member.setAddress(sc.nextLine());
				result = memberController.updateAddress(member);
				if(result > 0) {
					printResultMsg(result, "회원 수정 성공!", "회원 수정 실패!");
					printMember(member);
				}
				continue;
			case "9": return;

			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	/**
	 * id 사용자 입력값을 받는 메소드
	 * @return id
	 */
	private String inputId() {
		System.out.println("> 회원 id를 입력하세요");
		System.out.print("id : ");
		return sc.next();
	}

	/**
	 * Member 1명 출력 메소드
	 */

	private void printMember(Member member) {
		if(member == null) {
			System.out.println("> 조회된 회원이 없습니다.");
		} else {
			System.out.println("> 조회 결과");
			System.out.println("-----------------------------------");
			System.out.printf("id : %s%n", member.getId());
			System.out.printf("name : %s%n", member.getName());
			System.out.printf("gender : %s%n", member.getGender());
			System.out.printf("birthday : %s%n", member.getBirthday());
			System.out.printf("email : %s%n", member.getEmail());
			System.out.printf("address : %s%n", member.getAddress());
			System.out.printf("regDate : %s%n", member.getRegDate());
			System.out.println("-----------------------------------");
			System.out.println();
		}
	}
	
	/**
	 * Member List 출력 메소드
	 */
	private void printMemberList(List<Member> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("> 조회된 회원이 없습니다.");
		}else {
			System.out.println("> 조회 결과");
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.printf("%15s%15s%15s%15s%15s%15s%15s%n", 
							  "id", "name", "gender", "birthday", "email", "address", "regDate");
			System.out.println("--------------------------------------------------------------------------------------------------");
			for(Member member : list) {
				System.out.printf("%15s%15s%15s%15s%15s%20s%25s%n", 
						member.getId(),
						member.getName(),
						member.getGender(),
						member.getBirthday(),
						member.getEmail(),
						member.getAddress(),
						member.getRegDate());
				
			}
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println();
		}
	}

	/**
	 * 조회할 회원명 입력 메소드
	 */
	private String inputMemberName() {
		System.out.println("> 조회할 이름을 입력하세요.");
		System.out.print("이름 : ");
		return sc.next();
	}

	/**
	 * 회원가입
	 * 신규 회원 정보를 입력받는 메소드
	 */
	private Member inputMember() {
		Member member = new Member();
		
		System.out.println("> 신규 회원 정보를 입력하세요");

		System.out.print("> id : ");
		member.setId(sc.next());

		System.out.print("> name : ");
		member.setName(sc.next());
		
		System.out.print("> gender (M/F) : ");
		member.setGender(String.valueOf(sc.next().toUpperCase().charAt(0)));
		
		System.out.print("> birthday (예 19990314) : ");
		String _birthday = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birthday = null;
		try {
			long millis = sdf.parse(_birthday).getTime();
			birthday = new Date(millis);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		member.setBirthday(birthday);
		
		System.out.print("> email : ");
		member.setEmail(sc.next());
		
		System.out.print("> address : ");
		sc.nextLine(); //개행문자제거
		member.setAddress(sc.nextLine());
		
		
		return member;
	}

	/**
	 * DML 처리 결과를 출력하는 메소드(result 1 or 0)
	 * @param result
	 * @param successMsg
	 * @param failureMsg
	 */
	private void printResultMsg(int result, String successMsg, String failureMsg) {
		if(result > 0) {
			System.out.println("> " + successMsg);
		}
		else {
			System.out.println("> " + failureMsg);
		}
			
	}

}
