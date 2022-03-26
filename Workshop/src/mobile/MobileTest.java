package mobile;

public class MobileTest {

	public static void main(String[] args) {
		//각각의 Mobile 객체 생성
		Mobile ltab = new Ltab("Ltab", 500, "AP-01");
		Mobile otab = new Otab("Otab", 1000, "AND-20");
		
		//생성된 객체의 정보 출력
		String str = "   Mobile\tBattery\t\tOS\n"
					+ "----------------------------------------";
		System.out.println(str);
		System.out.println("   " + ltab.getMobileName() + "\t\t" + ltab.getBatterySize() + "\t\t" + ltab.getOsType());
		System.out.println("   " + otab.getMobileName() + "\t\t" + otab.getBatterySize() + "\t\t" + otab.getOsType());
		
		//각각의 Mobile객체에 10분씩 충전
		ltab.charge(10);
		otab.charge(10);
		
		//10분 충전 후 객체 정보 출력
		System.out.println("10분 충전");
		System.out.println(str);
		System.out.println("   " + ltab.getMobileName() + "\t\t" + ltab.getBatterySize() + "\t\t" + ltab.getOsType());
		System.out.println("   " + otab.getMobileName() + "\t\t" + otab.getBatterySize() + "\t\t" + otab.getOsType());
		
		//각각의 Mobile객체에 5분씩 사용
		ltab.operate(5);
		otab.operate(5);
		
		//5분 사용 후 객체 정보 출력
		System.out.println("5분 통화");
		System.out.println(str);
		System.out.println("   " + ltab.getMobileName() + "\t\t" + ltab.getBatterySize() + "\t\t" + ltab.getOsType());
		System.out.println("   " + otab.getMobileName() + "\t\t" + otab.getBatterySize() + "\t\t" + otab.getOsType());
		
	}

}
