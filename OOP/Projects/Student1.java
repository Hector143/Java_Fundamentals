package Projects;

public class Student1 {
	private String name;
	private double[] grades;
	
	public Student1(String name, double[] grades) {
		this.name = name;
		this.grades = grades;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double[] getGrades() {
		return grades;
	}

	void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	
}
