package com.io.test4.run;

import com.io.test4.model.vo.BookManager;

public class TestBookManager {

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		manager.fileSave();
		manager.fileRead();
	}

}
