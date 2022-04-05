package kh.java.polymorphism.product;

public class ProductMain {

	public static void main(String[] args) {
		ProductMain main = new ProductMain();
		Product[] products = main.test1(); //Product[3] - Desktop, SmartPhone, Tv
		
		main.test2(products); //제품별 정보를 출력
		
	}

	public void test2(Product[] product) {
		
		for(int i = 0 ; i < product.length; i++) {
			System.out.println(product[i].getProductInfo());
		}
		
	}
	public Product[] test1() {
		// Product[] 생성
		Product[] products = new Product[3];
		
		products[0] = new Desktop("삼성", "ss-123462342", "울트라데스크탑", 1_000_000, 
								  "Windows11", "커브드모니터", "기계식키보드","버티컬마우스");
		products[1] = new SmartPhone("애플", "app-45437234", "iPhone13-Pro", 1_300_000, "iOS15", "KT");
		products[2] = new Tv("LG", "lg-3462344", "QLED TV", 3_000_000, "UHD", 80);
		
		return products;
		
	}

}
