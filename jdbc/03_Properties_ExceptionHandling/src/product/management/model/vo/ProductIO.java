package product.management.model.vo;

import java.sql.Timestamp;

public class ProductIO {
	private int no;
	private String id;
	private String name;
	private String brand;
	private int count;
	private String status;
	private Timestamp ioDatetime;
	public ProductIO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductIO(int no, String id, String name, String brand, int count, String status, Timestamp ioDatetime) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.count = count;
		this.status = status;
		this.ioDatetime = ioDatetime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getIoDatetime() {
		return ioDatetime;
	}
	public void setIoDatetime(Timestamp ioDatetime) {
		this.ioDatetime = ioDatetime;
	}
	
	
}
