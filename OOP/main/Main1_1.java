package main;

public class Main1_1 {

	public static void main(String[] args) {
		// constructor = special method that is called when an object is instantiated (created)
		Human human = new Human("Rick",18,55); 
		Human human2 = new Human("Hatton",26,58); 
		
		human.eat();
		human2.drink();
		
		System.out.println(human2.age);
	}

}
