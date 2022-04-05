package kh.java.oop.field;

public class FieldMain {

	public static void main(String[] args) {
		
		//객체1
		IPhone13 phone1 = new IPhone13();
		phone1.setOwner("홍길동");
		phone1.setNumber("01012341234");
		phone1.printInfo();
		
		//객체2
		IPhone13 phone2 = new IPhone13();
		phone2.setOwner("신사임당");
		phone2.setNumber("01022223333");
		phone2.printInfo();
		
		// 클래스 변수는 **클래스이름.변수명** 으로 사용 (객체명 사용XXX)
		// 메모리는 static영역에 생성되고, 따로 관리함
		System.out.println(IPhone13.WIDTH);
		System.out.println(IPhone13.HEIGHT);
		
		// 다음과 같이 출력되도록 메소드 작성
		// 홍길동(01012341234)님이 신사임당(01022223333)으로 전화를 겁니다...
		phone1.callTo(phone2);
	}

}
