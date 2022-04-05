package homework.student.vo;

import java.text.DecimalFormat;

public class Grade extends Student{
	private String termNo;
	private String classNo;
	private String studentNo;
	private double point;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String termNo, String classNo, String studentNo, double point) {
		super();
		this.termNo = termNo;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.point = point;
	}
	public String getTermNo() {
		return termNo;
	}
	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Grade [termNo=" + termNo + ", classNo=" + classNo + ", studentNo=" + studentNo + ", point=" + 
				new DecimalFormat("#.##").format(point)
				+ "]";
	}
	
	
}
