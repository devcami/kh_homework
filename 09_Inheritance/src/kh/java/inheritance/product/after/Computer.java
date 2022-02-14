package kh.java.inheritance.product.after;

public class Computer {
	
	private String brand;
	private String code;
	private String name;
	private int price;
	private String os;
	
	public Computer() {
		super();
	}

	public Computer(String brand, String code, String name, int price, String os) {
		super();
		this.brand = brand;
		this.code = code;
		this.name = name;
		this.price = price;
		this.os = os;
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

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}	
	
	public String getComputerInfo() {
		return brand + ", " + code + ", " + name + ", " + price + ", " + os + ", ";
	}

}
