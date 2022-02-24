package com.io.test4.model.vo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookManager {
	Scanner sc = new Scanner(System.in);

	public BookManager() {
		super();
	}
	
	public void fileSave() {
		Book[] books = new Book[5];
		books[0] = new Book("책이름1" ,"저자1", 10_000, new GregorianCalendar(2022, 1-1, 1));
		books[1] = new Book("책이름2" ,"저자2", 20_000, new GregorianCalendar(2022, 2-1, 2));
		books[2] = new Book("책이름3" ,"저자3", 30_000, new GregorianCalendar(2022, 3-1, 3));
		books[3] = new Book("책이름4" ,"저자4", 40_000, new GregorianCalendar(2022, 4-1, 4));
		books[4] = new Book("책이름5" ,"저자5", 50_000, new GregorianCalendar(2022, 5-1, 5));
		
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")));) {
			oos.writeObject(books);
			System.out.println("books.dat에 저장 완료 !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void fileRead() {
		Book[] books = new Book[5];
		try(ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.dat")));) {
			books = (Book[])ois.readObject();
			for(Book book : books) {
				System.out.println(book);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
