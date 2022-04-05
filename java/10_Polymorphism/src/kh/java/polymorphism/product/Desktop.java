package kh.java.polymorphism.product;

public class Desktop extends Computer{
	
	
	private String monitor;
	private String keyboard;
	private String mouse;
	
	public Desktop() {
		super();
	}
	
	public Desktop(String brand, String code, String name, int price,
			String os, String monitor, String keyboard, String mouse) {
		
		// 1. setter를 이용해서 private 필드에 값 대입하는 방법. 
//		setBrand(brand);
//		setCode(code);
//		setName(name);
//		setPrice(price);
		
		// 2. 부모생성자를 호출 : 생성자에 딱 한번, 맨 윗줄에서만 사용가능
		// this와 같이 사용불가. 생략해도 자동으로 super()가 호출된다.
		super(brand, code, name, price, os);
		
		this.monitor = monitor;
		this.keyboard = keyboard;
		this.mouse = mouse;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getKeyboard() {
		return keyboard;
	}
	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}
	public String getMouse() {
		return mouse;
	}
	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	
	/**
	 * brand, code, name, price는 상속받았지만,
	 * private field라 직접 접근할 수 없기 때문에 public get메소드 사용
	 */
	
	@Override
	public String getProductInfo() {
		return super.getProductInfo() + monitor + ", " + keyboard + ", " + mouse;
	}
	
	
	
}
