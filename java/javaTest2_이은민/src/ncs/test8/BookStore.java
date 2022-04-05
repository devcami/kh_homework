package ncs.test8;

import ncs.test7.Book;

public class BookStore {

	public static void main(String[] args) {
		//Book객체생성
		Book bookdata = new Book("IT", "HTML5", 30000, 15);
		//Book객체 기본정보출력 
		System.out.println("기본 정보");
		System.out.println(bookdata.getBookName() + "\t" + bookdata.getBookPrice());
		
		//Bookupdater객체 생성
		BookUpdater bookupdater = new BookUpdater(bookdata);
		//updateBookPrice 함수를 통해 Book객체의 할인율을 적용시켜 가격변경
		bookupdater.updateBookPrice(bookdata);
		
		//Book객체의 변경된 정보 출력
		System.out.println("변경된 정보");
		System.out.println(bookdata.getBookName() + "\t" + bookdata.getBookPrice());
		
		
	}

}
