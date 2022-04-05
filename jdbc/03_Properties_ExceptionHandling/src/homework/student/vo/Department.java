package homework.student.vo;

public class Department {
	private String departmentNo;
	private String departmentName;
	private String category;
	private String openYN;
	private int capacity;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String departmentNo, String departmentName, String category, String openYN, int capacity) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
		this.openYN = openYN;
		this.capacity = capacity;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpenYN() {
		return openYN;
	}
	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
