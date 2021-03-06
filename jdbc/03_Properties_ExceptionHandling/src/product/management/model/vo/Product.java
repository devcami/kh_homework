package product.management.model.vo;

import java.sql.Date;

public class Product {
	private String id;
	private String brand;
	private String name;
	private int price;
	private int monitorSize;
	private String os;
	private int storage;
	private Date regDate;
	private int stock;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String brand, String name, int price, int monitorSize, String os, int storage,
			Date regDate) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.monitorSize = monitorSize;
		this.os = os;
		this.storage = storage;
		this.regDate = regDate;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public int getMonitorSize() {
		return monitorSize;
	}

	public void setMonitorSize(int monitorSize) {
		this.monitorSize = monitorSize;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
