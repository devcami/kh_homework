package com.io.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {
		Test1 test = new Test1();
//		test.fileSave();
		test.fileRead();
	}
	private void fileRead() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = null;
		
		try {
			System.out.println("읽을 파일명 입력 : ");
			fileName = br.readLine();
			br = new BufferedReader(new FileReader(fileName));
			
			String contents = null;
			StringBuilder sb = new StringBuilder();
			
			while((contents = br.readLine()) != null) {
				sb.append(contents);
				sb.append("\n");
			}
			System.out.println(sb.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void fileSave() {
		// 키보드로 사용할 파일 명을 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 파일출력용 객체
		FileWriter fw = null;

		String fileName = null;
		String data = null;
		
		try {
			System.out.println("파일명 입력 : ");
			fileName = br.readLine();
			
			fw = new FileWriter(fileName);
			System.out.println("파일에 저장할 내용을 입력하시오.");
			while((data = br.readLine()) != null) {
				if("exit".equals(data)) break;
				fw.write(data);
				fw.write("\n");
			}
			System.out.println("파일이 성공적으로 저장되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
