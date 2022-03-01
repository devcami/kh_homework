package com.collection.list.book.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.collection.list.book.model.compare.AscCategory;
import com.collection.list.book.model.vo.Book;

public class BookManager {
	
	private List<Book> bookList = new ArrayList<>();

	public BookManager() {
		bookList.add(new Book("1", 1, "책1", "저자1"));
		bookList.add(new Book("2", 2, "책2", "저자2"));
		bookList.add(new Book("3", 3, "책3", "저자3"));
		bookList.add(new Book("4", 4, "책4", "저자4"));
	}

	public BookManager(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}
	
	//리스트에 객체 추가
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	//리스트에서 객체 제거
	public void deleteBook(int index) {
		bookList.remove(index);
	}
	
	//도서명이 일치하는 객체를 찾아 해당 인덱스를 리턴
	//도서명이 일치하는 객체가 없으면 -1 리턴
	public int searchBook(String title) {
		for(int i = 0; i < bookList.size(); i++) {
			if(title.equals(bookList.get(i).getTitle())) {
				return i;
			}
		}
		return -1;
	}
	
	//인덱스 위치의 객체의 정보를 출력
	public void printBook(int index) {
		System.out.println(bookList.get(index));
	}
	//목록정보 모두 출력
	public void printAll() {
		for(Book book : bookList) {
			System.out.println(book);
		}
	}
	//해당 카테고리순 오름차순 정렬해서 객체배열 리턴
	public Book[] sortedBookList() {
		//BookList오름차순정렬
		//List복사해서 복사한 것 정렬
		List<Book> copyList = (List<Book>)((ArrayList<Book>)this.bookList).clone();
		Comparator<Book> comp = new AscCategory();
		copyList.sort(comp);
		
		//BookList -> Array
		Book[] bookListArray = copyList.toArray(new Book[copyList.size()]);
		
		return bookListArray;
	}
	//객체배열출력
	public void printBookList(Book[] br) {
		for(Book book : br) {
			System.out.println(book);
		}
	}


}
