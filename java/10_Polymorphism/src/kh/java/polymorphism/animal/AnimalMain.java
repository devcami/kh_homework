package kh.java.polymorphism.animal;

import java.util.Random;

public class AnimalMain {

	public static void main(String[] args) {
		AnimalMain main = new AnimalMain();
//		main.test1();
//		main.test2();
//		main.test3();
//		main.test4();
//		main.test5();
//		main.test6();
//		main.test7();
//		main.test8();
//		main.test9();
//		main.test10();
//		main.test11();
		main.test12();
		
	}
	
	/**
	 * 추상클래스에서 인터페이스 구현하기
	 * Animal	  Soundable
	 *  - 추상클래스(Animal)는 부모 추상메소드(Soundable의 getSound)를 구현하지 않아도 된다.
	 */
	public void test12() {
		Animal[] animals = new Animal[4];
		animals[0] = new Tiger();
		animals[1] = new Lion();
		animals[2] = new Bear();
		animals[3] = new Eagle();
		
		for(Animal animal : animals) {
			System.out.println(animal.getSound());
		}
	}
	
	/**
	 * Eagle 클래스를 작성하세요.
	 *  - Animal 클래스 상속
	 *  - Flyable 인터페이스 구현
	 *  	-> fly 추상메소드
	 *  
	 */
	public void test11() {
		Eagle eagle = new Eagle();
		
		eagle.say();
		eagle.attack();
		eagle.fly();
		
	}
	
	/**
	 *  interface 다중 구현
	 *  - 자식클래스는 여러개의 인터페이스를 구현할 수 있다.
	 *  
	 */
	public void test10() {
		Tiger tiger = new Tiger();
		Washable washTiger = tiger;
		
		washTiger.wash();
		
		Runnable runTiger = tiger;
		runTiger.run();
	}
	
	/**
	 * JDK8에 추가된 interface의
	 * - default method : walk
	 * - static method : warmup
	 */
	public void test9() {
		Bear bear = new Bear();
		bear.walk();
		Runnable runner = new Tiger();
		runner.walk();
		
		//static method : 객체를 만들지 않고 클래스.메소드명(); 으로 호출
		Runnable.warmup();
	}
	
	/**
	 * 인터페이스와 구현클래스 사용하기
	 * 
	 */
	public void test8() {
		Bear bear = new Bear();
		//Runnable도 부모로 작용
		//다형성 적용 (상속, 모든메소드 override, Runnable 변수 (run)에 bear객체 담기(New Bear();))
		//run = Runnable인척 하는 Bear
		Runnable run = bear;
		
		bear.attack();
		bear.say();
		bear.run();
		
		//Runnable 관련 기능만 사용가능.
		//동적바인딩 (다형성에 부모클래스 메소드 실행하면 자동으로 담은 자식 객체(Bear)의 메소드를 작동시킴
		run.run(); 
		System.out.println(Runnable.LEG_NUM);
		
		//부모타입의 배열 만들어서 여러 자식객체를 제어
		Runnable[] runners = new Runnable[3];
		runners[0] = new Tiger();
		runners[1] = new Lion();
		runners[2] = new Bear();
		
		for(Runnable runner : runners) {
			runner.run();
		}
	}
	
	/**
	 * 메소드 Override의 강제화
	 * 	- 부모메소드를 추상메소드로 만들면 반드시 자식클래스에서 구현해야한다.
	 * 	- 구현하지 않으면 컴파일 오류를 유발한다.
	 * 
	 * 	- 1. 추상클래스의 추상메소드
	 * 	- 2. 인터페이스의 추상메소드
	 * 
	 * 	- 규격 : Animal의 모든 자식클래스는 say를 구현해야한다.
	 */
	public void test7() {
		Animal[] animals = new Animal[3];
		animals[0] = new Tiger();
		animals[1] = new Lion();
		animals[2] = new Bear();
		
		for(int i = 0; i < animals.length; i++) {
			animals[i].say();
			animals[i].attack();
			animals[i].run();
			
			System.out.println();
		}
		
		//추상클래스는 객체화 할 수 없다. (객체생성 할 수 없다)
//		Animal a = new Animal(); cannot instanciate
	}
	
	/**
	 * 정적바인딩 - CompileTime에 결정. 호출한 메소드의 실행타입별로 실행할 메소드가 결정되는 것
	 * 동적바인딩 - RunTime에 결정. 상속,오버라이드 : 다형성을 적용해 부모타입으로 오버라이드 된 메소드를 실행하면 
	 * 						    자식 클래스의 오버라이드 된 메소드가 호출된다.
	 */
	public void test6() {
		// 정적바인딩
		Tiger tiger = new Tiger();
		
		tiger.say();
		
		System.out.println();
		
		// 동적바인딩
		Animal animal2 = new Tiger(); //Tiger이지만 Animal인척중
		animal2.say();
		System.out.println();
		
		// 동적바인딩 사용
		Animal[] arr = new Animal[3];
		arr[0] = new Tiger();
		arr[1] = new Lion();
		arr[2] = new Lion();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].say();
			arr[i].attack();
		}
	}
	
	/**
	 * 다형성의 활용 2 - 리턴타입
	 * 리턴타입에 부모클래스가 있고, 자식클래스가 값으로 리턴된다. 
	 *  -> 그 값이 새로운 Animal객체 animal에 대입된다.
	 */
	public void test5() {
		Animal animal = generateAnimal();
		System.out.println(animal);
	}
	
	public Animal generateAnimal() {
		Random rnd = new Random();
		if(rnd.nextBoolean())
			return new Tiger();
		else
			return new Lion();
		
	}
	
	/**
	 * 다형성의 활용 1 - 메소드의 매개변수 선언부에서 사용
	 * 매개변수 선언부에 부모형태의 객체를 만들어두고 호출부에 자식객체로 받는다.
	 */
	public void test4() {
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		
		action(tiger);
		action(lion);
		
	}
	public void action(Animal animal) {
		if(animal instanceof Tiger) {
			((Tiger) animal).punch();
		}
		else if(animal instanceof Lion) {
			((Lion) animal).kick();
		}
	}
	//원래는 이렇게 작성했었음. action method 오버로딩 
//	public void action(Tiger tiger) {}
//	public void action(Lion lion) {}
	
	
	/**
	 * 부모타입의 변수로 모든 자식타입객체를 다룰 수 있다.
	 *  -> 부모타입의 배열을 만들어서 여러 자식 객체를 제어할 수 있다.
	 */
	public void test3() {
		
		//변수 a에는 Animal 또는 Animal의 자식 클래스는 다 대입 가능하다.
		Animal a = null;
		a = new Tiger();
		a = new Lion();
		
		Animal[] arr = new Animal[3];
		arr[0] = new Tiger();
		arr[1] = new Lion();
		arr[2] = new Tiger();
		
		for(Animal animal : arr) {
			System.out.println(animal + " [" + (animal instanceof Tiger) + "]");
			//객체 instanceof 클래스 : 객체가 해당 클래스타입으로 형변환이 가능하면 true를 반환
			//객체타입이 어느 타입인지 확인할 때
			
			if(animal instanceof Tiger) {
				((Tiger)animal).punch();
			}
			else {
				((Lion)animal).kick();
			}
			
		}
		System.out.println();
		
		//instanceof : 해당 객체 타입으로 형변환 가능한가? (큰->작)
		Tiger tiger = new Tiger();
		System.out.println(tiger instanceof Tiger); //true
		System.out.println(tiger instanceof Animal); //true
		System.out.println(tiger instanceof Object); //true
		
		
	}
	
	/**
	 * Tiger객체를 담을 수 있는 타입 형태
	 * - Object
	 * 	- Animal
	 * 	 - Tiger 	
	 *
	 */
	public void test2() {
		Tiger tiger = new Tiger();
		Animal animal = tiger;
		Object object = tiger;
		
		// tiger : Tiger, Animal, Object 필드,메소드 모두 사용 가능
		tiger.punch(); 	// Tiger#punch
		tiger.say();		// Animal#say
		System.out.println(tiger.hashCode());	// Object#hashCode
		
		// animal : Animal, Object 필드,메소드 모두 사용 가능
		animal.say();
		System.out.println(animal.hashCode());	// Object#hashCode
		
		// object : Object 필드,메소드 모두 사용 가능
		System.out.println(object.hashCode());	// Object#hashCode
		
		
	}
	
	/**
	 * 다형성
	 * 	- 자식 객체를 부모타입의 변수에 담아 제어할 수 있다.
	 * 	- 부모타입의 변수에 담게되면 부모클래스에 선언된 필드,메소드만 사용 가능하다
	 */
	public void test1() {
		Tiger tiger = new Tiger();
		// UpCasting(자식 -> 부모) ; 자동 형변환
		Animal animal1 = tiger;
		
		Animal animal2 = new Lion();
		
		// 자식객체를 자식타입의 변수에 대입한 경우 
		tiger.say();
		tiger.punch();
		
		// 자식객체를 부모타입의 변수에 대입한 경우 : 자식클래스에 선언한 필드,메소드에 접근할 수 없다.
		// Tiger 가 Animal인 척 함 -> 그래서 Punch 못씀
		animal1.say();
//		animal1.punch();
		
		// 자식클래스의 메소드를 사용하고 싶다면, 다시 자식타입으로 형변환해야 한다.
		// DownCasting (부모 -> 자식) ; 명시적 형변환
		((Tiger)animal1).punch();
		
		animal2.say();
		((Lion)animal2).kick();
		
		
	}

}
