package OOP_Exercise_Problems.OOP_Problem_2;

public class Main {

	public static void main(String[] args) {
		Dog d1 = new Dog("Buddy", "Golden Retriever");
		Dog d2 = new Dog("Charlie", "Bulldog");
		
		System.out.println(d1.getName() + " is a " + d1.getBreed() + ".");
		System.out.println(d2.getName() + " is a " + d2.getBreed() + ".");
		
		d1.setBreed("Labrador Retriever");
		d2.setName("Daisy");
		
		System.out.println("\nSet the new Breed of dog1 and new name of dog2:");
		System.out.println(d1.getName() + " is now a " + d1.getBreed() + ".");
		System.out.println(d2.getName() + " is now a " + d2.getBreed() + ".");
	}

}
