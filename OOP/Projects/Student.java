package Projects;

public class Student {
	private String name;
	private double[] grades;
	
	public Student(String name, double[] grades) {
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
