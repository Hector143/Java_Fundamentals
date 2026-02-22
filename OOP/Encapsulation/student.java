package Encapsulation;
// Entity
public class student {
	// Global variables
	private int studentID;
	private String firstname;
	private String lastname;
	private char Gender;
	//Constructors
	public student(int studentID, String firstname, String lastname, char Gender) {
		this.studentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.Gender = Gender;
	}
	// Getters
	
	public int getStudentID() {
		return this.studentID;
	}
	public String getStudentFirstName() {
		return this.firstname;
	}
	public String getStudentLastName() {
		return this.lastname;
	}
	public char getStudentGender() {
		return this.Gender;
	}
	
	// Setters
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public void setStudentFirstName(String firstname) {
		this.firstname = firstname;
	}

	public void setStudentLastName(String lastname) {
		this.lastname = lastname;
	}

	public void setStudentGender(char Gender) {
		this.Gender = Gender;
	}
	// overall setup


}
