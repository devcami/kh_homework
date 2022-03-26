package company;

public class Test02 {

	public static void main(String[] args) {
		double salary = Integer.parseInt(args[0]);
		Company com = new Company(salary);
		System.out.printf("연 기본금 합 : %.1f 세후 : %.1f%n", com.getIncome(), com.getAfterTaxIncome());
		System.out.printf("연 보너스 합 : %.1f 세후 : %.1f%n", com.getBonus(), com.getAfterTaxBonus());
		System.out.printf("연 지급액 합 : %.1f", com.getAfterTaxIncome() + com.getAfterTaxBonus());
	}

}
