package Fundamentals;

public class Main {

	public static void main(String[] args) {
		
		Employee e = new Employee("Hector","Salera","Overloading Constructors","Davao City","Male",18);
		Employee e1 = new Employee("Antidisestablishmentarianism","ZTYPE","Programmer");
		Employee e2 = new Employee();
		System.out.println(e.firstName);
		System.out.println(e1.firstName);
		System.out.println(e2.firstName);
		
	}
	

}
