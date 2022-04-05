package com.collections.map.book.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.list.book.model.compare.AscTitle;
import com.collection.list.book.model.vo.Book;

public class MapBookManager {
	//도서번호 bNo - key, Book - value
	private Map<String , Book> booksMap;

	public MapBookManager() {
		booksMap = new HashMap<>();
//		booksMap.put("1",new Book("1", 1, "아아아", "저자1"));
//		booksMap.put("2",new Book("2", 2, "김김김", "저자2"));
//		booksMap.put("3",new Book("3", 3, "지지지", "저자3"));
//		booksMap.put("4",new Book("4", 4, "비비비", "저자4"));
	}

	public MapBookManager(Map<String, Book> booksMap) {
		super();
		this.booksMap = booksMap;
	}
	
	public void putBook(Book book) {
		booksMap.put(book.getbNo(), book);
	}
	public void deleteBook(String key) {
		booksMap.remove(key);
	}
	
	//도서명이 일치하는 객체의 도서번호 리턴
	//도서명이 일치하는 객체가 맵에 없으면 null 리턴
	//entrySet
	public String searchBook(String title) {
		Set<Map.Entry<String, Book>> entrySet = booksMap.entrySet();
		for(Map.Entry<String, Book> entry : entrySet) {
			Book book = entry.getValue();
			//입력값이 제목에 포함되어있으면
			if(book.getTitle().contains(title)) {
				//key값 리턴
				return entry.getKey();
			}
		}
		return null;
	}
	//맵정보 모두 출력
	public void displayAll() {
		Set<String> keySet = booksMap.keySet();
		for(String key : keySet) {
			System.out.println(booksMap.get(key).toString());
		}
	}
	
	
	//해당 도서명순으로 오름차순 정렬해서 객체배열 리턴
	public Book[] sortedBookMap() {
		Book[] bookArray = new Book[booksMap.size()];
		List<Book> valueList = new ArrayList<>(booksMap.values());
		//도서명 오름차순 정렬
		Comparator<Book> comp = new AscTitle();
		Collections.sort(valueList, comp);
		
		for(int i = 0; i < bookArray.length; i++) {
			bookArray[i] = valueList.get(i);
		}
		return bookArray;
		
	}
	
	public void printBookMap(Book[] br) {
		for(Book book : br) {
			System.out.println(book);
		}
	}
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
	
}
