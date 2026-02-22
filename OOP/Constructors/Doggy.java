package Constructors;

public class Doggy {

	int countBark;
	
	public void bark() {
		countBark++;		
		System.out.println("Bark!");
	}
	
	public void showCount() {
		System.out.println("Bark Count: " + countBark);
	}
	public static void main(String[] args) {
		Doggy dog = new Doggy();
		dog.bark();
		dog.bark();
		dog.bark();
		dog.bark();
		dog.showCount();
		// the dog count 4 because it is called 4 times.

	}

}
