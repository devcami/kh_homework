package ncs.test3;

public class TvTest {
	public static void main(String[] args) {
		Tv tvArray[] = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D");
		
		for(Tv tv : tvArray) {
			System.out.println(tv);
		}
		
		// 가정
		int min = 0;
		int max = 0;
		
		for(int i = 0; i < tvArray.length; i++) {
			if(tvArray[min].getPrice() > tvArray[i].getPrice()) {
				min = i;
			}
			if(tvArray[max].getPrice() < tvArray[i].getPrice()) {
				max = i;
			}
		}
		System.out.println("가격이 가장 비싼 제품 : " + tvArray[max].getName()  );
		System.out.println("가격이 가장 저렴한 제품 : " + tvArray[min].getName()  );
	}
}
