package kh.java.io._char.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWStudy {

	public static void main(String[] args) {
		FileRWStudy study = new FileRWStudy();
//		study.test1();
//		study.test2();
		study.test3();
	}
	
	/**
	 * try with resource
	 * - 기존 try catch 개선
	 * - try()안에 선언된 Stream객체는 자동으로 반납 close작성 안해도 됨.
	 * - 1.7부터 지원
	 */
	private void test3() {
		File inFile = new File("sample.txt");
		File outFile = new File("sampleCopyCopy.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(inFile));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));) {
			
			String data = null;
			
			while((data = br.readLine()) != null) {
				System.out.println(data);
				bw.write(data); //개행문자가 제거되어있음
				bw.write("\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 보조스트림 추가하기
	 */
	private void test2() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			File inFile = new File("sample.txt");
			File outFile = new File("sampleCopyCopy.txt");
			
			br = new BufferedReader(new FileReader(inFile));
			bw = new BufferedWriter(new FileWriter(outFile));
			
			String data = null;
			
			while((data = br.readLine()) != null) {
				System.out.println(data);
				bw.write(data); //개행문자가 제거되어있음
				bw.write("\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * text file을 읽는 데 특화된 문자기반스트림
	 * - 주스트림 : FileReader | FileWriter
	 * - 보조스트림 : BufferedReader | BufferedWriter
	 */

	private void test1() {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			File inFile = new File("sample.txt"); //존재하거나 존재하지않는 file,directory을 가리키는 java객체
			File outFile = new File("sampleCopyCopy.txt");
			
			fr = new FileReader(inFile);
			fw = new FileWriter(outFile);
			int data = 0;

			while((data = fr.read()) != -1) {
				System.out.println((char)data);
				fw.write(data);
			}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
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
