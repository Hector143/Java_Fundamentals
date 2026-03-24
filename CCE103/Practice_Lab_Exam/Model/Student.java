package Practice_Lab_Exam.Model;

public class Student {
	private String studentID; // jTextField
	private String studentName; // textfield
	private String course; // jcombobox
	private String yearLevel; // jComboBox
	private String subject; // jtextfield
	private byte midtermGrade; // jtextfield
	private byte finalGrade; // jtextfield
	private double finalAverage; // jtextfield
	private String remarks; // jtextfield or textarea (optional)
	
	public Student(String studentID, String studentName, String course,
			String yearLevel, String subject, byte midtermGrade, byte finalGrade,
			double finalAverage, String remarks) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.course = course;
		this.yearLevel = yearLevel;
		this.subject = subject;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
		this.finalAverage = finalAverage;
		this.remarks = remarks;
	}
	
	// ====== Getters and Setters part ====== //
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public byte getMidtermGrade() {
		return midtermGrade;
	}

	public void setMidtermGrade(byte midtermGrade) {
		this.midtermGrade = midtermGrade;
	}

	public byte getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(byte finalGrade) {
		this.finalGrade = finalGrade;
	}

	public double getFinalAverage() {
		return finalAverage;
	}

	public void setFinalAverage(double finalAverage) {
		this.finalAverage = finalAverage;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/* ==== for >ArrayList< to >File< ==== */ 
	public String toFileString() {
		return studentID + "|" + studentName + "|" +
				course + "|" + yearLevel + "|" +
				subject + "|" + midtermGrade + "|" +
				finalGrade + "|" + finalAverage + "|" +
				remarks;
	}
	
	public double calculateAverage(byte midtermGrade, byte finalGrade, double finalAverage) {
		return 0;
	}
	
	public void displayStudent() {
		
	}

	
}
