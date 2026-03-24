package Student_Record_System.Model;

public class Student_M {
	private String studentId;
	private String firstName;
	private String lastName;
	private String courseCode;
	private int mathematic;
	private int english;
	private int biology;
	private int infoTech;
	private int chemistry;
	private int physic;
	private int totalScore;
	private int average;
	private String ranking;

	public Student_M(String studentId, String firstName, String lastName, String courseCode, int mathematic,
			int english, int biology, int infoTech, int chemistry, int physic, int totalScore, int average,
			String ranking) {
		setStudentId(studentId);
		setFirstName(firstName);
		setLastName(lastName);
		setCourseCode(courseCode);
		setMathematic(mathematic);
		setEnglish(english);
		setBiology(biology);
		setInfoTech(infoTech);
		setChemistry(chemistry);
		setPhysic(physic);
		setTotalScore(totalScore);
		setAverage(average);
		setRanking(ranking);
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getMathematic() {
		return mathematic;
	}

	public void setMathematic(int mathematic) {
		this.mathematic = mathematic;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public int getInfoTech() {
		return infoTech;
	}

	public void setInfoTech(int infoTech) {
		this.infoTech = infoTech;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getPhysic() {
		return physic;
	}

	public void setPhysic(int physic) {
		this.physic = physic;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String toFileString() {
		return studentId + "|" + firstName + "|" +
				lastName + "|" + courseCode + "|" +
				mathematic + "|" + english + "|" +
				biology + "|" + infoTech + "|" +
				chemistry + "|" + physic + "|" +
				totalScore + "|" + average + "|" +
				ranking ;
	}

	public Object[] getFileInfo() {
		Object[] info = {getStudentId(), getFirstName(),
				getLastName(), getRanking(), getMathematic(),
				getEnglish(), getBiology(), getInfoTech(),
				getChemistry(), getPhysic(), getCourseCode(),
				getTotalScore(), getAverage()
		};
		return info;
	}
	
	public String getTranscript() {
		return "Student Result Recording System\n"
				+ "\nFull Name: " + getFirstName() + " " + getLastName()
				+ "\tID: " + getStudentId()
				+ "\n===================================="
				+ "\nMathematic: " + getMathematic()
				+ "\nEnglish: " + getEnglish()
				+ "\nBiology: " + getBiology()
				+ "\nInfo Tech: " + getInfoTech()
				+ "\nChemistry: " + getChemistry()
				+ "\nPhysic: " + getPhysic()
				+ "\n===================================="
				+ "\nTotal Score: " + getTotalScore()
				+ "\nAverage: " + getAverage()
				+ "\nRanking: " + getRanking();
	}

}
