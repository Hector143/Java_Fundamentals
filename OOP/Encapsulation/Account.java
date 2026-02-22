package Encapsulation;

public class Account {

	String name;
	int age;
	
	public static void main(String[] args) {
		// Getters and Setters
		// Getters and setters basically let you get and set variables inside a class
		// a class represents an object
		// we represent a real object but we are in a computer world;
		Account a = new Account();

		a.setName("Pablo");
		a.setAge(34);
		System.out.println(a.getName());
		System.out.println(a.getAge());
		
		a.printDetails();
	}
	
	// Bonus Tips: you dont have to type all of this getters and setters
	// you could get this by just right clicking and pressing source and then generate getters and setters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void printDetails() {
		System.out.println(name + ", " + age);
		
	}


}
