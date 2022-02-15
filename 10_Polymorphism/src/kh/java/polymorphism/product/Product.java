package kh.java.polymorphism.product;

/**
 *  Desktop, SmartPhone, Tv의 공통적인 속성/기능을 가지고 있는 부모클래스
 *
 */
public class Product {
	
	private String brand;
	private String code;
	private String name;
	private int price;
	
	public Product() {
		super();
	}

	public Product(String brand, String code, String name, int price) {
		super(); // 지워도 있는것과 동일함 
		this.brand = brand;
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getProductInfo() {
		return brand + ", " + code + ", " + name + ", " + price + ", " ;
	}
	
}
