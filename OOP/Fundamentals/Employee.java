package Fundamentals;

public class Employee {
	String firstName, lastName;
	String title, address, Gender;
	int age;
	
	Employee() 
	{
		firstName = "N/A";
		lastName = "N/A";
		title = "N/A";
		address = "N/A";
		Gender = "N/A";
		age = 0;
	}
	Employee(String firstName, String lastName, String title) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		address = "N/A";
		Gender = "N/A";
		age = 0;
	}
	Employee(String firstName,
			String lastName,
			String title,
			String address,
			String Gender,
			int age) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.address = address;
		this.Gender = Gender;
		this.age = age;
	}
	// you can use getters instead of replacing private to public in global variables
}
