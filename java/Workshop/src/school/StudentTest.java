package school;

public class StudentTest {

	public static void main(String[] args) {
		Student studentArray [] = new Student[3];
		//Student 객체를 3개 생성하여 배열에 넣는다
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		
		double sumAge = 0;
		double sumHeight = 0;
		double sumWeight = 0;
		
		//배열에 있는 객체 정보를 모두 출력
		System.out.println("이름\t나이\t신장\t몸무게");
		for(Student s : studentArray) {
			System.out.println(s.getName() + "\t" + s.getAge() + "\t" + s.getHeight() + "\t" + s.getWeight());
			sumAge += s.getAge();
			sumHeight += s.getHeight();
			sumWeight += s.getWeight();
		}
		
		//나이의 평균 출력
		System.out.printf("나이의 평균 : %.2f%n", sumAge / studentArray.length);
		System.out.printf("신장의 평균 : %.2f%n", sumHeight / studentArray.length);
		System.out.printf("몸무게의 평균 : %.2f", sumWeight / studentArray.length);
	}

}
