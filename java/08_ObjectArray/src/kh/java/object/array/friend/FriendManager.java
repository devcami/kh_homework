package kh.java.object.array.friend;

import java.util.Scanner;

public class FriendManager {
	
	private Scanner sc = new Scanner(System.in);
	private static final int LENGTH = 3;
	private Friend[] friends = new Friend[LENGTH];
	private int index = 0;
	
	public void menu() {
		String menu = "--- 친구관리 ---\n" +
					  "1. 친구등록\n" +
					  "2. 친구목록 출력\n" +
					  "0. 종료\n" +
					  "--------------\n"+
					  "번호 입력 > ";
		while(true) {
			System.out.println(menu);
			String choice = sc.next();
			switch(choice) {
			case "1" : 
				inputFriends(); 
				if(index == LENGTH) 
					System.out.println(">>> 공간이 부족합니다 ! ! !");
				break;
			case "2" : printFriends(); break;
			case "0" :
				return;
			default : System.out.println("잘못입력하셨습니다.");
				
			}
		}
	}
	
	
	//insertFriends method는 inputFriends안에 써줘도 되지만 분리해서 사용했다.
	public void insertFriends(Friend friend) {
		friends[index++] = friend;
	}
	
	public void inputFriends() {
		
		while(index < LENGTH) {
			//친구입력
			System.out.print("친구 이름을 입력하세요 > ");
			String name = sc.next();
			Friend f = new Friend(name);
			insertFriends(f); //배열에 등록
			
			//입력완료 여부
			System.out.print("더 입력하시겠습니까? ( y / n ) : ");
			char yn = sc.next().charAt(0);
			if(yn == 'n') break;
			
		}
		System.out.println(">>> 입력 완료 !!!");
	}
	
	public void printFriends() {
		for(int i = 0; i < index; i++) {
			Friend f = friends[i];
			System.out.println(i + " : " + f.getFriendInfo());
		}
	}
}
