package member.model.vo;

public class Vip extends Member {
	
	public Vip() {
		super();
	}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.1;
	}
	@Override
	public String getMemberInfo() {
		return super.getMemberInfo() + getEjaPoint();
	}

	@Override
	public int buy(int price) {
		return (int)(price - (price * 0.1));
	}
	
	@Override
	public String getBuyInfo(int price) {
		return super.getBuyInfo(price) + this.buy(price) + "원에 구매합니다.";
	}

}
