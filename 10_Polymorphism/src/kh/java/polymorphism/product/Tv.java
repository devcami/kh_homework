package kh.java.polymorphism.product;

public class Tv extends Product {
	
	private String resolution;
	private int size;
	
	public Tv() {
		super();
	}

	public Tv(String brand, String code, String name, int price, String resolution, int size) {
		super(brand, code, name, price);
		this.resolution = resolution;
		this.size = size;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String getProductInfo() {
		return super.getProductInfo() + resolution + ", " + size;
	}
	
	
}
