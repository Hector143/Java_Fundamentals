package Constructors;

public class student {
	
	String name;
	int age;
	double gpa;
	boolean isEnrolled;
	
	student(String a, int b, double c) {
		this.name = a;
		this.age = b;
		this.gpa = c;
		this.isEnrolled = true;
	}
	
	void study() {
		System.out.println(this.name + " is studying.");
	}
	
	void eating() {
		System.out.println(this.name + " is eating.");
	}
	void sleeping() {
		System.out.println(this.name + " is sleeping.");
	}
}
