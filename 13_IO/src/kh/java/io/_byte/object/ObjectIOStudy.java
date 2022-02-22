package kh.java.io._byte.object;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOStudy {

	public static void main(String[] args) {
		ObjectIOStudy study = new ObjectIOStudy();
//		study.test1();
//		study.test2();
		study.test3();
	}

	/**
	 *  저장된 객체의 수를 모를 때 처리
	 *  while 무한루프 -> EOFException유발, 정지
	 *  				-> catch에서 출력 처리 
	 */
	private void test3() {
		User[] users = new User[100]; //모자라지 않을 크기로 선언
		int index = 0; //인덱스 관리 변수, 입력된 객체 수
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"));){
			while(true) {
				User user = (User)ois.readObject(); //파일에 더이상 읽어올 객체가 없을 때 EOFException (end of file)
				users[index++] = user;
			}
			
		} catch(EOFException e) {
			for(int i = 0; i < index; i++) {
				System.out.println(users[i]);
			}
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 같은 file에 대해서 입출력Stream을 동시에 처리하지 말것.
	 * 입력 method
	 */
	private void test2() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"));){
			User[] users = new User[3];
			//파일로부터 읽어오기
			for(int i = 0; i < users.length; i++) {
				users[i] = (User)ois.readObject(); //downCasting
			}
			//users확인 (sysout 출력)
			for(User user : users) {
				System.out.println(user);
			}
			
		} catch(IOException | ClassNotFoundException e) {
			// multi catch절 (|) 1.7 - 관련없는 예외클래스를 묶어서 처리할 수 있다.
			e.printStackTrace();
		}
	}


	/**
	 * ObjectInputStream | ObjectOutputStream
	 *  - 객체단위로 읽고 쓰기 가능한 보조스트림.
	 * 	- FileInputStream | FileOutputStram 주스트림과 함께 사용해야한다.
	 * 
	 * 	- 읽고 쓰기 할 객체의 클래스는 Serializable 인터페이스를 반드시 구현해야한다.
	 *  - 직렬화기능이 반드시 필요
	 *  
	 *  출력 method
	 */
	private void test1() {
		User[] users = new User[3];
		users[0] = new User("honggd", "1234", 1000);
		users[1] = new User("sinsa", "1234", 2000);
		users[2] = new User("sejong", "1234", 3000);
		
//		FileOutputStream fos = new FileOutputStream("users.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.ser"));){
			for(int i = 0; i < users.length; i++) {
				oos.writeObject(users[i]); //User 객체 단위로 출력
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
