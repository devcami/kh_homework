package member.model.vo;

public class Vvip extends Member {	
	
	public Vvip() {
		super();
	}

	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.15;
	}

	@Override
	public String getMemberInfo() {
		return super.getMemberInfo() + getEjaPoint();
	}

	@Override
	public int buy(int price) {
		return (int)(price - (price * 0.15));
	}
	@Override
	public String getBuyInfo(int price) {
		return super.getBuyInfo(price) + this.buy(price) + "원에 구매합니다.";
	}
}
