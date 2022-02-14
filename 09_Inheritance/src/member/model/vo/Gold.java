package member.model.vo;

public class Gold extends Member {
	
	public Gold() {
		super();
	}
	
	public Gold(String name, String grade, int point) {
		super(name, grade, point);
		getEjaPoint();
	}
	
	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.05;
	}


}
