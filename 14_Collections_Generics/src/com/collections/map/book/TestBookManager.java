package com.collections.map.book;

import java.util.Scanner;

import com.collections.map.book.controller.MapBookManager;
import com.collection.list.book.model.vo.Book;

public class TestBookManager {
	private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		TestBookManager test = new TestBookManager();
		test.menu();
	}
	private void menu() {
		String menu = "*** 도서 관리 프로그램 ***\n"
				+ "-----------------------------\n"
				+ "1. 새 도서 추가	\n"
				+ "2. 도서정보 정렬후 출력\n"
				+ "3. 도서 삭제	\n"
				+ "4. 도서 검색출력	\n"
				+ "5. 전체 출력	\n"
				+ "6. 끝내기\n"
				+ "-----------------------------\n"
				+ ">> 번호입력 : ";
		
		MapBookManager bm = new MapBookManager();
		
		while(true) {
			System.out.print(menu);
			String select = sc.next();
			
			switch(select){
			case "1" : 
				bm.putBook(inputBook()); 
				break;
			case "2" : 
				bm.printBookMap(bm.sortedBookMap()); 
				break;
			case "3" : 
				String key = bm.searchBook(inputBookTitle()); 
				if(key == null) {
					System.out.println("일치하는 도서가 없습니다.");
				} else {
					bm.deleteBook(key);
					System.out.println("삭제되었습니다.");
				}
				break;
			case "4" : 
				key = bm.searchBook(inputBookTitle());
				if(key == null) {
					System.out.println("일치하는 도서가 없습니다.");
				} else bm.printBook(key);
				break;
			case "5" : 
				bm.displayAll(); 
				break;
			case "6" : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못 입력하셨습니다."); break;

			}
		}
	}
	/**
	 * Book객체의 필드값을 키보드로 입력받아 초기화 후 객체리턴 
	 */
	public Book inputBook() {
		sc.nextLine();
		System.out.print("도서 번호 : ");
		String bNo = sc.nextLine();
		System.out.print("도서 분류 코드 (1.인문/2.자연과학/3.의료/4.기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("책 제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		Book book = new Book(bNo, category, title, author);
		return book;
		
	}
	
	/**
	 * 삭제 또는 검색을 위한 도서 타이틀을 키보드로 입력받아 리턴
	 */
	public String inputBookTitle() {
		sc.nextLine();
		System.out.print("책 제목 입력 : ");
		
		return sc.nextLine();
	}

}
