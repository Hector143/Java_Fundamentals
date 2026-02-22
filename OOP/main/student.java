package main;

public class student {
	
	String firstName;
	String lastName;
	String year;
	String course;
	String section;
	float midtermGrade;
	float finalGrade;
	
	
	student(String firstName ,String lastName,String course,String year ,String section, float midtermGrade, float finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.year = year;
		this.section = section;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
		
	}
	void introduceSelf() {
		System.out.println("Full name	: " + firstName + " " + lastName);
		System.out.println("Course		: " + course );
		System.out.println("Year		: " + year );
		System.out.println("Section		: " + section );
		
		
	}
	void evaluateGrade() {
		System.out.println("\nFull name	: " + firstName + " " + lastName);
		float average = (midtermGrade + finalGrade) / 2;
		System.out.println("Average		: " + average);
// 		my version but its more complicated compare to the original one.
//		if (average > 100) 
//			System.out.println("Remarks		: Invalid Grade");
//		 else if (average > 97.99) 
//			System.out.println("Remarks		: With Highest Honors");
//		 else if (average > 94.99) 
//			System.out.println("Remarks		: With High Honors");
//		 else if (average > 89.99) 
//			System.out.println("Remarks		: With Honors");
//		 else if (average > 74.99) 
//			System.out.println("Remarks		: Passed ");
//			
//		 else if (average < 75.00) 
//			System.out.println("Remarks		: Failed");
//		
		String remarks = " ";
		
		if (average > 100) remarks = "Invalid Grade";
		else if (average >= 98) remarks = "With Highest Honors";
		else if (average >= 95) remarks = "With High Honors";
		else if (average >= 90) remarks = "With Honors";
		else if (average >= 75) remarks = "Passed";
		else remarks = "Failed";
		
		System.out.println("Remarks		: "+ remarks);
		
	}

}
