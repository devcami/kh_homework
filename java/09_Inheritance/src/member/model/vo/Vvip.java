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


}
