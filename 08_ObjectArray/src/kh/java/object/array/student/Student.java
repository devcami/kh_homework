package kh.java.object.array.student;

/**
 *	VO class (데이터를 담을 용도)
 *
 *	- 학생번호
 *	- 학생이름
 *	- 자바점수 
 *
 */
public class Student {
	private int studentNo;
	private String studentName;
	private int javaScore;
	
	public Student() {
		
	}
	
	public Student(int studentNo, String studentName, int javaScore) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.javaScore = javaScore;
	}
	
	
	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	
	public String getStudentInfo() {
		return "Student[" + studentNo + ". name : " + studentName + ", java score : " + javaScore + "]";
	}
	
	
}
