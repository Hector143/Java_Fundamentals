package OOP_Exercise_Problems;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Ean Craig",11);
		Person p2 = new Person("Evan Ross",12);
		
		
		System.out.println(p1.getName() + " is " + p1.getAge() + " years old.");
		System.out.println(p2.getName() + " is " + p2.getAge() + " years old.");
		
		
		System.out.println("\nSet new age and name: ");
		
		p1.setAge(14);
		p2.setName("Lewis Jordan");
		p2.setAge(12);
		
		System.out.println(p1.getName() + " is now " + p1.getAge() + " years old.");
		System.out.println(p2.getName() + " is now " + p2.getAge() + " years old.");
	
	}

}
